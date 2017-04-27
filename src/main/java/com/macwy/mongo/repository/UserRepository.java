package com.macwy.mongo.repository;

import com.macwy.mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author macwy
 * @Title:SpringBootMongo
 * @Package com.macwy.mongo.repository
 * @Description
 * @date 2017/4/26 16:24
 * @Version 1.0
 */
public interface UserRepository extends MongoRepository<User,String> {
}
