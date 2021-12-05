package com.zackliu.spring.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentExample {
    public void showInfo() {
        System.out.println("成功！包扫描+@Component注解方式");
    }
}
