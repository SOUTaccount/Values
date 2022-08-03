package com.example.value.data.mapper

import com.example.value.core.Abstract
import com.example.value.data.model.ValueData
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
interface ToValueDataMapper : Abstract.Mapper {
    fun map(
        id: String,
        numCode: String,
        charCode: String,
        nominal: Int,
        name: String,
        value: Double,
        previousValue: Double
    ): ValueData

    class Base @Inject constructor() : ToValueDataMapper {
        override fun map(
            id: String,
            numCode: String,
            charCode: String,
            nominal: Int,
            name: String,
            value: Double,
            previousValue: Double
        ) = ValueData(id, numCode, charCode, nominal, name, value, previousValue)
    }
}