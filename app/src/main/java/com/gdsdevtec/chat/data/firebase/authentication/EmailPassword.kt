package com.gdsdevtec.chat.data.firebase.authentication

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface EmailPassword {
    suspend fun register(email: String, password: String): Task<AuthResult>
    suspend fun login(email: String, password: String): Task<AuthResult>
    suspend fun resetPassword(email: String): Task<Void>
    suspend fun logout()
}