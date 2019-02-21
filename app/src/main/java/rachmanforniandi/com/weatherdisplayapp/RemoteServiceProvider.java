package rachmanforniandi.com.weatherdisplayapp;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import rachmanforniandi.Events.WeatherEvent;
import rachmanforniandi.com.weatherdisplayapp.Models.Currently;
import rachmanforniandi.com.weatherdisplayapp.Models.Weather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteServiceProvider {
    private static final String BASE_URL = "https://api.darksky.net/forecast/1e0c52aa72437a941db5f14a1e6054c2/";
    private static final String TAG = RemoteServiceProvider.class.getSimpleName();
    public Retrofit retrofit;
    RemoteService remoteService;

    private Retrofit getServiceData(){
        if (this.retrofit == null){
            this.retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return this.retrofit;
    }

    public void getWeatherData(double lat, double lng){
        remoteService = getServiceData().create(RemoteService.class);
        Call<Weather> data = remoteService.getDataWeather(lat,lng);
        data.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather weather = response.body();
                Currently currently = response.body().getCurrently();
                Log.e(TAG,"Temperature = " + currently.getTemperature());
                EventBus.getDefault().post(new WeatherEvent(weather));
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.e(TAG,"onFailure: Unable to get weather data");
            }
        });
    }

}
