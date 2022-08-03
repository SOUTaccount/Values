package com.example.value.di

import com.example.value.data.ValueRepositoryImpl
import com.example.value.domain.ValueRepository
import dagger.Binds
import dagger.Module

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
@Module
interface AppModule {

    @Binds
    fun valueRepository(valueRepositoryImpl: ValueRepositoryImpl): ValueRepository
}