package com.amine.amineapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableTransactionManagement

@Configuration
@EnableJpaRepositories("com.amine.amineapp.dao.repository")
public class ApplicationConfig {
}
