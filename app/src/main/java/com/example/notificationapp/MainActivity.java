package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
NotificationCompat.Builder notification;
private static final int UniqueCode=101;
//----------------------------
    String CHANNEL_ID="channelid";
    String CHANNEL_NAME="channelname";
//------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*notification=new NotificationCompat.Builder(this);*/
      //-----------------------------------------------
        createNotificationChannel();
        notification=new NotificationCompat.Builder(this,CHANNEL_ID);
        //-------------------------------------
        notification.setAutoCancel(true);
    }
    public void getNotification(View view){

        notification.setSmallIcon(R.drawable.ic_baseline_notifications_active);
        notification.setTicker("Google Pay");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("New Mandate");
        notification.setContentText("NextBillion Technologies wants to create mandate ");
        //-----------
        notification.setPriority(NotificationCompat.PRIORITY_HIGH);
        //------------------
        Intent intent=new Intent(MainActivity.this,Second.class);
        intent.putExtra("amount",15000);

        PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(UniqueCode,notification.build());
    }
    //---------------------------------------
    public void createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)// for checking devices is running on which Android os o Build.VERSIION_CODE.o means oriyo
        {
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("MY");
            NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }
    //-------------------------------------------
}