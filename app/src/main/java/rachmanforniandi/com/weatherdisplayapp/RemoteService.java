package rachmanforniandi.com.weatherdisplayapp;

import rachmanforniandi.com.weatherdisplayapp.Models.Weather;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RemoteService {
    @GET(".")
    Call<Weather> getDataWeather();
}
