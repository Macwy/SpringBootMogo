package com.macwy.mongo.service;

import com.macwy.mongo.domain.User;

import java.util.List;

/**
 * @author macwy
 * @Title:SpringBootMongo
 * @Package com.macwy.mongo.service
 * @Description Mongo template
 * @date 2017/4/26 15:40
 * @Version 1.0
 */
public interface UserService {

    /**
     * 根据描述模糊查询
     * @param description
     * @return
     */
    User  findUserByDescription(String description);


    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<User> findUsersByPageSize(Integer pageIndex, Integer pageSize);


    /**
     * 查询数组中含有指定数据的数据
     * @param tags
     * @return
     */
    List<User> findUsersByTags(String[] tags);

}
