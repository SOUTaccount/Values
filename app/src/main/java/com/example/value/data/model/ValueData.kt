package com.example.value.data.model

import com.example.value.core.Abstract
import com.example.value.data.mapper.ValueDataToDomainMapper
import com.example.value.domain.entity.ValueDomain
import com.google.gson.annotations.SerializedName

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
data class ValueData(
    private val id: String,
    private val numCode: String,
    private val charCode: String,
    private val nominal: Int,
    private val name: String,
    private val value: Double,
    private val previousValue: Double,
    private var isFavorite: Boolean = false
) : Abstract.Object<ValueDomain, ValueDataToDomainMapper> {
    override fun map(mapper: ValueDataToDomainMapper) =
        mapper.map(id, numCode, charCode, nominal, name, value, previousValue, isFavorite)

    fun changeToFavorite() {
        isFavorite = true
    }
}