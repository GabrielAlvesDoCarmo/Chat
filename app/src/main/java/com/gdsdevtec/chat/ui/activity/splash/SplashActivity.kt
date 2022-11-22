package com.gdsdevtec.chat.ui.activity.splash

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.view.View
import com.gdsdevtec.chat.BuildConfig
import com.gdsdevtec.chat.data.firebase.analytics.AnalyticsServiceImpl
import com.gdsdevtec.chat.databinding.ActivitySplashBinding
import com.gdsdevtec.chat.ui.activity.core.BaseActivity
import com.gdsdevtec.chat.ui.activity.main.MainActivity
import com.gdsdevtec.chat.util.constants.ActivityConstants
import com.gdsdevtec.chat.util.extensions.nextScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    @Inject
    lateinit var analyticsServiceImpl: AnalyticsServiceImpl

    override fun activityBind(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun viewRoot(): View {
        return activityBind().root
    }

    override fun onCreateCode() {
        analyticsServiceImpl.appOpen("abriu ")
        analyticsServiceImpl.screenInfo("SplashActivity")
        initComponents()
        actionSplash()
    }


    private fun initComponents() {
        binding.versionApp.text = BuildConfig.VERSION_NAME
    }

    private fun actionSplash() {
        delaySplash {
            nextScreen(MainActivity())
        }
    }

    private fun delaySplash(function: () -> Unit) {
        Handler(Looper.myLooper() ?: return).postDelayed({
            function.invoke()
            finish()
        }, ActivityConstants.TIME_DELAY)
    }
}
