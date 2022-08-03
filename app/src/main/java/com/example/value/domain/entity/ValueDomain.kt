package com.example.value.domain.entity

import com.example.value.core.Abstract
import com.example.value.domain.mapper.ValueDomainToUiMapper
import com.example.value.presentation.model.ValueUi

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
data class ValueDomain(
    private val id: String,
    private val numCode: String,
    private val charCode: String,
    private val nominal: Int,
    private val name: String,
    private val value: Double,
    private val previousValue: Double,
    private val isFavorite: Boolean
) : Abstract.Object<ValueUi, ValueDomainToUiMapper> {
    override fun map(mapper: ValueDomainToUiMapper) =
        mapper.map(id, numCode, charCode, nominal, name, value, previousValue, isFavorite)
}