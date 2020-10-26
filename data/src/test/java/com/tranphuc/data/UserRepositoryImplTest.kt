package com.tranphuc.data

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.tranphuc.data.di.BASE_URL
import com.tranphuc.data.mapper.UserEntityToUser
import com.tranphuc.data.remote.api.UserApi
import com.tranphuc.domain.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.junit.Assert.assertEquals


class UserRepositoryImplTest {
    lateinit var mUserRepository: UserRepository
    lateinit var mUserApi: UserApi

    @Before
    fun setUp() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()
        mUserApi = retrofit.create(UserApi::class.java)

        var userEntityToUser = UserEntityToUser()
        mUserRepository = UserRepositoryImpl(mUserApi, userEntityToUser)
    }


    @Test
    fun test_get_list_user_from_api_success() = runBlocking {
       var result =  mUserRepository.getListUserFromApi("1")
        assertEquals(9,result.size )
    }
}