package dev.shiftsad.capag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CapagApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapagApplication.class, args);
    }
}
