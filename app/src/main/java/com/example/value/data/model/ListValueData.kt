package com.example.value.data.model

import com.example.value.core.Abstract
import com.example.value.data.mapper.ListValueDataToDomainMapper
import com.example.value.domain.entity.ListValueDomain
import java.lang.Exception

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
sealed class ListValueData :
    Abstract.Object<ListValueDomain, ListValueDataToDomainMapper> {

    abstract fun compare(favorites: List<ValueData>)

    class Success(private val values: List<ValueData>) : ListValueData() {
        override fun map(mapper: ListValueDataToDomainMapper): ListValueDomain {
            return mapper.map(values)
        }

        override fun compare(favorites: List<ValueData>) {
            favorites.forEach { favValue ->
                values.filter { dataValue ->
                    dataValue == favValue
                }.forEach { newValue ->
                    newValue.changeToFavorite()
                }
            }
        }
    }

    class Fail(private val e: Exception) : ListValueData() {
        override fun map(mapper: ListValueDataToDomainMapper): ListValueDomain {
            return mapper.map(e)
        }

        override fun compare(favorites: List<ValueData>) = Unit
    }
}