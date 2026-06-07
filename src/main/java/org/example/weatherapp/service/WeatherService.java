package org.example.weatherapp.service;

import org.example.weatherapp.dto.WeatherDTO;
import org.example.weatherapp.dto.WeatherResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherDTO getWeather(double lat, double lon) {

        String url =
                "https://api.open-meteo.com/v1/forecast"
                        + "?latitude=" + lat
                        + "&longitude=" + lon
                        + "&current_weather=true";

       WeatherResponseDTO response =
               restTemplate.getForObject(url, WeatherResponseDTO.class);

        return new WeatherDTO(
                response.getCurrent_weather().getTemperature(),
                response.getCurrent_weather().getWindspeed()
        );


    }
}