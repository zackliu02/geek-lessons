package com.zackliu.spring.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

public class ConditionalConfig {
    @Conditional(MacCondition.class)
    @Bean
    public ConditionalExample getConditionalExample() {
        return new ConditionalExample();
    }
}
