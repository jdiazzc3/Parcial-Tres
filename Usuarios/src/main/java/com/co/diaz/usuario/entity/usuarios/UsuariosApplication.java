package com.co.diaz.usuario.entity.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//src/main/java/com/co/diaz/commonservice/models.entity
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.co.diaz.commonservice.models.entity"})
@EnableJpaRepositories({"com.co.diaz.commonservice.models.entity"})
@EntityScan({"com.co.diaz.commonservice.models.entity"})
public class UsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsuariosApplication.class, args);
    }

}
