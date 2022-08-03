package com.example.value.data.model

import com.example.value.core.Abstract
import com.example.value.data.mapper.ToValueDataMapper
import com.google.gson.annotations.SerializedName

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
data class ValueCloud(
    @SerializedName("ID")
    private val id: String,
    @SerializedName("NumCode")
    private val numCode: String,
    @SerializedName("CharCode")
    private val charCode: String,
    @SerializedName("Nominal")
    private val nominal: Int,
    @SerializedName("Name")
    private val name: String,
    @SerializedName("Value")
    private val value: Double,
    @SerializedName("Previous")
    private val previousValue: Double
) : Abstract.Object<ValueData, ToValueDataMapper> {
    override fun map(mapper: ToValueDataMapper) =
        mapper.map(id, numCode, charCode, nominal, name, value, previousValue)
}