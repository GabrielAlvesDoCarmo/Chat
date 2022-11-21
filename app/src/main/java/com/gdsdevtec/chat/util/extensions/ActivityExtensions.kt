package com.gdsdevtec.chat.util.extensions

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.gdsdevtec.chat.ui.activity.splash.SplashActivity

fun SplashActivity.delaySplash(timeSplash: Long, function: () -> Unit) {
    Handler(Looper.myLooper() ?: return).postDelayed({
        function.invoke()
        finish()
    }, timeSplash)
}

fun AppCompatActivity.nextScreen(activity: AppCompatActivity) {
    Intent(this, activity::class.java).apply {
        startActivity(this)
    }
}