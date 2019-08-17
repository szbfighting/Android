package com.example.servicetest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder{

        public void startDownload(){
            Log.d("MyService", "startDownload: ");
        }

        public int getProgress(){
            Log.d("MyService", "getProgress: ");
            return 0;
        }

    }
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "onCreate: ");
        Intent intent = new Intent(this,MainActivity.class);
        NotificationChannel channel = new NotificationChannel("channelid","firstchannel", NotificationManager.IMPORTANCE_HIGH);
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this,"channelid")
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1,notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "onDestroy: ");
    }
}
