package com.twaun95.clock.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.getSystemService
import com.twaun95.clock.R
import com.twaun95.clock.common.Logger
import com.twaun95.clock.presentation.ui.main.MainActivity

class AlarmReceiver : BroadcastReceiver() {

    private lateinit var notificationManager : NotificationManager

    override fun onReceive(context: Context, intent: Intent) {
        Logger.d("onReceive")
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(context)
        deliverNotification(context)
    }

    private fun createNotificationChannel(context: Context) {
        Logger.d("createNotificationChannel")
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "description"
                enableLights(true)
                lightColor = Color.BLACK
                enableVibration(true)

            }

            // Register the channel with the system
//            NotificationManagerCompat.from(context).createNotificationChannel(channel)
            notificationManager.createNotificationChannel(channel)
        }
    }


    private fun deliverNotification(context: Context) {
        Logger.d("deliverNotification")

//        val contentIntent = Intent(context, MainActivity::class.java)
//        val contentPendingIntent = PendingIntent.getActivity(
//            context,
//            NOTIFICATION_ID,
//            contentIntent,
//            PendingIntent.FLAG_UPDATE_CURRENT
//        )

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("title")
            .setContentText("content")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//            .setContentIntent(contentPendingIntent)

//        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    companion object {
        const val NOTIFICATION_ID = 0
        const val CHANNEL_ID = "CHANNEL_ID"
        const val CHANNEL_NAME = "알람"
    }
}