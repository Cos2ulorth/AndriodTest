package com.example.lenovo.menudialogtest_222mxy;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView tvinfo,tvmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tvinfo=(TextView)findViewById(R.id.textView);
        tvmenu=(TextView)findViewById(R.id.textView2);
    }

    //创建选项菜单和子菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }
//响应选项菜单和子菜单点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu1:
                tvinfo.setText("菜单1");
                showdialog();//创建并显示对话框
                break;
            case R.id.menu2:
                tvinfo.setText("菜单2");
                break;
            case R.id.menu3:
                tvinfo.setText("菜单3");
                break;
            case R.id.menu4:
                tvinfo.setText("菜单4");
                break;
            case R.id.menu5:
                tvinfo.setText("菜单5");
                break;
            case R.id.menu6:
                tvinfo.setText("菜单6");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showdialog() {
        //动态加载布局
        final View view = getLayoutInflater().inflate(R.layout.dialoglayout,null);
        AlertDialog dialog=new AlertDialog.Builder(this)//步骤1
        .setTitle("对话框标题")//步骤2
        .setIcon(R.mipmap.ic_launcher)//步骤3
        .setView(view)//步骤4自定义布局
        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //点击确定按钮要做的事情
                EditText et=(EditText)view.findViewById(R.id.editText);
                String str=et.getText().toString();
                tvinfo.setText(str);
            }
        })
        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //点取消按钮的操作
            }
        })//步骤5按钮操作
                .create();//步骤6创建
        dialog.show();//步骤6显示
    }

}
