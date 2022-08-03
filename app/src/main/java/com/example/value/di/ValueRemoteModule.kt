package com.example.value.di

import com.example.value.data.ValueService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
@Module
class ValueRemoteModule {

    @Provides
    fun provideCharactersService(retrofit: Retrofit): ValueService =
        retrofit.create(ValueService::class.java)

}