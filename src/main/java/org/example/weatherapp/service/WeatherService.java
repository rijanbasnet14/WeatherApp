package org.example.weatherapp.service;

import org.example.weatherapp.client.WeatherClient;
import org.example.weatherapp.dto.WeatherDTO;
import org.example.weatherapp.dto.WeatherResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public WeatherDTO getWeather(double lat, double lon) {

        WeatherResponseDTO response =
                weatherClient.getWeather(lat, lon);

        return new WeatherDTO(
                response.getCurrent_weather().getTemperature(),
                response.getCurrent_weather().getWindspeed()
        );
    }
}