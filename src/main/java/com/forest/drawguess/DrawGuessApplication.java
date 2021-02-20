package com.forest.drawguess;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.forest.drawguess.mapper")
@SpringBootApplication
public class DrawGuessApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrawGuessApplication.class, args);
    }

}
