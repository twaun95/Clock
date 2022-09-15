package com.twaun95.clock.service

import com.google.firebase.messaging.FirebaseMessaging
import com.twaun95.clock.common.Logger

object MessagingHandler {
    fun getToken() {
        FirebaseMessaging.getInstance().token.apply {
            addOnSuccessListener {
                Logger.d("Success , $it")
            }
            addOnCanceledListener {
                Logger.d("Canceled")
            }
            addOnFailureListener {
                Logger.d("Fail, $it")

            }
            addOnCompleteListener {
                Logger.d("Complete, $it")
            }
        }
    }
}