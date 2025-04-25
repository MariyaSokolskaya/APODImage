package com.example.apodimage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAMService {
    @POST("/iam/v1/tokens")
    Call<IAMResponse> getIAMToken(@Body IAMBody iamBody);
}
