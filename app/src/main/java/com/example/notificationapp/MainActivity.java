package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
NotificationCompat.Builder notification;
private static final int UniqueCode=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }
    public void getNotification(View view){

        notification.setSmallIcon(R.drawable.ic_baseline_notifications_active);
        notification.setTicker("Google Pay");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("New Mandate");
        notification.setContentText("NextBillion Technologies wants to create mandate ");

        Intent intent=new Intent(MainActivity.this,Second.class);
        intent.putExtra("amount",15000);

        PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(UniqueCode,notification.build());
    }
}