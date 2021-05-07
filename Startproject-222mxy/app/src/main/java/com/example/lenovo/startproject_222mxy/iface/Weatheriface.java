package com.example.lenovo.startproject_222mxy.iface;

/**
 * Created by lenovo on 2017/3/14.
 */
//同意不同方式获取天气，定义接口
public interface Weatheriface {
    void getWeather
            (String cityno,
             WeatherListener listener);
}
