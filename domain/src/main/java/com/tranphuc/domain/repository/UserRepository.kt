package com.tranphuc.domain.repository

import com.tranphuc.domain.model.User

interface UserRepository {
    // get list user from API
    suspend fun getListUserFromApi(page: String): List<User>

}