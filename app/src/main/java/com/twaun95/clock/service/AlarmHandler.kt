package com.twaun95.clock.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.getSystemService
import com.twaun95.clock.common.Logger
import java.util.*

class AlarmHandler(private val context: Context) {
    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//    private val receiverIntent = Intent(context, AlarmReceiver::class.java)
//    private val pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent,0)

    fun setAlarm(hour: Int, minute: Int) {
        Logger.d("setAlarm")
        val receiverIntent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent,PendingIntent.FLAG_MUTABLE)

        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }

        alarmManager.cancel(pendingIntent)

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
    }

    fun cancelAlarm(){
        val receiverIntent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent,PendingIntent.FLAG_MUTABLE)

        alarmManager.cancel(pendingIntent)
    }
}