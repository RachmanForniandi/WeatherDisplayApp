package rachmanforniandi.com.weatherdisplayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import rachmanforniandi.Events.WeatherEvent;
import rachmanforniandi.com.weatherdisplayapp.Models.Currently;
import rachmanforniandi.com.weatherdisplayapp.Models.Weather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.temp_value)
    TextView tempValue;
    RemoteServiceProvider remoteServiceProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        requestDataWeather(37.8267,-122.4233);
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
        Currently currently =weatherEvent.getWeather().getCurrently();
        tempValue.setText(String.valueOf(Math.round(currently.getTemperature())));
    }

    private void requestDataWeather(double lat, double lng) {
        remoteServiceProvider = new RemoteServiceProvider();
        remoteServiceProvider.getWeatherData(lat, lng);
    }


}
