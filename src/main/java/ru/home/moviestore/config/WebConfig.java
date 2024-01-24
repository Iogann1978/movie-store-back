package ru.home.moviestore.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import ru.home.moviestore.kinopoisk.ApiClient;
import ru.home.moviestore.kinopoisk.api.FilmsApi;
import ru.home.moviestore.kinopoisk.api.StaffApi;

@Configuration
public class WebConfig {
    @Value("${kinopoisk.x-api-key}")
    private String apiKey;

    @Bean
    public RestTemplate restTemplate() {
        var objectMapper = new ObjectMapper().registerModule(new JsonNullableModule());
        var httpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        var restTemplate = new RestTemplateBuilder().build();
        restTemplate.getMessageConverters().add(0, httpMessageConverter);
        return restTemplate;
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

    @Bean
    public StaffApi staffApi(ApiClient apiClient) {
        return new StaffApi(apiClient);
    }
}
