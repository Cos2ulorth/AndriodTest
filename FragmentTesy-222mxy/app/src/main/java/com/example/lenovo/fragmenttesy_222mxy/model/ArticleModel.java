package com.example.lenovo.fragmenttesy_222mxy.model;

import com.example.lenovo.fragmenttesy_222mxy.bean.ArticleBean;
import com.example.lenovo.fragmenttesy_222mxy.iface.ArticleListener;
import com.example.lenovo.fragmenttesy_222mxy.iface.Articleiface;
import com.example.lenovo.fragmenttesy_222mxy.service.ArticleService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yy on 2017/4/19.
 */
//model。文章模块，实现Articleiface
public class ArticleModel implements Articleiface {
    //定义实体类
    private Retrofit retrofit;
    private String BASEURL="http://amicool.neusoft.edu.cn/";
    //构造方法
    public ArticleModel(){//实例化retrofit
        retrofit=new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    //获取文章数据
    @Override
    public void getResultList(String mod, int page, String sessionID, final ArticleListener listener) {
        ArticleService articleService=retrofit.create(ArticleService.class);
        Call<List<ArticleBean>> call=articleService.getResult(mod,page,sessionID);//往接口传形参
        call.enqueue(new Callback<List<ArticleBean>>() {
            @Override
            public void onResponse(Call<List<ArticleBean>> call, Response<List<ArticleBean>> response) {
                if (response.isSuccessful() && response.body()!=null)
                    listener.onResponse(response.body());
                else
                    listener.onFail("on response fail");
            }

            @Override
            public void onFailure(Call<List<ArticleBean>> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
}
