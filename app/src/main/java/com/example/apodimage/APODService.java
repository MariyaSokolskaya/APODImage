package com.example.apodimage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APODService {
    @GET("/planetary/apod")
    Call<APODData> getInfo(@Query("api_key") String demoKey);


}
