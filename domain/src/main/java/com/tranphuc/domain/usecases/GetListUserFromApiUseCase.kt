package com.tranphuc.domain.usecases

import com.tranphuc.domain.model.User
import com.tranphuc.domain.repository.UserRepository

class GetListUserFromApiUseCase(val userRepository: UserRepository) {
    suspend fun execute(page: String): List<User> {
        var listUser = userRepository.getListUserFromApi(page)
        changeBookmarkListUser(listUser)
        return listUser
    }

    private fun changeBookmarkListUser(listUser: List<User>) {
        for (i in (listUser.indices)) {
            listUser.get(i).isBookMarked = (i % 2 == 0)
        }
    }
}