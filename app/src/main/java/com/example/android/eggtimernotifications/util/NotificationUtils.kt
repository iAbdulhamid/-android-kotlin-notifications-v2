package com.example.android.eggtimernotifications.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.android.eggtimernotifications.MainActivity
import com.example.android.eggtimernotifications.R


private val NOTIFICATION_ID = 0
private val REQUEST_CODE = 0
private val FLAGS = 0

/**
 * Builds and delivers the notification.
 * @param context, activity context.
 */
fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {

    // 8. create Intent & PendingIntent
    val contentIntent = Intent(applicationContext, MainActivity::class.java)
    val contentPendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )

    // 1. get an instance of NotificationCompat.Builder
    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.egg_notification_channel_id)
    )   // 2. set title, text and icon to builder
        .setSmallIcon(R.drawable.cooked_egg)
        .setContentTitle(applicationContext.getString(R.string.notification_title))
        .setContentText(messageBody)
        // 9. set content intent: when the user taps on the notification, the notification dismisses itself as it takes you to the app.
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true)

    // 3. call notify() to deliver the notification
    notify(NOTIFICATION_ID, builder.build())
}

// 10. Cancel all notifications
fun NotificationManager.cancelNotifications() {
    cancelAll()
}