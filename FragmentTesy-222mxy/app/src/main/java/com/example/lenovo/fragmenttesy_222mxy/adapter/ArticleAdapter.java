package com.example.lenovo.fragmenttesy_222mxy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.lenovo.fragmenttesy_222mxy.R;
import com.example.lenovo.fragmenttesy_222mxy.bean.ArticleBean;
import com.squareup.picasso.Picasso;


import java.util.List;



public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private List<ArticleBean> list;//保存要显示的数据
    private Context context;//上下文
    private LayoutInflater layoutInflater;//动态加载布局
    //自定义，构造函数,传递上下文
    public ArticleAdapter(Context context){
        this.context=context;
        layoutInflater=LayoutInflater.from(this.context);
    }
    //自定义：传递数据源,设置数据list
    public void setList(List<ArticleBean>list){
        this.list=list;
    }
    //自定义，ViewHolder子类，容纳item视图
    public class ViewHolder extends RecyclerView.ViewHolder {
        //声明对象
        ImageView imageView;
        TextView tvtitle,tvdescript,tvtime;
        Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
            tvtitle=(TextView)itemView.findViewById(R.id.textView);
            tvdescript=(TextView)itemView.findViewById(R.id.textView2);
            tvtime=(TextView)itemView.findViewById(R.id.textView3);
            button=(Button)itemView.findViewById(R.id.button);
        }
    }

    //重写，为每一个item生成一个View
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate第一个参数要加载的布局id，
        // 第二个参数是指给该布局的外部再嵌套一层父布局，
        // 如果不需要就直接传null
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(v);

    }

    //重写，给各个item填充数据,设置监听
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //取出list一条数据
        ArticleBean articleBean = list.get(position);
        if(articleBean==null)
            return;
        // holder.imageView.setImageResource(article.getImgid());
        holder.tvtitle.setText(articleBean.getName());
        holder.tvdescript.setText(articleBean.getDescription());
        holder.tvtime.setText(articleBean.getUpdate_time());

        Picasso.with(context).load("http://amicool.neusoft.edu.cn/Uploads/"+articleBean.getThumb()).placeholder(R.mipmap.ic_launcher).into(holder.imageView);
        //条目中按钮监听器
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //做出是否删除的提示
                list.remove(position);//实际上应该操作网络/数据库
                notifyDataSetChanged();//刷新列表
            }
        });
        //条目点击监听事件  整体的
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取当前条目id
                //获取整形
                int id=list.get(position).getId();
                Toast.makeText(context,""+id,Toast.LENGTH_SHORT).show();
                //另一种方法：String
                // String strid=String.valueOf(list.get(position).getArticleId());
                // Toast.makeText(context,strid,Toast.LENGTH_SHORT).show();

            }
        });

    }
    //共有多少个条目
    @Override
    public int getItemCount() {
        if(list==null) return 0;
        else  return list.size();
    }
}
