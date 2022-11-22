package com.gdsdevtec.chat.di

import com.gdsdevtec.chat.data.firebase.analytics.AnalyticsServiceImpl
import com.gdsdevtec.chat.data.firebase.authentication.EmailPasswordImp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {
    private val auth by lazy { Firebase.auth }
    private val analytics by lazy { Firebase.analytics }
    private val realtime by lazy { Firebase.database.reference }
    private val fireStore by lazy { Firebase.firestore }
    private val storage by lazy { Firebase.storage }

    @Provides
    @Singleton
    fun authentication(): FirebaseAuth {
        return auth
    }

    @Provides
    @Singleton
    fun realtime(): DatabaseReference {
        return realtime
    }

    @Provides
    @Singleton
    fun fireStore(): FirebaseFirestore {
        return fireStore
    }

    @Provides
    @Singleton
    fun storage(): FirebaseStorage {
        return storage
    }

    @Provides
    @Singleton
    fun analytics(): FirebaseAnalytics {
        return analytics
    }

    @Provides
    @Singleton
    fun remoteConfig(): FirebaseRemoteConfig {
        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        return remoteConfig
    }

    @Provides
    @Singleton
    fun analyticsService(): AnalyticsServiceImpl {
        return AnalyticsServiceImpl(analytics)
    }

    @Provides
    @Singleton
    fun emailAnPassword(): EmailPasswordImp {
        return EmailPasswordImp(auth)
    }

}