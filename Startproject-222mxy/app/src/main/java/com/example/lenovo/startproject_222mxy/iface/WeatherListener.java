package com.example.lenovo.startproject_222mxy.iface;

import com.example.lenovo.startproject_222mxy.bean.WeatherInfo;

/**
 * Created by lenovo on 2017/3/14.
 */
//统一不同方式获取天气，定义接口
public interface WeatherListener {
    //成功获取，返回天气信息
    void onResponse(WeatherInfo weatherInfo);
    //获取失败，返回错误信息
    void onFail(String msg);
}
