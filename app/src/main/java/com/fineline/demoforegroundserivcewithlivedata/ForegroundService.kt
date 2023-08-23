package com.fineline.demoforegroundserivcewithlivedata

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

private const val TAG = "ForegroundService"

class ForegroundService : Service() {

    init {
        id++
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand recieved on instance #$id")
        when (intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        val notification = NotificationCompat
            .Builder(this, "foreground_service")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Demo Foreground Service")
            .setContentText("This just an exploration of foreground service.")
            .build()

        startForeground(1, notification)
    }

    enum class Actions {START, STOP}

        companion object {
           var id: Int = 0
        }
}