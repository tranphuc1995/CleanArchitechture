package com.tranphuc.data.di


import com.tranphuc.data.mapper.UserEntityToUser
import org.koin.core.module.Module
import org.koin.dsl.module

val mapperModule: Module = module {
    factory { UserEntityToUser() }

}