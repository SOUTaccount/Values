package com.example.value.presentation.model

import com.example.value.core.Abstract
import com.example.value.core.Communication

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
sealed class ListValueUi : Abstract.Object<Unit, Communication<List<ValueUi>>> {
    abstract fun fetchValues(): List<ValueUi>
    data class Base(private val values: List<ValueUi>) : ListValueUi() {
        override fun map(mapper: Communication<List<ValueUi>>) = mapper.map(values)
        override fun fetchValues() = values
    }
}