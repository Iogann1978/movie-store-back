package ru.home.moviestore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.home.moviestore.kinopoisk.ApiClient;
import ru.home.moviestore.kinopoisk.api.FilmsApi;

@Configuration
public class WebConfig {
    @Value("${kinopoisk.x-api-key}")
    private String apiKey;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    @Bean
    public ApiClient apiClient(RestTemplate restTemplate) {
        ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.addDefaultHeader("X-API-KEY", apiKey);
        return apiClient;
    }

    @Bean
    public FilmsApi filmsApi(ApiClient apiClient) {
        return new FilmsApi(apiClient);
    }
}
