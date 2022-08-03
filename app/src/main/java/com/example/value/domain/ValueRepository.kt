package com.example.value.domain

import com.example.value.data.local.ValueDb
import com.example.value.data.model.ListValueData
import com.example.value.data.model.ValueData

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
interface ValueRepository {
    suspend fun fetchValues(isFavorites: Boolean): ListValueData
    suspend fun fetchLocalValues(): List<ValueData>
    suspend fun deleteFavorite(value: ValueDb)
    suspend fun addFavorite(value: ValueDb)
}