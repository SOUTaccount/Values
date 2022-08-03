package com.example.value.domain.logic

import com.example.value.data.mapper.ListValueDataToDomainMapper
import com.example.value.data.mapper.ToValueDbMapper
import com.example.value.data.model.ValueData
import com.example.value.domain.ValueRepository
import com.example.value.domain.entity.ListValueDomain
import com.example.value.presentation.model.ValueUi
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
interface ValueInteractor {
    suspend fun fetchValue(isFavorites: Boolean): ListValueDomain
    suspend fun addFavorite(value: ValueUi)
    suspend fun deleteFavorite(value: ValueUi)

    class Base @Inject constructor(
        private val repository: ValueRepository,
        private val mapper: ListValueDataToDomainMapper,
        private val mapperToDb: ToValueDbMapper
    ) : ValueInteractor {
        override suspend fun fetchValue(isFavorites: Boolean): ListValueDomain {
            val favorites = fetchLocalValues()
            val valuesData = repository.fetchValues(isFavorites)
            if (favorites.isNotEmpty())
                valuesData.compare(favorites)
            return valuesData.map(mapper)
        }

        override suspend fun addFavorite(value: ValueUi) {
            val favoriteValue = (value as ValueUi.Base).map(mapperToDb)
            repository.addFavorite(favoriteValue)
        }

        override suspend fun deleteFavorite(value: ValueUi) {
            val favoriteValue = (value as ValueUi.Base).map(mapperToDb)
            repository.deleteFavorite(favoriteValue)
        }

        private suspend fun fetchLocalValues(): List<ValueData> {
            return repository.fetchLocalValues()
        }
    }
}