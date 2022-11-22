package com.gdsdevtec.chat.data.firebase.analytics

interface AnalyticsService {
    fun appOpen(date: String)
    fun screenInfo(screenClass: String)
}
