package com.ll.sblock20240304;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SbLock20240304Application {

    public static void main(String[] args) {
        SpringApplication.run(SbLock20240304Application.class, args);
    }

}
