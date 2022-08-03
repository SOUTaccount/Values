package com.example.value.data.mapper

import com.example.value.core.Abstract
import com.example.value.data.model.ValueCloud
import com.example.value.data.model.ValueData
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
interface ListValueCloudMapper :
    Abstract.Mapper.Data<List<ValueCloud>, List<ValueData>> {

    class Base @Inject constructor(private val mapper: ToValueDataMapper) : ListValueCloudMapper {
        override fun map(data: List<ValueCloud>) = data.map { valueCloud ->
            valueCloud.map(mapper)
        }
    }
}