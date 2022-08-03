package com.example.value.domain.mapper

import com.example.value.core.Abstract
import com.example.value.presentation.model.ValueUi

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
interface ValueDomainToUiMapper : Abstract.Mapper {
    fun map(
        id: String,
        numCode: String,
        charCode: String,
        nominal: Int,
        name: String,
        value: Double,
        previousValue: Double,
        isFavorite: Boolean
    ): ValueUi
}