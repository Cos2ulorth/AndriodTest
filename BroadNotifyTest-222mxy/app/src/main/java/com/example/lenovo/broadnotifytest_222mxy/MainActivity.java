package com.example.lenovo.broadnotifytest_222mxy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button btnsend,btnnotify;
    //广播用的唯一字符串
    private  String UNIQUE_STRING="com.example.dell.broadnotifytest_224lx";
    private View.OnClickListener listenner=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.button://发送广播按钮
                    Intent intent=new Intent(UNIQUE_STRING);
                    intent.putExtra("para2",editText.getText().toString());
                    sendBroadcast(intent);
                    break;
                case R.id.button2://清楚通知按钮
                    MyReceiver.manager.cancel(MyReceiver.notifyID);
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        editText=(EditText)findViewById(R.id.editText);
        btnsend=(Button)findViewById(R.id.button);
        btnnotify=(Button)findViewById(R.id.button2);
        btnsend.setOnClickListener(listenner);
        btnnotify.setOnClickListener(listenner);
    }
}
