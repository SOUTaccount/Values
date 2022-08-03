package com.example.value.data.mapper

import com.example.value.core.Abstract
import com.example.value.data.local.ValueDb
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 03.08.2022
 */
interface ToValueDbMapper : Abstract.Mapper {
    fun map(
        id: String,
        numCode: String,
        charCode: String,
        nominal: Int,
        name: String,
        value: Double,
        previousValue: Double
    ): ValueDb

    class Base @Inject constructor() : ToValueDbMapper {
        override fun map(
            id: String,
            numCode: String,
            charCode: String,
            nominal: Int,
            name: String,
            value: Double,
            previousValue: Double
        ) = ValueDb(numCode.toInt(), id, numCode, charCode, nominal, name, value, previousValue)
    }
}