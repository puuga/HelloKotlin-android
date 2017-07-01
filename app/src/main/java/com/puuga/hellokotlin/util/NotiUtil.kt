package com.puuga.hellokotlin.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.NotificationCompat
import com.puuga.hellokotlin.R
import com.puuga.hellokotlin.activity.MainActivity


/**
 * Created by siwaweswongcharoen on 6/11/2017 AD.
 */
class NotiUtil {

    fun showNoti(context: Context) {
        val mNotificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        // The id of the channel.
        val id = "my_channel_01"
        // The user-visible name of the channel.
        val name = "channel_name"
        // The user-visible description of the channel.
        val description = "channel_description"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val mChannel = NotificationChannel(id, name, importance)
        // Configure the notification channel.
        mChannel.description = description
        mChannel.enableLights(true)
        // Sets the notification light color for notifications posted to this
        // channel, if the device supports this feature.
        mChannel.lightColor = Color.RED
        mChannel.enableVibration(true)
        mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        mNotificationManager.createNotificationChannel(mChannel)

        val resultIntent: Intent = Intent(context, MainActivity::class.java)
        resultIntent.putExtra(Constant.KEY_FROM_NOTIFICATION, "hello")
        val resultPendingIntent: PendingIntent = PendingIntent
                .getActivity(context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        // Sets an ID for the notification, so it can be updated.
        val notifyID = 1
        // The id of the channel.
        val CHANNEL_ID = "my_channel_01"
        // Set a message count to associate with this notification in the long-press menu.
        val messageCount = 3

        val mBuilder = NotificationCompat.Builder(context)
                .setNumber(messageCount)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setChannelId(CHANNEL_ID)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContentIntent(resultPendingIntent)
                .setAutoCancel(true)

        mNotificationManager.notify(notifyID, mBuilder.build())

    }
}