package com.meijia.rocketmq.producer;

import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kaiser
 */
@RestController
public class RocketMqApi {

    private static final Logger logger = Logger.getLogger(RocketMqApi.class);

    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    public RocketMqApi(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    @GetMapping("api/rpc/send/message")
    public String sendMessage() {
        rocketMQTemplate.convertAndSend("wawa", "id is " + RandomUtils.nextInt());
        return "success";
    }
}
