package com.guilherme.antonio.listenersms

/**
 * Created by Bimore on 17/10/2017.
 */

interface SmsListener {
    fun messageReceived(message: String?, number: String?)
}