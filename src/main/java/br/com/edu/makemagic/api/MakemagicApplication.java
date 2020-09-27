package br.com.edu.makemagic.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MakemagicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakemagicApplication.class, args);
    }

}
