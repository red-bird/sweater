package com.example.sweater.controller;

import com.example.sweater.domain.MongoEntities.MongoMessage;
import com.example.sweater.domain.PostgresEntities.PostgresMessage;
import com.example.sweater.repos.MongoRepo.MongoMessageRepo;
import com.example.sweater.repos.PostgresRepo.PostgresMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private PostgresMessageRepo messageRepo;
//    private MongoMessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model){

    return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<PostgresMessage> messages = messageRepo.findAll();
//        Iterable<MongoMessage> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String,
            Object> model){
        PostgresMessage message = new PostgresMessage(text, tag);
//        MongoMessage message = new MongoMessage(text, tag);
        messageRepo.save(message);

        Iterable<PostgresMessage> messages = messageRepo.findAll();
//        Iterable<MongoMessage> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<PostgresMessage> messages;
//        Iterable<MongoMessage> messages;
        if (filter != null && !filter.isEmpty()){
             messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);

        return "main";
    }
}
