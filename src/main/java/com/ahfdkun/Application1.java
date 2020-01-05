package com.ahfdkun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@EnableAutoConfiguration
public class Application1 {

    @Bean
    String a() {
        return "s-a";
    }

    @Bean
    @Group
    String b() {
        return "s-b";
    }

    @Bean
    @Group
    String c() {
        return "s-c";
    }

    @Autowired
    private List<String> stringBeans = Collections.emptyList();

    @Autowired
    @Group
    private Map<String, String> stringStringMap = Collections.emptyMap();

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("--------stringBeans: " + stringBeans);
            System.out.println("--------stringStringMap: " + stringStringMap);
        };
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application1.class).bannerMode(Banner.Mode.OFF)
                .web(false)
                .run(args);
    }
}

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier
@interface Group {
}
