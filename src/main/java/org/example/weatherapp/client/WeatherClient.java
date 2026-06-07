package org.example.weatherapp.client;

import org.example.weatherapp.dto.WeatherResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponseDTO getWeather(double lat, double lon) {

        String url =
                "https://api.open-meteo.com/v1/forecast"
                        + "?latitude=" + lat
                        + "&longitude=" + lon
                        + "&current_weather=true";

        return restTemplate.getForObject(
                url,
                WeatherResponseDTO.class
        );
    }
}