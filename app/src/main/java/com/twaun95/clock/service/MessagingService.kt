package com.twaun95.clock.service

import android.app.Notification
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.twaun95.clock.common.Logger

class MessagingService : FirebaseMessagingService(){

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        Logger.d("onNewToken, token: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Logger.d("onMessageReceived, message: $message")
    }



    fun sendNotification() {

    }
}