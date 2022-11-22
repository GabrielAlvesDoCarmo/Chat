package com.gdsdevtec.chat.data.repository

import com.gdsdevtec.chat.data.firebase.analytics.AnalyticsServiceImpl
import com.gdsdevtec.chat.data.firebase.authentication.EmailPasswordImp
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val analyticsServiceImpl: AnalyticsServiceImpl,
    private val emailPasswordImp: EmailPasswordImp
) {
    //Firebase Analytics
    fun eventAppOpen(dateEvent: String): Unit = analyticsServiceImpl.appOpen(dateEvent)
    fun eventScreenInfo(nameScreen: String): Unit = analyticsServiceImpl.screenInfo(nameScreen)

}
