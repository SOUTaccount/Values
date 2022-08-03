package com.example.value.presentation.model

import com.example.value.core.Abstract
import com.example.value.core.ValueReader
import com.example.value.data.local.ValueDb
import com.example.value.data.mapper.ToValueDbMapper

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
sealed class ValueUi {

    abstract fun mapTitle(): String

    data class Base(
        private val id: String,
        private val numCode: String,
        private val charCode: String,
        private val nominal: Int,
        private val name: String,
        private val value: Double,
        private val previousValue: Double,
        private var isFavorite: Boolean
    ) : ValueUi(), ValueReader<String>, Abstract.Object<ValueDb, ToValueDbMapper> {
        override fun mapTitle() = name
        override fun mapValue() = value.toString()
        override fun map(mapper: ToValueDbMapper) =
            mapper.map(id, numCode, charCode, nominal, name, value, previousValue)

        fun changeFavorite() {
            isFavorite = !isFavorite
        }

        fun isFavorite() = isFavorite
    }

    data class Fail(private val message: String) : ValueUi() {
        override fun mapTitle() = message
    }

    object Progress : ValueUi() {
        override fun mapTitle() = ""
    }
}