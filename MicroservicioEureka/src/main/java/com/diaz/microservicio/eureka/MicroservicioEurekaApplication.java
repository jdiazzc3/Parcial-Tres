package com.diaz.microservicio.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicioEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioEurekaApplication.class, args);
    }

}
