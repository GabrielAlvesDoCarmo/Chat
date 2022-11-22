package com.gdsdevtec.chat.data.firebase.analytics

interface AnalyticsService {
    suspend fun logEventStartScreen(screenName: String, actualDate: String)
    suspend fun logEventExitScreen(screenName: String, actualDate: String)
}