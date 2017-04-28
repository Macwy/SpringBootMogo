package com.macwy.mongo.service.impl;

import com.macwy.mongo.domain.User;
import com.macwy.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author macwy
 * @Title:SpringBootMongo
 * @Package com.macwy.mongo.service.impl
 * @Description
 * @date 2017/4/26 15:58
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User findUserByDescription(String description) {

        Query query = new Query();
        Pattern pattern = Pattern.compile(".*"+description);

        Criteria criteria = new Criteria("description").regex(pattern);
        query.addCriteria(criteria);

       return  this.mongoTemplate.findOne(query,User.class,"user");

    }

    @Override
    public List<User> findUsersByPageSize(Integer pageIndex, Integer pageSize) {

        Query query = new Query();
        query.skip((pageIndex-1)*pageSize).limit(pageSize);

        return this.mongoTemplate.find(query,User.class,"user");
    }

    @Override
    public List<User> findUsersByTags(String[] tags) {

        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.where("tags").all(Arrays.asList(tags));

        query.addCriteria(criteria);
        return  this.mongoTemplate.find(query,User.class);
    }


    public  List<User> findByTitleOrBy(String title,String by){

        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(new Criteria("title").is(title),new Criteria("by").is(by));
        query.addCriteria(criteria);
        return this.mongoTemplate.find(query,User.class);

    }
}
