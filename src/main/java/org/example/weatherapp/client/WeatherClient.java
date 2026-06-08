package org.example.weatherapp.client;

import org.example.weatherapp.dto.WeatherResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WeatherClient {

    private final WebClient webClient;

    public WeatherClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.open-meteo.com")
                .build();
    }

    public WeatherResponseDTO getWeather(double lat, double lon) {
        System.out.println("WeatherClient using WebClient");
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/forecast")
                        .queryParam("latitude", lat)
                        .queryParam("longitude", lon)
                        .queryParam("current_weather", true)
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponseDTO.class)
                .block();
    }
}