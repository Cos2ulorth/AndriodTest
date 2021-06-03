package com.example.lenovo.recyclerviewtest_222mxy.iface;
//获取文章列表接口
public interface Articleiface {
    void getResultList(String mod,//类型
                       int page,//页数
                       String sessionID, ArticleListener listener);

}
