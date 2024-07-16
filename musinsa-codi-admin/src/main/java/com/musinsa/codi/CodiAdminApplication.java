package com.musinsa.codi;

import com.musinsa.codi.core.config.YamlPropertySourceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource(
        value = {
                "classpath:application-core.yml",
                "classpath:application-core-${spring.profiles.active}.yml"
        }, factory = YamlPropertySourceFactory.class)
@ComponentScan({"com.musinsa.codi.core", "com.musinsa.codi.admin"})
@SpringBootApplication
public class CodiAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodiAdminApplication.class, args);
    }
}