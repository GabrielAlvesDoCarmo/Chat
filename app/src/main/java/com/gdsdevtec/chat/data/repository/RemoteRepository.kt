package com.gdsdevtec.chat.data.repository

import com.gdsdevtec.chat.data.firebase.analytics.AnalyticsServiceImpl
import com.gdsdevtec.chat.data.firebase.authentication.EmailPassword
import com.gdsdevtec.chat.data.firebase.authentication.EmailPasswordImp
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val analyticsServiceImpl: AnalyticsServiceImpl,
    private val emailPasswordImp: EmailPasswordImp
) {
    //Firebase Analytics
    fun eventAppOpen(dateEvent: String): Unit {
        return analyticsServiceImpl.appOpen(dateEvent)
    }

    fun eventScreenInfo(nameScreen: String): Unit {
        return analyticsServiceImpl.screenInfo(nameScreen)
    }

    //Firebase Auth
    suspend fun register(email: String, password: String): Task<AuthResult> {
        return emailPasswordImp.register(email, password)
    }

    suspend fun login(email: String, password: String): Task<AuthResult> {
        return emailPasswordImp.login(email, password)
    }


}
