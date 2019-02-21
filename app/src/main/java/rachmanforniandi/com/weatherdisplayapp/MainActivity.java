package rachmanforniandi.com.weatherdisplayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rachmanforniandi.com.weatherdisplayapp.Models.Currently;
import rachmanforniandi.com.weatherdisplayapp.Models.Weather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RemoteServiceProvider remoteServiceProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestDataWeather(37.8267,-122.4233);
    }

    private void requestDataWeather(double lat, double lng) {
        remoteServiceProvider = new RemoteServiceProvider();
        remoteServiceProvider.getWeatherData(lat, lng);
    }


}
