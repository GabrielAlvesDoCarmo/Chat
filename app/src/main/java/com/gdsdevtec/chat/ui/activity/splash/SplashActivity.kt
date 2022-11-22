package com.gdsdevtec.chat.ui.activity.splash

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.view.View
import com.gdsdevtec.chat.BuildConfig
import com.gdsdevtec.chat.databinding.ActivitySplashBinding
import com.gdsdevtec.chat.ui.activity.core.BaseActivity
import com.gdsdevtec.chat.ui.activity.main.MainActivity
import com.gdsdevtec.chat.util.constants.ActivityConstants
import com.gdsdevtec.chat.util.extensions.nextScreen

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override fun activityBind(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun viewRoot(): View {
        return activityBind().root
    }

    override fun onCreateCode() {
        initComponents()
        actionSplash()
    }

    private fun initComponents() {
        binding.versionApp.text = BuildConfig.VERSION_NAME
    }

    private fun actionSplash() {
        delaySplash(ActivityConstants.TIME_DELAY) {
            nextScreen(MainActivity())
        }
    }

    private fun SplashActivity.delaySplash(timeSplash: Long, function: () -> Unit) {
        Handler(Looper.myLooper() ?: return).postDelayed({
            function.invoke()
            finish()
        }, timeSplash)
    }
}
