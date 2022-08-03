package com.example.value.presentation.mapper

import com.example.value.domain.mapper.ValueDomainToUiMapper
import com.example.value.presentation.model.ValueUi
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
class BaseValueDomainToUiMapper @Inject constructor() : ValueDomainToUiMapper {
    override fun map(
        id: String,
        numCode: String,
        charCode: String,
        nominal: Int,
        name: String,
        value: Double,
        previousValue: Double,
        isFavorite: Boolean
    ) = ValueUi.Base(id, numCode, charCode, nominal, name, value, previousValue, isFavorite)
}