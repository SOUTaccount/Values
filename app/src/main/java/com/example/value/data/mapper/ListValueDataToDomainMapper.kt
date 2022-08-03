package com.example.value.data.mapper

import com.example.value.core.Abstract
import com.example.value.data.model.ValueData
import com.example.value.domain.entity.ListValueDomain

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
abstract class ListValueDataToDomainMapper :
    Abstract.Mapper.DataToDomain.Base<List<ValueData>, ListValueDomain>() {
}