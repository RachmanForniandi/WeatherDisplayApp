package rachmanforniandi.com.weatherdisplayapp.Utilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import rachmanforniandi.com.weatherdisplayapp.R;

public final class WeatherIconUtility {
    public static final Map<String, Integer> ICONS;
    static {
        Map<String, Integer> iconWeather = new HashMap<>();
        iconWeather.put("clear-day", R.drawable.ic_clear_day);
        iconWeather.put("clear-night",R.drawable.ic_clear_night);
        iconWeather.put("rain", R.drawable.ic_rain);
        iconWeather.put("snow", R.drawable.ic_snow);
        iconWeather.put("sleet",R.drawable.ic_sleet);
        iconWeather.put("wind",R.drawable.ic_wind);
        iconWeather.put("cloudy",R.drawable.ic_cloudy);
        iconWeather.put("partly-cloudy-day",R.drawable.ic_partly_cloudy_day);
        iconWeather.put("partly-cloudy-night",R.drawable.ic_partly_cloudy_night);
        iconWeather.put("thunderstorm",R.drawable.ic_thunderstorm);

        ICONS = Collections.unmodifiableMap(iconWeather);
    }
}
