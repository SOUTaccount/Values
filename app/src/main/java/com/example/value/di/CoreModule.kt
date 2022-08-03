package com.example.value.di

import android.app.Application
import android.content.Context
import com.example.value.core.ResourceProvider
import com.example.value.data.local.ValueDatabase
import com.example.value.presentation.screens.value.ValueCommunication
import dagger.Module
import dagger.Provides

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
@Module
class CoreModule(private val application: Application) {
    @Provides
    fun provideContext(): Context = application

    @Provides
    fun provideValueCommunication(): ValueCommunication = ValueCommunication()

    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProvider.Base(context)
    }

    @Provides
    fun provideRoom(context: Context) = ValueDatabase.getInstance(context)
}