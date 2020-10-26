package com.tranphuc.home_page.di



import com.tranphuc.domain.usecases.GetListUserFromApiUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

val useCaseModule: Module = module {
    factory { GetListUserFromApiUseCase(get()) }
}