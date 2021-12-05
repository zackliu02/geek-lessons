package com.zackliu.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties(SchoolProperties.class)
@PropertySource("classpath:application.yaml")
public class SchoolAutoConfiguration {
    @Autowired
    private SchoolProperties properties;

    @Bean
    public School school() {
        int klassNum = properties.getKlassNum();
        int studentNum = properties.getStudentNum();
        String klassNamePrefix = properties.getKlassNamePrefix();
        String studentNamePrefix = properties.getStudentNamePrefix();

        List<Klass> klasses = new ArrayList<>();
        for (int i = 0; i < klassNum; i++) {
            List<Student> students = new ArrayList<>();
            for (int j = 0; j < studentNum; j++) {
                students.add(new Student(j, studentNamePrefix + j));
            }
            klasses.add(new Klass(i, klassNamePrefix + i, students));
        }
        return new School(klasses);
    }
}
