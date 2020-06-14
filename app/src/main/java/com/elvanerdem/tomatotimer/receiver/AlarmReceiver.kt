package com.elvanerdem.tomatotimer.receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.elvanerdem.tomatotimer.ui.main.MainActivity
import com.elvanerdem.tomatotimer.utils.sendNotification

class AlarmReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Alaaarm", Toast.LENGTH_LONG).show()

        val notificationManager = ContextCompat.getSystemService(context, NotificationManager::class.java) as NotificationManager

        notificationManager.sendNotification(context, "Alarm")
    }
}