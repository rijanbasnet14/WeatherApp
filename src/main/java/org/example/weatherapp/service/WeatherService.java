package org.example.weatherapp.service;

import org.example.weatherapp.dto.WeatherResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponseDTO getWeather() {

        String url = "https://api.open-meteo.com/v1/forecast?latitude=39.0&longitude=-75.5&current_weather=true";

        return restTemplate.getForObject(url, WeatherResponseDTO.class);
    }
}