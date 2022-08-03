package com.example.value.data

import com.example.value.data.local.ValueDatabase
import com.example.value.data.local.ValueDb
import com.example.value.data.mapper.ListValueCloudMapper
import com.example.value.data.mapper.ListValueLocalMapper
import com.example.value.data.model.ListValueData
import com.example.value.domain.ValueRepository
import javax.inject.Inject
import kotlin.Exception

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
class ValueRepositoryImpl @Inject constructor(
    private val valueService: ValueService,
    private val cloudMapper: ListValueCloudMapper,
    private val localMapper: ListValueLocalMapper,
    private val database: ValueDatabase
) : ValueRepository {
    override suspend fun fetchValues(isFavorites: Boolean) = try {
        val valueLocal = database.valueDao().getFavorites()
        val valueCloud = valueService.fetchValues()
        val listValueData = valueCloud.map(cloudMapper)
        if (isFavorites)
            ListValueData.Success(localMapper.map(valueLocal))
        else
            ListValueData.Success(listValueData)
    } catch (e: Exception) {
        ListValueData.Fail(e)
    }

    override suspend fun fetchLocalValues() = try {
        val valueLocal = database.valueDao().getFavorites()
        localMapper.map(valueLocal)
    } catch (e: Exception) {
        emptyList()
    }

    override suspend fun addFavorite(value: ValueDb) {
        database.valueDao().addFavorite(value)
    }

    override suspend fun deleteFavorite(value: ValueDb) {
        database.valueDao().deleteFavorite(value)
    }
}