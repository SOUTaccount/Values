package com.example.value.domain.mapper

import com.example.value.data.mapper.ValueDataToDomainMapper
import com.example.value.domain.entity.ValueDomain
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
class BaseValueDataToDomainMapper @Inject constructor(): ValueDataToDomainMapper {
    override fun map(
        id: String,
        numCode: String,
        charCode: String,
        nominal: Int,
        name: String,
        value: Double,
        previousValue: Double,
        isFavorite: Boolean
    ) = ValueDomain(id, numCode, charCode, nominal, name, value, previousValue,isFavorite)
}