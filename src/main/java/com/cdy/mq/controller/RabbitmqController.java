package com.cdy.mq.controller;

import com.alibaba.fastjson.JSONObject;
import com.cdy.mq.constants.RabbitConstants;
import com.cdy.mq.mongo.SendMessage;
import com.cdy.mq.sender.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class RabbitmqController {
    @Autowired
    private RabbitSender rabbitSender;

    @RequestMapping("/send")
    public Object sendMsg(String name) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setId(1);
        sendMessage.setAge(20);
        sendMessage.setName(name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sendMessage",sendMessage);
        String ss = jsonObject.toJSONString();
        rabbitSender.sendMessage(RabbitConstants.MQ_EXCHANGE_SEND_AWARD, RabbitConstants.MQ_ROUTING_KEY_SEND_COUPON, ss);
        return "发送成";
    }
}
