package com.zackliu.starter;

import lombok.Data;

import java.util.List;

@Data
public class Klass {
    private int id;
    private String name;
    private List<Student> students;

    public Klass(int id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }
}
