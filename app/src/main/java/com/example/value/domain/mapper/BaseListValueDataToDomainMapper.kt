package com.example.value.domain.mapper

import com.example.value.data.mapper.ListValueDataToDomainMapper
import com.example.value.data.mapper.ValueDataToDomainMapper
import com.example.value.data.model.ValueData
import com.example.value.domain.entity.ListValueDomain
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
class BaseListValueDataToDomainMapper @Inject constructor(private val mapper: ValueDataToDomainMapper) :
    ListValueDataToDomainMapper() {
    override fun map(e: Exception) = ListValueDomain.Fail(errorType(e))

    override fun map(data: List<ValueData>): ListValueDomain {
        val valueDomainList = data.map { valueData ->
            valueData.map(mapper)
        }
        return ListValueDomain.Success(valueDomainList)
    }
}