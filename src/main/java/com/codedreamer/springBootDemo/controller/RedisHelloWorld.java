package com.codedreamer.springBootDemo.controller;


import com.codedreamer.springBootDemo.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 53137
 */
@RestController
public class RedisHelloWorld {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("redis/test")
    public String test() {
        redisTemplate.opsForValue().set("springBoot:redis", "hello");
        return (String) redisTemplate.opsForValue().get("springBoot:redis");
    }

    @RequestMapping("redis/addObject")
    public String addObject() throws JsonProcessingException {
        //User对象不序列化会导致添加失败
        User user = new User("lihaipeng", 18);
        //若user实现Serializable会添加失败
        //redisTemplate.opsForValue().set("springBoot:user", user.toString());
        //序列化方式一：
        String userJson = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("springBoot:user", userJson);
        //序列化方式二：User implements Serializable
        return (String) redisTemplate.opsForValue().get("springBoot:user");
    }
}
