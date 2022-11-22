package com.gdsdevtec.chat.data.firebase.authentication

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class EmailPasswordImp @Inject constructor(
    private val auth: FirebaseAuth
) : EmailPassword {
    override suspend fun register(email: String, password: String): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
    }

    override suspend fun login(email: String, password: String): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
    }

    override suspend fun resetPassword(email: String): Task<Void> {
        return auth.sendPasswordResetEmail(email)
    }

    override suspend fun logout() {
        return auth.signOut()
    }
}