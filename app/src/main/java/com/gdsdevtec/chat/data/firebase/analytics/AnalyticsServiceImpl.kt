package com.gdsdevtec.chat.data.firebase.analytics

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import javax.inject.Inject

class AnalyticsServiceImpl @Inject constructor(
    private val analytics: FirebaseAnalytics
) : AnalyticsService {
    override fun appOpen(date: String) {
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.START_DATE, date)
        }
    }

    override fun screenInfo(screenClass: String) {
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_CLASS, screenClass)
            param(FirebaseAnalytics.Param.SCREEN_NAME, screenClass)
        }
    }

}
