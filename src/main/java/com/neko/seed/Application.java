package com.neko.seed;

import com.neko.seed.base.config.MusselConfiguration;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(scanBasePackages = {
        "com.neko.seed"
})
@MapperScan(basePackages = "com.neko.seed", annotationClass = Mapper.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}