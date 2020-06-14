package com.elvanerdem.tomatotimer.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.elvanerdem.tomatotimer.R
import com.elvanerdem.tomatotimer.ui.main.MainActivity

private val NOTIFICATION_ID = 0
private val REQUEST_CODE = 0
private val FLAGS = 0

fun NotificationManager.sendNotification(applicationContext: Context, messageBody: String) {

    val contentIntent = Intent(applicationContext, MainActivity::class.java)
    val contentPendingIntent = PendingIntent.getActivity(applicationContext, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT)

    val tomatoImage = BitmapFactory.decodeResource(
        applicationContext.resources,
        R.drawable.ic_tomato_right
    )

    val builder = NotificationCompat.Builder(applicationContext, applicationContext.getString(R.string.tomato_timer_notification_channel_id))
    .setContentTitle(applicationContext
    .getString(R.string.app_name))
    .setContentText(messageBody)
    .setContentIntent(contentPendingIntent)
    .setAutoCancel(true)
    .setSmallIcon(R.drawable.tomato)
    .setLargeIcon(tomatoImage)
    .setPriority(NotificationCompat.PRIORITY_HIGH)
    notify(NOTIFICATION_ID, builder.build())

}

fun NotificationManager.cancelNotifications() {
    cancelAll()
}