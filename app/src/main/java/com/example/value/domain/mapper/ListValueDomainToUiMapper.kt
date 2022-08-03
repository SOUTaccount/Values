package com.example.value.domain.mapper

import com.example.value.core.Abstract
import com.example.value.core.ResourceProvider
import com.example.value.domain.entity.ValueDomain
import com.example.value.presentation.model.ListValueUi

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
abstract class ListValueDomainToUiMapper(resourceProvider: ResourceProvider) :
    Abstract.Mapper.DomainToUi.Base<List<ValueDomain>, ListValueUi>(resourceProvider) {
}