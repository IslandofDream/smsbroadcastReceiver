package com.example.smsbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log

class SMSBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
            Log.e("receive", "onReceive")
            val action = intent!!.action
            if(action.equals(SMS_RECEIVED_ACTION)) {
                val bundle = intent.extras
                if(bundle != null){
                    var pdus = bundle!!.get("pdus") as Array<Any>
                    for (pdu in pdus) {
                        val smsMessage: SmsMessage = SmsMessage.createFromPdu(pdu as ByteArray)
                        val address: String = smsMessage.originatingAddress!!
                        val body: String = smsMessage.getMessageBody()
                        Log.e("textmessage", "$address $body")
                    }
                }
            }

          }
}