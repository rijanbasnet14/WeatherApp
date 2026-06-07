package org.example.weatherapp.dto;

public class WeatherDTO {

    private double temperature;
    private double windspeed;

    public WeatherDTO() {
    }

    public WeatherDTO(double temperature, double windspeed) {
        this.temperature = temperature;
        this.windspeed = windspeed;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }
}
