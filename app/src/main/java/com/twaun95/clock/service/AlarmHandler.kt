package com.twaun95.clock.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import com.twaun95.clock.common.Logger
import java.util.*

class AlarmHandler(private val context: Context) {
    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    fun setAlarm(hour: Int, minute: Int, message: String) {
        val receiverIntent = Intent(context, PushAlarmReceiver::class.java).apply { putExtra("message", message) }
        val pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent,PendingIntent.FLAG_MUTABLE)

        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }

        alarmManager.cancel(pendingIntent)

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            pendingIntent
        )
    }

    fun cancelAlarm(){
        val receiverIntent = Intent(context, PushAlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent,PendingIntent.FLAG_MUTABLE)

        alarmManager.cancel(pendingIntent)
    }

    fun isRegistered() {
        val receiverIntent = Intent(context, PushAlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent,PendingIntent.FLAG_MUTABLE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            Logger.d("pendingIntent.isBroadcast: ${pendingIntent.isBroadcast}")
            Logger.d("pendingIntent.isBroadcast version")
        }
    }
}