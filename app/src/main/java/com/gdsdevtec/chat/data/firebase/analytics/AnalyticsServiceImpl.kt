package com.gdsdevtec.chat.data.firebase.analytics

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnalyticsServiceImpl @Inject constructor(
    private val analytics: FirebaseAnalytics
) : AnalyticsService {
    override suspend fun logEventStartScreen(screenName: String, actualDate: String) {
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
            param(FirebaseAnalytics.Param.START_DATE, actualDate)
        }
    }

    override suspend fun logEventExitScreen(screenName: String, actualDate: String) {
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
            param(FirebaseAnalytics.Param.END_DATE, actualDate)
        }
    }
}