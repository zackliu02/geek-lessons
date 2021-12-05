package com.zackliu.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CodeGeneratorConfig {
    @Bean
    public CodeGeneratorExample getCodeExample() {
        return new CodeGeneratorExample();
    }
}
