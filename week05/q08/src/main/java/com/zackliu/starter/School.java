package com.zackliu.starter;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private List<Klass> klasses;

    public School(List<Klass> klasses) {
        this.klasses = klasses;
    }
}
