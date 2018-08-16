package com.cdy.mq.controller;

import com.cdy.mq.mongo.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class mongoController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/save")
    public void save(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setAge(15);
        sendMessage.setName("aaaa");
        mongoTemplate.save(sendMessage);
    }
}
