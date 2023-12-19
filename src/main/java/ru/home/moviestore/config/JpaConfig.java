package ru.home.moviestore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("ru.home.moviestore.repository")
public class JpaConfig {
}
