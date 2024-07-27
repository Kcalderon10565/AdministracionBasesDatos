package com.project.AdminBaseDatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.AdminBaseDatos", "Modelo"})
@EntityScan(basePackages = {"Modelo"})
public class AdminBaseDatosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminBaseDatosApplication.class, args);
    }
}
