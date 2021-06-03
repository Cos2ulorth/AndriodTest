package com.example.lenovo.recyclerviewtest_222mxy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.lenovo.recyclerviewtest_222mxy.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;//recyclerview控件
    //recyclerview控件布局管理
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter myAdapter;//RecyclerView的适配器
    private List<ArticleBean> list=null;//保存数据

    ArticleListener articleListener=new ArticleListener() {
        @Override
        public void onResponse(List<ArticleBean> beanList) {
            list=beanList;//拿到文章数据
            myAdapter.setList(list);
            myAdapter.notifyDataSetChanged();//通知更新
        }

        @Override
        public void onFail(String msg) {
            Toast.makeText(MainActivity.this,"失败："+msg,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

        ArticleModel model=new ArticleModel();
        model.getResultList("article",1,"rv1l2tidbomann2qn86nln6ur2",ArticleListener);
    }
    //初始化RecycView
    private void initRecyclerView() {
        recyclerView=(RecyclerView)findViewById(R.id.RecycleView);
        //创建默认的线性布局
        layoutManager=new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //固定每个item的高度，可以提高性能
        recyclerView.setHasFixedSize(true);
        //获取数据
        //  list=getData();
        //实例化Adapter
        myAdapter=new MyAdapter(this);
        myAdapter.setList(list);//传递数据
        //绑定RecyclerView和Adapter
        recyclerView.setAdapter(myAdapter);
    }
/*
    private List<ArticleBean> getData(){
        List<ArticleBean> list=new ArrayList<ArticleBean>();
        ArticleBean articleBean;
        //第一组模拟数据
        articleBean=new ArticleBean();
        articleBean.setArticleId(1);
        articleBean.setTitle("标题1");
        articleBean.setDescription("描述1");
        articleBean.setTime("2017-4-1");
        articleBean.setImgid(R.drawable.f1);
        list.add(articleBean);

        //第二组模拟数据
        articleBean=new ArticleBean();
        articleBean.setArticleId(2);
        articleBean.setTitle("标题2");
        articleBean.setDescription("描述2");
        articleBean.setTime("2017-4-1");
        articleBean.setImgid(R.drawable.f2);
        list.add(articleBean);
        //第三组模拟数据
        articleBean=new ArticleBean();
        articleBean.setArticleId(3);
        articleBean.setTitle("标题3");
        articleBean.setDescription("描述3");
        articleBean.setTime("2017-4-1");
        articleBean.setImgid(R.drawable.f3);
        list.add(articleBean);
        //第四组模拟数据
        articleBean=new ArticleBean();
        articleBean.setArticleId(4);
        articleBean.setTitle("标题4");
        articleBean.setDescription("描述4");
        articleBean.setTime("2017-4-1");
        articleBean.setImgid(R.drawable.f4);
        list.add(articleBean);
        //第五组模拟数据
        articleBean=new ArticleBean();
        articleBean.setArticleId(5);
        articleBean.setTitle("标题5");
        articleBean.setDescription("描述5");
        articleBean.setTime("2017-4-1");
        articleBean.setImgid(R.drawable.f5);
        list.add(articleBean);
        //第六组模拟数据
        articleBean=new ArticleBean();
        articleBean.setArticleId(6);
        articleBean.setTitle("标题6");
        articleBean.setDescription("描述6");
        articleBean.setTime("2017-4-1");
        articleBean.setImgid(R.drawable.f6);
        list.add(articleBean);

        return list;
    }
    */
}

}
