package com.gdsdevtec.chat.data.repository

import javax.inject.Inject

class ManagerRepository @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) {
}
