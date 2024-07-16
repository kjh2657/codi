package com.musinsa.codi.api;

import com.musinsa.codi.core.config.YamlPropertySourceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@PropertySource(
        value = {
                "classpath:application-core.yml",
                "classpath:application-core-${spring.profiles.active}.yml"
        }, factory = YamlPropertySourceFactory.class)
@ComponentScan({"com.musinsa.codi.core", "com.musinsa.codi.api"})

@SpringBootApplication
public class CodiApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodiApiApplication.class, args);
    }
}