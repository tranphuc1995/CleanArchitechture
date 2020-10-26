package com.tranphuc.data


import com.haroldadmin.cnradapter.NetworkResponse
import com.tranphuc.data.mapper.UserEntityToUser
import com.tranphuc.data.remote.api.UserApi
import com.tranphuc.domain.model.User
import com.tranphuc.domain.repository.UserRepository


class UserRepositoryImpl(val userApi: UserApi, val userEntityToUser: UserEntityToUser) :
    UserRepository {


    override suspend fun getListUserFromApi(page: String): List<User> {
        var result: List<User> = ArrayList()
        val response = userApi.getListUser(page, "10", "stackoverflow")
        when (response) {
            is NetworkResponse.Success -> {
                var listUserEntity = response.body.listUserApiEntity
                var listUserDomain = listUserEntity.map { userEntity -> userEntityToUser.map(userEntity) }
                return listUserDomain
            }
            is NetworkResponse.ServerError -> {
               return result
            }
            is NetworkResponse.NetworkError -> {
                return result
            }
            is NetworkResponse.UnknownError -> {
                return result
            }
        }
    }
}