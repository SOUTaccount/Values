package com.example.value.presentation.screens.favorites

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.value.domain.logic.ValueInteractor
import com.example.value.domain.mapper.ListValueDomainToUiMapper
import com.example.value.presentation.model.ValueUi
import com.example.value.presentation.screens.value.ValueCommunication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Vladimir Stebakov on 02.08.2022
 */
class FavoritesViewModel @Inject constructor(
    private val communication: ValueCommunication,
    private val mapper: ListValueDomainToUiMapper,
    private val valueInteractor: ValueInteractor
) : ViewModel() {

    private var listValue = arrayListOf<ValueUi>()

    fun fetchValue() {
        communication.map(listOf(ValueUi.Progress))
        viewModelScope.launch(Dispatchers.IO) {
            val resultDomain = valueInteractor.fetchValue(isFavorites = true)
            val resultUi = resultDomain.map(mapper)
            listValue.addAll(resultUi.fetchValues())
            withContext(Dispatchers.Main) {
                if (listValue.isEmpty())
                    communication.map(listOf(ValueUi.Fail("You have not favorites values")))
                else
                    resultUi.map(communication)
            }
        }
    }

    fun changeFavorites(value: ValueUi) {
        val currentValue = (listValue.find { it == value } as ValueUi.Base)
        listValue.remove(currentValue)
        if (listValue.isEmpty())
            communication.map(listOf(ValueUi.Fail("You have not favorites values")))
        else
            communication.map(listValue)
        viewModelScope.launch(Dispatchers.IO) {
            valueInteractor.deleteFavorite(value)
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<ValueUi>>) {
        communication.observe(owner, observer)
    }

}