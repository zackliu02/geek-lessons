package com.zackliu.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "school")
public class SchoolProperties {
    private int klassNum;
    private int studentNum;

    private String klassNamePrefix;
    private String studentNamePrefix;
}
