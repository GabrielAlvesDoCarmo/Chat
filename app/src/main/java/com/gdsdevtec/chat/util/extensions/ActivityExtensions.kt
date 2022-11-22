package com.gdsdevtec.chat.util.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.nextScreen(activity: AppCompatActivity) {
    Intent(this, activity::class.java).apply {
        startActivity(this)
    }
}