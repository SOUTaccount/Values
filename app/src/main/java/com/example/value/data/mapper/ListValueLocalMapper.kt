package com.example.value.data.mapper

import com.example.value.core.Abstract
import com.example.value.data.local.LocalValue
import com.example.value.data.model.ValueData
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 03.08.2022
 */
interface ListValueLocalMapper : Abstract.Mapper.Data<List<LocalValue>, List<ValueData>> {

    class Base @Inject constructor(private val mapper: ToValueDataMapper) : ListValueLocalMapper {
        override fun map(data: List<LocalValue>) = data.map { valueDb ->
            valueDb.map(mapper)
        }
    }
}