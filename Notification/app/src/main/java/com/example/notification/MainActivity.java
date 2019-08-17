package com.example.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Context mContext;
    private NotificationManager manager;
    private Notification notify1;
    Bitmap LargeBitmap=null;
    public static final int NOTIFYID_1 = 1;

    private Button btn_show_normal;
    private Button btn_close_normal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;

        LargeBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        bindView();
    }

    private void bindView(){
        btn_show_normal = (Button)findViewById(R.id.show);
        btn_close_normal = (Button)findViewById(R.id.close);
        btn_show_normal.setOnClickListener(this);
        btn_close_normal.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClick(View v){
        switch (v.getId()){
            case R.id.show:
                Intent intent = new Intent(MainActivity.this,OtherActivity.class);
                PendingIntent pit = PendingIntent.getActivity(this,0,intent,0);
                if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
                    //只在Android O之上需要渠道
                    NotificationChannel notificationChannel = new NotificationChannel("channelid1","channelname",NotificationManager.IMPORTANCE_HIGH);
                    //如果这里用IMPORTANCE_NOENE就需要在系统的设置里面开启渠道，通知才能正常弹出
                    manager.createNotificationChannel(notificationChannel);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"channelid1");
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("通知标题")
                        .setContentText("通知内容")
                        .setAutoCancel(true)
                .setContentIntent(pit);
                manager.notify(0x12,builder.build());
                break;
            case R.id.close:
                manager.cancel(NOTIFYID_1);
                break;

        }
    }


}
