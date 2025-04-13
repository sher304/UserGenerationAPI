package org.example.usergenerationapi;

import net.datafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserGenerationApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserGenerationApiApplication.class, args);
    }

    @Bean
    public Faker getFaker() {
        return new Faker();
    }

}
