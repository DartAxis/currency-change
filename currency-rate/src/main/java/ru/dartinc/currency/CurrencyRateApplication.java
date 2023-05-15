package ru.dartinc.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CurrencyRateApplication {


    public static void main(String[] args) {
        SpringApplication.run(CurrencyRateApplication.class, args);
    }

}
