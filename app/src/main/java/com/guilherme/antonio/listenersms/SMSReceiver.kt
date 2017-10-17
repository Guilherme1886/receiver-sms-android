package com.guilherme.antonio.listenersms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage

/**
 * Created by Bimore on 17/10/2017.
 */

class SMSReceiver : BroadcastReceiver() {

    companion object {

        private var smsListener: SmsListener? = null

        fun bindListener(listener: SmsListener) {
            smsListener = listener
        }
    }


    override fun onReceive(context: Context?, intent: Intent?) {

        val bundle = intent?.extras
        val pdus = bundle?.get("pdus") as Array<*>
        val messages = arrayOfNulls<SmsMessage>(pdus.size)

        for (i in messages.indices) {

            messages[i] = SmsMessage.createFromPdu(pdus[i] as ByteArray)
            val message = messages[i]?.displayMessageBody
            val number = messages[i]?.originatingAddress

            smsListener?.messageReceived(message, number)

        }
    }

}