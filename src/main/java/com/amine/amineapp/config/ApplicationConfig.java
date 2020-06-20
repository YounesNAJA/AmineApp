package com.amine.amineapp.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

//@EnableTransactionManagement

@Configuration
@EnableJpaRepositories("com.amine.amineapp.dao.repository")
//@EntityScan("com.amine.amineapp.model")
public class ApplicationConfig {
}
