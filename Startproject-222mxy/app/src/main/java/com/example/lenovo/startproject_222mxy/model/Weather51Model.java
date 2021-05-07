package com.example.lenovo.startproject_222mxy.model;

import com.example.lenovo.startproject_222mxy.iface.WeatherListener;
import com.example.lenovo.startproject_222mxy.iface.Weatheriface;

/**
 * Created by lenovo on 2017/3/14.
 */

public class Weather51Model implements Weatheriface{
    private String BASEURL="http://weather.51wnl.com/weatherinfo/";
    @Override
    public void getWeather(String cityno, WeatherListener listener) {

    }
}
