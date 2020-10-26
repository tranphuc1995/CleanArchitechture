package com.tranphuc.home_page

import com.tranphuc.domain.model.User
import com.tranphuc.domain.repository.UserRepository
import com.tranphuc.domain.usecases.GetListUserFromApiUseCase
import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UseCaseTest {
    @Test
    fun test_logic_change_bookmark_list_user() = runBlocking {
        var userRepository = mock(UserRepository::class.java)
        var getListUserFromApiUseCase = GetListUserFromApiUseCase(userRepository)

        var listUser: MutableList<User> = ArrayList()
        listUser.add(User("1", "Phuc", "xxx", 0, "Sendo", 0, false))
        listUser.add(User("1", "Viet", "xxx", 0, "Sendo", 0, false))
        listUser.add(User("1", "Tu", "xxx", 0, "Sendo", 0, false))
        listUser.add(User("1", "Dung", "xxx", 0, "Sendo", 0, false))
        listUser.add(User("1", "Doan", "xxx", 0, "Sendo", 0, false))


        Mockito.`when`(userRepository.getListUserFromApi("1")).thenReturn(listUser)

        assertEquals(true, getListUserFromApiUseCase.execute("1").get(2).isBookMarked)
    }
}