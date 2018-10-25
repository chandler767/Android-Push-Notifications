package com.pubnub.hellopush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;


public class MainActivity extends AppCompatActivity {
    public static PubNub pubnub; // PubNub instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPubnub();
        createChannel();
    }

    // Creates PubNub instance with your PubNub credentials. https://admin.pubnub.com/
    // This instance will be used when we need to create connection to PubNub.
    private void initPubnub() {
        PNConfiguration pnConfiguration = new PNConfiguration();
        pnConfiguration.setPublishKey("pub-c-30a319f8-f814-480e-ba4d-56f29a778e24");
        pnConfiguration.setSubscribeKey("sub-c-c93ecd58-d7d3-11e8-b7c4-3e16c06ff365");
        pnConfiguration.setSecure(true);
        pubnub = new PubNub(pnConfiguration);
    }

    // Creates notification channel.
    private void createChannel() {
        //  Notification channel should only be created for devices running Android API level 26+.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel chan1 = new NotificationChannel(
                    "default",
                    "default",
                    NotificationManager.IMPORTANCE_NONE);

            chan1.setLightColor(Color.TRANSPARENT);
            chan1.setLockscreenVisibility(Notification.VISIBILITY_SECRET);
            notificationManager.createNotificationChannel(chan1);
        }
    }
}
