package com.example.sweater.domain.MongoEntities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class MongoMessage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public String id;

    private String text;
    private String tag;

    public MongoMessage() {}

    public MongoMessage(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
