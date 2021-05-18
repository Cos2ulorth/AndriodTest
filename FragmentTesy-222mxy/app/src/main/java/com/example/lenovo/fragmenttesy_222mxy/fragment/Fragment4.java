package com.example.lenovo.fragmenttesy_222mxy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.fragmenttesy_222mxy.R;


public class Fragment4 extends Fragment {
    private  TextView tvinfo;
    private View view=null;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
        //动态加载Fragment1的布局文件
        view=inflater.inflate(R.layout.fragment2,container,false);
        //获取布局上的控件，注意通过view获取
        tvinfo=(TextView)view.findViewById(R.id.textView11);
        tvinfo.setText("设置");
        //注意Toast第一个参数上下文
        Toast.makeText(context, "加载Fragment设置", Toast.LENGTH_SHORT).show();
        //返回动态生成的view
        return view;
    }
}
