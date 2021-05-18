package com.example.lenovo.fragmenttesy_222mxy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.fragmenttesy_222mxy.R;
import com.example.lenovo.fragmenttesy_222mxy.bean.ArticleBean;
import com.example.lenovo.fragmenttesy_222mxy.iface.ArticleListener;
import com.example.lenovo.fragmenttesy_222mxy.model.ArticleModel;
import com.example.lenovo.fragmenttesy_222mxy.adapter.*;
import java.util.List;


public class Fragment1 extends Fragment {
    private  TextView tvinfo;
    private View view=null;
    private Context context;

    private RecyclerView recyclerView;//recyclerview控件
    //recyclerview控件布局管理
    private RecyclerView.LayoutManager layoutManager;
    private ArticleAdapter  artilcleAdapter;
    private List<ArticleBean> list=null;//保存数据

    ArticleListener articleListener=new ArticleListener() {
        @Override
        public void onResponse(List<ArticleBean> beanList) {
            list=beanList;//拿到文章数据
            artilcleAdapter.setList(list);
            artilcleAdapter.notifyDataSetChanged();//通知更新
        }

        @Override
        public void onFail(String msg) {
            Toast.makeText(getActivity(),"失败："+msg,Toast.LENGTH_SHORT).show();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
        //动态加载Fragment1的布局文件
        view=inflater.inflate(R.layout.fragment1,container,false);
        //获取布局上的控件，注意通过view获取
        tvinfo=(TextView)view.findViewById(R.id.textView8);
        tvinfo.setText("微信");
        //注意Toast第一个参数上下文
        Toast.makeText(context, "加载Fragment微信", Toast.LENGTH_SHORT).show();

        initRecyclerView();

        ArticleModel model=new ArticleModel();
        model.getResultList("article",1,"rv1l2tidbomann2qn86nln6ur2",articleListener);

        //返回动态生成的view
        return view;
    }


    //初始化RecycView
    private void initRecyclerView() {
        recyclerView=(RecyclerView)view.findViewById(R.id.RecyclerView);
        //创建默认的线性布局
        layoutManager=new LinearLayoutManager(getActivity());
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //固定每个item的高度，可以提高性能
        recyclerView.setHasFixedSize(true);
        //获取数据
        //  list=getData();
        //实例化Adapter
        artilcleAdapter=new ArticleAdapter(getActivity());
        artilcleAdapter.setList(list);//传递数据
        //绑定RecyclerView和Adapter
        recyclerView.setAdapter(artilcleAdapter);
    }
}
