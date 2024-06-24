package com.example.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("weather")
    Call<Model> getweather(@Query("q") String cityname,@Query("appid")String apikey);
}
