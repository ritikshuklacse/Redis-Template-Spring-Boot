package com.example.demoRedisTemplate.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Intern implements Serializable {
    private String id;
    private String name;
    private Long salary;

    public Intern(String id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Intern{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
