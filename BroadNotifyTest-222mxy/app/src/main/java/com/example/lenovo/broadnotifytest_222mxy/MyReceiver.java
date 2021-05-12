package com.example.lenovo.broadnotifytest_222mxy;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by dell on 2017/5/3.
 */

public class MyReceiver extends BroadcastReceiver {
    private Context context;//上下文
    private String str="";//接收到广播发来消息

    public static NotificationManager manager;
    public static int notifyID=1;//通知的id

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context=context;
        str=intent.getStringExtra("para2");
        Toast.makeText(context,"接收到广播："+str,Toast.LENGTH_LONG);
        //发送通知
        sendnotify();
    }

    private void sendnotify() {
        //获取通知管理器
        manager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        //实例化通知构造器
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context);
        //对构造器进行配置
        //点击后进入哪个Activity
        Intent intent=new Intent(context,NotifyActivity.class);
        intent.putExtra("para3",str);//传 参
        PendingIntent pintent=PendingIntent.getActivity(
                context,//上下文
                notifyID,//通知id
                intent,//intent
                PendingIntent.FLAG_UPDATE_CURRENT//更新标志
        );

        //配置标题，内容，图标等信息
        builder.setContentTitle("通知的标题")
                .setContentText("通知的内容:"+str)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("通知来了")
                .setContentIntent(pintent)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis());
        //发送通知
        manager.notify(notifyID,builder.build());

    }
}
