package com.example;

import com.example.dao.EmployerDao;
import com.example.entity.Employer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(EmployerDao employerDao) {
        return args -> {
            employerDao.save(new Employer(1));
            employerDao.find(1).ifPresent(e -> log.info("Found is called: {}", e.getId()));
        };
    }

}
