package com.example.weather;

import static com.example.weather.R.color.white;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private TextView tvResult, tvLocation, tvMinTemp, tvMaxTemp, tvFeelsliketemp, Humidity, pressure, sunrise, sunset, visibility,Longitude,Latitude;
    private String apiKey = "8e89c31fc86656987d89782e32d673d5";
    private RelativeLayout mainLayout; // Declare RelativeLayout variable
    private LottieAnimationView lottieAnimationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        tvResult = findViewById(R.id.tvResult);
        tvLocation = findViewById(R.id.tvLocation);
        tvMinTemp = findViewById(R.id.tvMinTemp);
        tvMaxTemp = findViewById(R.id.tvMaxTemp);
        tvFeelsliketemp = findViewById(R.id.tvFeelsliketemp);
        Humidity = findViewById(R.id.Humidity);
        pressure = findViewById(R.id.Pressure);
        sunrise = findViewById(R.id.Sunrise);
        sunset = findViewById(R.id.Sunset);
        visibility = findViewById(R.id.Visibility);
        mainLayout = findViewById(R.id.mainLayout); // Initialize mainLayout
        lottieAnimationView = findViewById(R.id.lottieAnimationView);
        Longitude = findViewById(R.id.logitude);
        Latitude = findViewById(R.id.latitude);
        lottieAnimationView = findViewById(R.id.lottieAnimationView);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchWeather(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void fetchWeather(String city) {
        if (city.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter a city name", Toast.LENGTH_SHORT).show();
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIInterface api = retrofit.create(APIInterface.class);
        Call<Model> call = api.getweather(city, apiKey);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful()) {
                    Model model = response.body();
                    if (model != null) {
                        String weatherCondition = model.getWeather().get(0).getMain();
                        updateBackground(weatherCondition);

                        String location = model.getName();
                        Double tempInKelvin = model.getMain().getTemp();
                        Double tempMin = model.getMain().getTemp_min();
                        Double tempMax = model.getMain().getTemp_max();
                        Double fellsLike = model.getMain().getFeels_like();

                        // Convert temperatures to Celsius
                        Double tempInCelsius = tempInKelvin - 273.15;
                        Double tempMinCelsius = tempMin - 273.15;
                        Double tempMaxCelsius = tempMax - 273.15;
                        Double fellsLikeCelsius = fellsLike - 273.15;

                        // Format temperatures to remove decimal places
                        String formattedTemperature = String.format("%.0f", tempInCelsius);
                        String formattedTempMin = String.format("%.0f", tempMinCelsius);
                        String formattedTempMax = String.format("%.0f", tempMaxCelsius);
                        String formattedFeelsLike = String.format("%.0f", fellsLikeCelsius);

                        // Set the formatted temperatures to TextViews
                        tvResult.setText(formattedTemperature + "°C");
                        tvMinTemp.setText(formattedTempMin + "°C");
                        tvMaxTemp.setText(formattedTempMax + "°C");
                        tvFeelsliketemp.setText(formattedFeelsLike + "°C");
                        tvLocation.setText(location);

                        // Set other weather details
                        Humidity.setText(String.valueOf(model.getMain().getHumidity()));
                        pressure.setText(String.valueOf(model.getMain().getPressure()));
                        sunrise.setText(convertUnixToAmPm(model.getSys().getSunrise()));
                        sunset.setText(convertUnixToAmPm(model.getSys().getSunset()));
                        visibility.setText(String.valueOf(model.getVisibility()));
                        Longitude.setText(String.valueOf(model.getCoord().getLon()));
                        Latitude.setText(String.valueOf(model.getCoord().getLat()));
                        // Start animation
                        lottieAnimationView.playAnimation();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            private String convertUnixToAmPm(Integer unixTimestamp) {
                long unixMillis = unixTimestamp * 1000L; // Convert seconds to milliseconds
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                return sdf.format(new Date(unixMillis));
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                tvResult.setText("Failure: " + t.getMessage());
            }
        });
    }


    private void updateBackground(String weatherCondition) {
        int drawableResource;
        LottieAnimationView animationView = findViewById(R.id.lottieAnimationView);

        switch (weatherCondition) {
            case "Haze":
                drawableResource = R.drawable.sunnybackground;
                animationView.setVisibility(View.VISIBLE);
                startAnimation(animationView, R.raw.cloudy);
                break;
            case "Clouds":
                drawableResource = R.drawable.cloudybackgroud;
                animationView.setVisibility(View.VISIBLE);
                startAnimation(animationView, R.raw.sunny);
                break;
            case "Rain":
                drawableResource = R.drawable.rainybackground;
                animationView.setVisibility(View.VISIBLE);
                startAnimation(animationView, R.raw.rainy);
                break;
            default:
                drawableResource = R.drawable.sunnybackground;
                animationView.setVisibility(View.GONE);
                animationView.cancelAnimation();
                break;
        }

        mainLayout.setBackgroundResource(drawableResource); // Set background of mainLayout
    }

    private void startAnimation(LottieAnimationView animationView, int animationRes) {
        animationView.setAnimation(animationRes);
        animationView.playAnimation();
    }
}