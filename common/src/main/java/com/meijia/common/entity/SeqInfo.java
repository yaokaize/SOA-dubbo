package com.meijia.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 模拟序列类
 *
 * @author kaiser
 */
@Document(collection = "sequence")
@Data
@Setter
@Getter
public class SeqInfo {

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 集合名称
     */
    @Field
    private String collName;

    /**
     * 序列值
     */
    @Field
    private Long seqId;
}
