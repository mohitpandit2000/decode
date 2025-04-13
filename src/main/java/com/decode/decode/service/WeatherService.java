package com.decode.decode.service;

import com.decode.decode.api.response.WeatherResponse;
import com.decode.decode.cache.AppCache;
import com.decode.decode.constants.PlaceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private  String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public WeatherResponse getWeather(String city){
        String finalApi = appCache.APP_CACHE.get(PlaceHolder.WEATHER_API.toString())
                .replace(PlaceHolder.CITY.toString(), city).replace(PlaceHolder.APIKEY.toString(), apiKey);
        ResponseEntity<WeatherResponse> response =
                restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        return response.getBody();
    }
}
