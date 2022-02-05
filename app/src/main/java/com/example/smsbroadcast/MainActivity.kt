package com.example.smsbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager

const val SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED"

class MainActivity : AppCompatActivity() {

    private val smsReceiver : BroadcastReceiver = SMSBroadCastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filter = IntentFilter().apply {
            addAction(SMS_RECEIVED_ACTION)
        }
        this.registerReceiver(smsReceiver, filter)
        Log.e("start", "Hello")
    }

    override fun onDestroy() {
        unregisterReceiver(smsReceiver)
        super.onDestroy()
    }
    override fun onResume() {
        super.onResume()
        Log.e("register", "Hello")

    }

    //    broadCastReceiver 해제
    override fun onPause() {
        Log.e("unregister", "Hello")
        super.onPause()
        unregisterReceiver(smsReceiver)
    }
}
