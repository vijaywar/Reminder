package com.moonlight.reminder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;

public class notirec extends BroadcastReceiver {
    public static final String channal_ID = "My Channel Id";
    public  static final int notification_ID = 10;
    public static final String myKey = "Remote Key";
    static MediaPlayer mp;
    NotificationManager notificationManager;
    Button button;
    Context context;
    Intent intent;
    @Override
    public void onReceive(Context context, Intent intent) {
        this.context=context;
        this.intent=intent;
        /*Vibrator vibrator =
                (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);*/
        notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        showNotification();
    }

    public void showNotification ()        {
        myNotificationChannel();

        //  RemoteViews remoteCollapsedViews = new RemoteViews(getPackageName(), R.layout.activity_splash_screen_example_main);
        // RemoteViews remoteExpandedViews = new RemoteViews(getPackageName(), R.layout.activity_splash_screen_example);

        Intent i = new Intent(context, notis.class);
        PendingIntent pi = PendingIntent.getActivity(context,
                1, i, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, channal_ID);
        String quote = (String)intent.getStringExtra("remTitle");
        builder.setSmallIcon(R.drawable.reminder);
        builder.setContentTitle(quote);
        builder.setContentText("This is a reminder!");
        //  builder.setCustomContentView(remoteCollapsedViews)
        //    .setCustomBigContentView(remoteExpandedViews)
        // builder .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
        //.setAutoCancel(true);
        builder.setLights(Color.RED, 3000, 3000);
        builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        builder.setContentIntent(pi);

        builder.setAutoCancel(true);
        notificationManager.notify(notification_ID, builder.build());
    }

    public void myNotificationChannel()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            String name = "My Channel Name";
            String desc = "My Channel Description";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel =
                    new NotificationChannel(channal_ID, name, importance);
            notificationChannel.setDescription(desc);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.canShowBadge();

            notificationManager.createNotificationChannel(notificationChannel);

        }
    }
}