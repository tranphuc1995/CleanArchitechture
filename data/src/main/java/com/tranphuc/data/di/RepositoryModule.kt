package com.tranphuc.data.di


import com.tranphuc.data.UserRepositoryImpl
import com.tranphuc.domain.repository.UserRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    factory { UserRepositoryImpl(get(),get()) as UserRepository }
}