package com.example.apodimage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TranslateService {
    @POST("/translate/v2/translate")
    @Headers({"Content-Type:application/json"})
    Call<TranslateResponse> getTranslate(@Header("Authorization:Bearer") String iamToken,
                                         @Body TranslateBody translateBody);
}
