package com.gdsdevtec.chat.ui.activity.splash

import android.annotation.SuppressLint
import android.view.View
import com.gdsdevtec.chat.databinding.ActivitySplashBinding
import com.gdsdevtec.chat.ui.activity.core.BaseActivity
import com.gdsdevtec.chat.ui.activity.main.MainActivity
import com.gdsdevtec.chat.util.constants.ActivityConstants
import com.gdsdevtec.chat.util.extensions.nextScreen
import com.gdsdevtec.chat.util.extensions.delaySplash

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override fun activityBind(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun viewRoot(): View {
        return activityBind().root
    }

    override fun onCreateCode() {
        delaySplash(ActivityConstants.TIME_DELAY) {
            nextScreen(MainActivity())
        }
    }
}
