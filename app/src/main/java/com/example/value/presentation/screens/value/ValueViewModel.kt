package com.example.value.presentation.screens.value

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.value.domain.logic.ValueInteractor
import com.example.value.domain.mapper.ListValueDomainToUiMapper
import com.example.value.presentation.model.ValueUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
class ValueViewModel @Inject constructor(
    private val communication: ValueCommunication,
    private val mapper: ListValueDomainToUiMapper,
    private val valueInteractor: ValueInteractor
) : ViewModel() {

    private var listValue = arrayListOf<ValueUi>()

    fun fetchValue() {
        communication.map(listOf(ValueUi.Progress))
        viewModelScope.launch(Dispatchers.IO) {
            val resultDomain = valueInteractor.fetchValue(isFavorites = false)
            val resultUi = resultDomain.map(mapper)
            listValue.clear()
            listValue.addAll(resultUi.fetchValues())
            withContext(Dispatchers.Main) {
                resultUi.map(communication)
            }
        }
    }

    fun changeFavorites(value: ValueUi) {
        val currentValue = (listValue.find { it == value } as ValueUi.Base)
        currentValue.changeFavorite()
        communication.map(listValue)
        viewModelScope.launch(Dispatchers.IO) {
            if (currentValue.isFavorite())
                valueInteractor.addFavorite(value)
            else
                valueInteractor.deleteFavorite(value)
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<ValueUi>>) {
        communication.observe(owner, observer)
    }
}