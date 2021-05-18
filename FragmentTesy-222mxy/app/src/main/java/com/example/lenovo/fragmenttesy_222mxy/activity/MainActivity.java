package com.example.lenovo.fragmenttesy_222mxy.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.lenovo.fragmenttesy_222mxy.R;
import com.example.lenovo.fragmenttesy_222mxy.fragment.Fragment1;
import com.example.lenovo.fragmenttesy_222mxy.fragment.Fragment2;
import com.example.lenovo.fragmenttesy_222mxy.fragment.Fragment3;
import com.example.lenovo.fragmenttesy_222mxy.fragment.Fragment4;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayout  layout1,layout2,layout3,layout4,layout5;//用于界面切换
    private ImageButton ib1,ib2,ib3,ib4,ib5;//用户设置图片
    private ViewPager vp;//用于滑动切换

    private List<Fragment> listfragment;//Fragment  list
    private FragmentPagerAdapter fpadapter;//用来呈现Fragment页面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();//初始化界面控件，设置控件监听
        initFragment();//初始化Fragment相关
    }
    //初始化Fragment相关
    private void initFragment() {
        listfragment=new ArrayList<Fragment>();//实例化Fragment list
        //将Fragment加入到list中
        listfragment.add(new Fragment1());
        listfragment.add(new Fragment2());
        listfragment.add(new Fragment3());
        listfragment.add(new Fragment4());


        //实例化FragmentPagerAdapter
        fpadapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            //获取某个Fragment
            @Override
            public Fragment getItem(int position) {
                return listfragment.get(position);
            }
            //确定Fragment数量
            @Override
            public int getCount() {
                return listfragment.size();
            }
        };
        vp=(ViewPager)findViewById(R.id.viewPager);//实例化ViewPager
        vp.setAdapter(fpadapter);//绑定ViewPager和Adapter
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            //根据ViewPager的position选择某Fragment
            @Override
            public void onPageSelected(int position) {
                System.out.println("----"+String.valueOf(position));
                vp.setCurrentItem(position);
                resetImage();//底部图片重置
                selectTab(position);//选择某个Fragment
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    //layout点击事件
    View.OnClickListener  onClickListener =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //先将四个按钮都设成未选图片
            resetImage();
            //然后根据底部的选择切换Fragment和ViewPager
            switch (view.getId())
            {
                case R.id.layout1:
                    Toast.makeText(MainActivity.this, "切换底部栏weixin", Toast.LENGTH_SHORT).show();
                    selectTab(0);
                    break;
                case R.id.layout2:
                    Toast.makeText(MainActivity.this, "切换底部栏pengyou", Toast.LENGTH_SHORT).show();
                    selectTab(1);
                    break;
                case R.id.layout3:
                    Toast.makeText(MainActivity.this, "切换底部栏tongxinlu", Toast.LENGTH_SHORT).show();
                    selectTab(2);
                    break;
                case R.id.layout4:
                    Toast.makeText(MainActivity.this, "切换底部栏shezhi", Toast.LENGTH_SHORT).show();
                    selectTab(3);
                    break;
                case R.id.layout5:
                    Toast.makeText(MainActivity.this, "切换底部栏wo", Toast.LENGTH_SHORT).show();
                    selectTab(4);
                    break;
            }
        }
    };

    private void init() {
        //实例化ImageButton为了切换图片儿
        ib1=(ImageButton)findViewById(R.id.imageButton1);
        ib2=(ImageButton)findViewById(R.id.imageButton2);
        ib3=(ImageButton)findViewById(R.id.imageButton3);
        ib4=(ImageButton)findViewById(R.id.imageButton4);
        ib5=(ImageButton)findViewById(R.id.imageButton5);

        //实例化Layout为了底部栏点击事件切换页面
        layout1=(LinearLayout) findViewById(R.id.layout1);
        layout2=(LinearLayout)findViewById(R.id.layout2);
        layout3=(LinearLayout)findViewById(R.id.layout3);
        layout4=(LinearLayout)findViewById(R.id.layout4);
        layout5=(LinearLayout)findViewById(R.id.layout5);

        //layout点击事件
        layout1.setOnClickListener(onClickListener);
        layout2.setOnClickListener(onClickListener);
        layout3.setOnClickListener(onClickListener);
        layout4.setOnClickListener(onClickListener);
        layout5.setOnClickListener(onClickListener);
    }
    //重置底部栏图片为未选
    private  void resetImage()
    {
        ib1.setImageResource(R.drawable.weixin_normal);
        ib2.setImageResource(R.drawable.friend_normal);
        ib3.setImageResource(R.drawable.address_normal);
        ib4.setImageResource(R.drawable.settings_normal);
        ib5.setImageResource(R.drawable.me_normal);
    }
    //切换Fragment和ViewPager
    private void selectTab(int i)
    {
        switch (i)
        {
            case 0:
                ib1.setImageResource(R.drawable.weixin_pressed);
                break;
            case 1:
                ib2.setImageResource(R.drawable.friend_pressed);
                break;
            case 2:
                ib3.setImageResource(R.drawable.address_pressed);
                break;
            case 3:
                ib4.setImageResource(R.drawable.settings_pressed);
                break;
            case 4:
                ib5.setImageResource(R.drawable.me_pressed);
                break;
        }
        vp.setCurrentItem(i);
    }


}
