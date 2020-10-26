package com.tranphuc.data.mapper

import com.tranphuc.data.model.UserEntity
import com.tranphuc.domain.model.User

class UserEntityToUser {
    fun map(userEntity: UserEntity) : User{
        var user = User(
            userEntity.userID?:"",
            userEntity.displayName?:"",
            userEntity.userAvatar ?:"",
            userEntity.reputation ?:0,
            userEntity.location ?:"",
            userEntity.lastAccessDate ?:0,
            false
        )
        return user
    }
}