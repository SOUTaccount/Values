package com.example.value.di

import com.example.value.domain.logic.ValueInteractor
import com.example.value.domain.mapper.ListValueDomainToUiMapper
import com.example.value.presentation.screens.favorites.FavoritesViewModel
import com.example.value.presentation.screens.value.ValueCommunication
import com.example.value.presentation.screens.value.ValueViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
@Module
class ViewModelModule {

    @Provides
    fun provideValueViewModule(
        communication: ValueCommunication,
        mapper: ListValueDomainToUiMapper,
        valueInteractor: ValueInteractor
    ) = ValueViewModel(communication, mapper, valueInteractor)

    @Provides
    fun provideFavoritesViewModule(
        communication: ValueCommunication,
        mapper: ListValueDomainToUiMapper,
        valueInteractor: ValueInteractor
    ) = FavoritesViewModel(communication, mapper, valueInteractor)
}