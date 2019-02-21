package rachmanforniandi.Events;

import rachmanforniandi.com.weatherdisplayapp.Models.Weather;

public class WeatherEvent {

    private final Weather weather;

    public WeatherEvent(Weather temperature) {
        this.weather = temperature;
    }

    public Weather getWeather() {
        return weather;
    }
}
