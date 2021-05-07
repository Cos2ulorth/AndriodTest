package com.example.lenovo.startproject_222mxy.bean;

/**
 * Created by lenovo on 2017/3/14.
 */

public class WeatherInfo {
    private String city;
    private String temp;//温度
    private String WD;//风向
    private String WS;//风力
    private String SD;//湿度

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }
}
