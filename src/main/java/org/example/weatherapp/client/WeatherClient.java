package org.example.weatherapp.client;

import org.example.weatherapp.dto.WeatherResponseDTO;
import org.example.weatherapp.exception.WeatherServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class WeatherClient {

    private final WebClient webClient;
    private static final Logger log =
            LoggerFactory.getLogger(WeatherClient.class);

    public WeatherClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.open-meteo.com")
                .build();
    }

    public WeatherResponseDTO getWeather(double lat, double lon) {
        try {
            log.info(
                    "Fetching weather for latitude={} longitude={}",
                    lat,
                    lon
            );
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
        } catch (Exception ex) {

            log.error("Weather API call failed", ex);

            throw new WeatherServiceException(
                    "Failed to retrieve weather data",
                    ex
            );
        }
    }
}