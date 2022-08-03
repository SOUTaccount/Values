package com.example.value.data.mapper

import com.example.value.core.Abstract
import com.example.value.domain.entity.ValueDomain

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
interface ValueDataToDomainMapper : Abstract.Mapper {
    fun map(
        id: String,
        numCode: String,
        charCode: String,
        nominal: Int,
        name: String,
        value: Double,
        previousValue: Double,
        isFavorite: Boolean
    ): ValueDomain
}