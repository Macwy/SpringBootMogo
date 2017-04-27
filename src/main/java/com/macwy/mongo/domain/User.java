package com.macwy.mongo.domain;

import org.springframework.data.annotation.Id;

/**
 * @author macwy
 * @Title:SpringBootMongo
 * @Package com.macwy.mongo.domain
 * @Description 用户信息
 * @date 2017/4/26 15:39
 * @Version 1.0
 */
public class User {

    @Id
    private  String id;

    private  String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
