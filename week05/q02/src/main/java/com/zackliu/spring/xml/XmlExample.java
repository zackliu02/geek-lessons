package com.zackliu.spring.xml;

import lombok.Data;

@Data
public class XmlExample {
    private String name;

    public void showInfo() {
        System.out.println("成功！XML配置方式");
    }
}
