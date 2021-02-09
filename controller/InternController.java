package com.example.demoRedisTemplate.controller;

import com.example.demoRedisTemplate.entity.Intern;
import com.example.demoRedisTemplate.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/intern")
public class InternController {

    @Autowired
    private InternService internService;


    @GetMapping("/add/{id}/{name}")
    public String add(@PathVariable("id") final String id,
                      @PathVariable("name") final String name) {
        internService.save(new Intern(id, name, 20000L));
        return internService.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public String update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        internService.update(new Intern(id, name, 1000L));
        return internService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String,Intern> delete(@PathVariable("id") final String id) {
        internService.delete(id);
        return all();
    }

    @GetMapping("/all")
    public Map<String, Intern> all() {
        return internService.findAll();
    }
}
