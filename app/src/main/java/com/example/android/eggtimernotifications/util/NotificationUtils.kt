package com.example.android.eggtimernotifications.util

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.android.eggtimernotifications.R


private val NOTIFICATION_ID = 0
private val REQUEST_CODE = 0
private val FLAGS = 0

/**
 * Builds and delivers the notification.
 * @param context, activity context.
 */
fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {


    // 1. get an instance of NotificationCompat.Builder
    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.egg_notification_channel_id)
    )   // 2. set title, text and icon to builder
        .setSmallIcon(R.drawable.cooked_egg)
        .setContentTitle(applicationContext.getString(R.string.notification_title))
        .setContentText(messageBody)

    // 3. call notify() to deliver the notification
    notify(NOTIFICATION_ID, builder.build())
}

