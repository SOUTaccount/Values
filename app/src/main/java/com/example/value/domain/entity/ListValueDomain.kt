package com.example.value.domain.entity

import com.example.value.core.Abstract
import com.example.value.core.ErrorType
import com.example.value.domain.mapper.ListValueDomainToUiMapper
import com.example.value.presentation.model.ListValueUi

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
sealed class ListValueDomain :
    Abstract.Object<ListValueUi, ListValueDomainToUiMapper> {

    class Success(private val values: List<ValueDomain>) : ListValueDomain() {
        override fun map(mapper: ListValueDomainToUiMapper) = mapper.map(values)
    }

    class Fail(private val errorType: ErrorType) : ListValueDomain() {
        override fun map(mapper: ListValueDomainToUiMapper) = mapper.map(errorType)
    }
}