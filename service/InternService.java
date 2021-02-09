package com.example.demoRedisTemplate.service;

import com.example.demoRedisTemplate.entity.Intern;
import org.springframework.stereotype.Repository;

import java.util.Map;


public interface InternService {
    void save(Intern intern);
    Map<String, Intern> findAll();
    String findById(String id);
    void update(Intern user);
    void delete(String id);
}
