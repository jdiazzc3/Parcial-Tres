package com.co.diaz.microserviciocurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
        "com.co.diaz.microserviciocurso",
        "com.co.diaz.libreria",
        "com.co.diaz.commonservice"
})
@ComponentScan({"com.co.diaz.commonservice.models.entity", "com.co.diaz.microserviciocurso.*"})
@EnableJpaRepositories({"com.co.diaz.commonservice.models.entity", "com.co.diaz.microserviciocurso.*"})
@EntityScan({"com.co.diaz.commonservice.models.entity", "com.co.diaz.microserviciocurso.*"})
public class MicroservicioCursoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioCursoApplication.class, args);
    }

}
