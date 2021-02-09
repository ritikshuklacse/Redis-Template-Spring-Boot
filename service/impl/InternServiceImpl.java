package com.example.demoRedisTemplate.service.impl;

import com.example.demoRedisTemplate.entity.Intern;
import com.example.demoRedisTemplate.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InternServiceImpl implements InternService {

    @Autowired
    private RedisTemplate<String, Intern> redisTemplate;

    private HashOperations hashOperations;


    public InternServiceImpl(RedisTemplate<String, Intern> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Intern user) {
        hashOperations.put("USER", user.getId(), user.toString());
    }

    @Override
    public Map<String, Intern> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public String findById(String id) {
        return (String)hashOperations.get("USER", id);
    }

    @Override
    public void update(Intern user) {
        save(user);
    }

    @Override
    public void delete(String id) {

        hashOperations.delete("USER", id);
    }
}
