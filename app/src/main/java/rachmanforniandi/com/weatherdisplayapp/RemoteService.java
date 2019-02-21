package rachmanforniandi.com.weatherdisplayapp;

import rachmanforniandi.com.weatherdisplayapp.Models.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RemoteService {
    @GET("{lat},{lng}")
    Call<Weather> getDataWeather(@Path("lat") double lat,@Path("lng") double lng);
}
