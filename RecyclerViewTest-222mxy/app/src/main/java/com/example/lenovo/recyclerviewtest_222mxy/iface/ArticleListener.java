package com.example.lenovo.recyclerviewtest_222mxy.iface;

import com.example.dell.recyclerviewtest_224lx.bean.ArticleBean;

import java.util.List;

//获取文章数据网络返回
public interface ArticleListener {
    //成功获取
    void onResponse(List<ArticleBean> beanList);
    //失败
    void onFail(String msg);
}
