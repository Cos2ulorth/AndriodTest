package com.example.lenovo.startproject_222mxy.service;

import com.example.lenovo.startproject_222mxy.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lenovo on 2017/3/15.
 */
//Retrofit访问网络的接口
public interface WeatherService {
       @GET("data/sk/{cityNumber}.html")
       Call<WeatherResult> getResult
               (@Path("cityNumber")String cityNumber);
}
