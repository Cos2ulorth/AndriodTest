package com.example.lenovo.fragmenttesy_222mxy.iface;

/**
 * Created by yy on 2017/4/18.
 */
//获取文章列表接口
public interface Articleiface {
    void getResultList(String mod,//类型
                       int page,//页数
                       String sessionID, ArticleListener listener);

}