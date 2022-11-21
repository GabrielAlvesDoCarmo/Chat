package com.gdsdevtec.chat.data.firebase.authentication

interface EmailPassword {
    suspend fun register()
    suspend fun login()
    suspend fun logout()
}