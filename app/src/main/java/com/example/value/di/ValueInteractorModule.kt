package com.example.value.di

import com.example.value.domain.logic.ValueInteractor
import dagger.Binds
import dagger.Module

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */

@Module
interface ValueInteractorModule {

    @Binds
    fun provideValueInteractor(interactor: ValueInteractor.Base): ValueInteractor

}