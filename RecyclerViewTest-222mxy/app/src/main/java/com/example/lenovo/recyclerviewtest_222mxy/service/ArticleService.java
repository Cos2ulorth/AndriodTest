package com.example.lenovo.recyclerviewtest_222mxy.service;
import com.example.dell.recyclerviewtest_224lx.bean.ArticleBean;

import java.util.List;



public interface ArticleService {
    @GET("api.php/lists/mod/{mod}")
    Call<List<ArticleBean>> getResult(@Path("mod") String mod, @Query("page") int page, @Header("SessionID") String SessionID);
}
