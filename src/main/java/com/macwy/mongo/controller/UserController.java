package com.macwy.mongo.controller;

import com.macwy.mongo.domain.User;
import com.macwy.mongo.repository.UserRepository;
import com.macwy.mongo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author macwy
 * @Title:SpringBootMongo
 * @Package com.macwy.mongo.controller
 * @Description
 * @date 2017/4/26 16:07
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    private  Logger userLogger = Logger.getLogger("userLogger");

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/findAll")
    public List<User> findOne(){
       return  userRepository.findAll();
    }

    /**
     * 根据描述模糊查询
     * @param description
     * @return
     */
    @RequestMapping(value = "/findUserByDescription")
    public  User  findUserByDescription(String description){

        return  userService.findUserByDescription(description);

    }


    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/findUsersByPageSize")
    List<User> findUsersByPageSize(Integer pageIndex, Integer pageSize){
        return  userService.findUsersByPageSize(pageIndex,pageSize);
    }


    /**
     * 查询数组中含有指定数据的数据
     * @param
     * @return
     */
    @RequestMapping(value = "/findUsersByTags")
    List<User> findUsersByTags(){
        logger.info("进入");
        logger.debug("info");
        userLogger.debug("info");

        String[] tags =new String[1];
        tags[0]= "mongodb";
        return  userService.findUsersByTags(tags);
    }

}
