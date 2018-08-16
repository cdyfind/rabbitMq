package com.cdy.mq.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class CorrelationData extends org.springframework.amqp.rabbit.support.CorrelationData  {

    /**
     * 消息体
     */
    private volatile Object message;

    /**
     * 交换机名称
     */
    private String exchange;

    /**
     * 路由key
     */
    private String routingKey;

    /**
     * 重试次数
     */
    private int retryCount = 0;

    public CorrelationData(String id) {
        super(id);
    }

    public CorrelationData(String id, Object data) {
        this(id);
        this.message = data;
    }

}
