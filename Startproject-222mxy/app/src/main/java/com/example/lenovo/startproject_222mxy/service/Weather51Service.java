package com.example.lenovo.startproject_222mxy.service;

import com.example.lenovo.startproject_222mxy.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2017/3/15.
 */

public interface Weather51Service {
    Call<WeatherResult> getResult(@Query("cityCode")String cityNumber,
                                  @Query("weatherType")int weatherType);
}
