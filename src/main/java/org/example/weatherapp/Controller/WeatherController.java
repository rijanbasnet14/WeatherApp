package org.example.weatherapp.Controller;

import jakarta.annotation.PostConstruct;
import org.example.weatherapp.dto.WeatherResponseDTO;
import org.example.weatherapp.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherResponseDTO getWeather() {
        return weatherService.getWeather();
    }
}
