package com.co.diaz.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages ={
        "com.co.diaz.commonservice.models.entity",
        "com.co.diaz.curso.models.entity"})
@ComponentScan({"com.co.diaz.commonservice.models.entity","com.co.diaz.curso.models.entity"})
@EnableJpaRepositories({"com.co.diaz.commonservice.models.entity","com.co.diaz.curso.models.entity"})
@EntityScan({"com.co.diaz.commonservice.models.entity","com.co.diaz.curso.models.entity.*"})
public class CursoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CursoApplication.class, args);
    }

}
