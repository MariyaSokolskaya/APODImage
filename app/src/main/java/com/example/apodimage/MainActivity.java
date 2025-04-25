package com.example.apodimage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    TextView titleText, explanationText;
    ImageView imageView;
    Button translateButton;
    String baseUrl = "https://api.nasa.gov";
    String demoKey = "DEMO_KEY";
    String translateUrl = "https://translate.api.cloud.yandex.net";
    String iamUrl = "https://iam.api.cloud.yandex.net";
    String folderID = "b1gn17lo67soo1vi7lse";
    String iamToken = "t1.9euelZrHzZjMi4rKnsjOm82ZjYzKjO3rnpWamcbMk5WVx8iaj4vOy8iem43l8_d9SVI_-e98YFNJ_N3z9z14Tz_573xgU0n8zef1656VmozMysnNncfNk8rJy86RiZHN7_zF656VmozMysnNncfNk8rJy86RiZHN.gvn8yXc-R0WGJ4KF4r0ASVdA1QHb6KoCiqNAO8NLrW5q05RbtFvNcMPsnSzpVGiWeDkGr4GyHp6-j9365T16Aw";
    APODData apodData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText = findViewById(R.id.titleText);
        explanationText = findViewById(R.id.explanation);
        imageView = findViewById(R.id.imageAPOD);
        translateButton = findViewById(R.id.translateButton);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APODService apodService = retrofit.create(APODService.class);
        Call<APODData> dataCall = apodService.getInfo(demoKey);
        dataCall.enqueue(new Callback<APODData>() {
            @Override
            public void onResponse(Call<APODData> call, Response<APODData> response) {
                if(response.isSuccessful() && response.code() == 200){
                    apodData = response.body();
                    if (apodData != null) {
                        titleText.setText(apodData.title);
                        explanationText.setText(apodData.explanation);
                        if(apodData.media_type.equals("image")){
                            Picasso.get()
                                    .load(apodData.url)
                                    .placeholder(R.drawable.bigvortex)
                                    .into(imageView);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<APODData> call, Throwable throwable) {
                Toast.makeText(getApplicationContext(), "Сбой запроса", Toast.LENGTH_LONG).show();

            }
        });

     }
}