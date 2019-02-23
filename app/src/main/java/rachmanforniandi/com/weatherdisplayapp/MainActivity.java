package rachmanforniandi.com.weatherdisplayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import rachmanforniandi.Events.ErrorEvent;
import rachmanforniandi.Events.WeatherEvent;
import rachmanforniandi.com.weatherdisplayapp.Models.Currently;
import rachmanforniandi.com.weatherdisplayapp.Models.Weather;
import rachmanforniandi.com.weatherdisplayapp.Utilities.WeatherIconUtility;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.temp_value)
    TextView tempValue;

    @BindView(R.id.icon_status_weather)
    ImageView imgStatusWeather;

    @BindView(R.id.text_status_weather)
    TextView txtStatus;

    RemoteServiceProvider remoteServiceProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        requestDataWeather(42.8267,-125.4233);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWeatherEvent(WeatherEvent weatherEvent) {
        Currently currently = weatherEvent.getWeather().getCurrently();
        tempValue.setText(String.valueOf(Math.round(currently.getTemperature())));
        txtStatus.setText(currently.getSummary());

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

        imgStatusWeather.setImageResource(WeatherIconUtility.ICONS.get(currently.getIcon()));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorEvent(ErrorEvent errorEvent) {
        Toast.makeText(this, errorEvent.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    private void requestDataWeather(double lat, double lng) {
        remoteServiceProvider = new RemoteServiceProvider();
        remoteServiceProvider.getWeatherData(lat, lng);
    }


}
