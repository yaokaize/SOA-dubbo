package com.meijia.common.listener;

import com.meijia.common.annotations.AutoIncKey;
import com.meijia.common.entity.SeqInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * @author kaiser
 */
@Component
public class MongoSaveEventListener extends AbstractMongoEventListener<Object> {

    private final static Logger logger = LoggerFactory.getLogger(MongoSaveEventListener.class);

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoSaveEventListener(@Qualifier("mongoTemplate") MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        final Object source = event.getSource();
        ReflectionUtils.doWithFields(source.getClass(), field -> {
            //将一个字段设置为可读写，主要针对private字段；
            ReflectionUtils.makeAccessible(field);
            // 如果字段添加了我们自定义的AutoValue注解
            if (field.isAnnotationPresent(AutoIncKey.class)
                    && field.get(source) instanceof Number
                    && (Long) field.get(source) == 0L) {
                // 设置自增ID
                field.set(source, getNextAutoId(source.getClass().getSimpleName()));
            }
        });
    }

    /**
     * 获取下一个自增ID
     * @param collName 集合名称
     * @return 自增ID
     */
    private Long getNextAutoId(String collName) {
        Query query = new Query(Criteria.where("collName").is(collName));
        Update update = new Update();
        update.inc("seqId", 1);
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.upsert(true);
        options.returnNew(true);
        SeqInfo seq = mongoTemplate.findAndModify(query, update, options, SeqInfo.class);
        return seq.getSeqId();
    }
}
