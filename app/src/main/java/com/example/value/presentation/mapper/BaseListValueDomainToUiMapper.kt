package com.example.value.presentation.mapper

import com.example.value.core.ErrorType
import com.example.value.core.ResourceProvider
import com.example.value.domain.entity.ValueDomain
import com.example.value.domain.mapper.ListValueDomainToUiMapper
import com.example.value.domain.mapper.ValueDomainToUiMapper
import com.example.value.presentation.model.ListValueUi
import com.example.value.presentation.model.ValueUi
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
class BaseListValueDomainToUiMapper @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val mapper: ValueDomainToUiMapper
) : ListValueDomainToUiMapper(resourceProvider) {
    override fun map(errorType: ErrorType) =
        ListValueUi.Base(listOf(ValueUi.Fail(errorMessage(errorType))))

    override fun map(data: List<ValueDomain>) = ListValueUi.Base(data.map {
        it.map(mapper)
    })
}