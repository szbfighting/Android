package com.example.notificationtest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.app.NotificationChannel.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private NotificationManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
        manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_notice:
                if(Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.O){
                    NotificationChannel notificationChannel = new NotificationChannel("channel","channelname",NotificationManager.IMPORTANCE_HIGH);
                    manager.createNotificationChannel(notificationChannel);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"channel").setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
                manager.notify(1, builder.build());
                break;
            default:
                break;
        }
    }


}
