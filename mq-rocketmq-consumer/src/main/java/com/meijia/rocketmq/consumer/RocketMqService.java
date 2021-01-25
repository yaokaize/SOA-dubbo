package com.meijia.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author kaiser
 */
@Component
@RocketMQMessageListener(topic = "wawa", consumerGroup = "rocketmq-group")
public class RocketMqService implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println(message);
    }
}
