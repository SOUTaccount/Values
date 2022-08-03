package com.example.value.data.model

import com.example.value.core.Abstract
import com.example.value.data.mapper.ListValueCloudMapper
import com.google.gson.annotations.SerializedName

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
data class ResponseCloud(
    @SerializedName("Date")
    private val date: String,
    @SerializedName("PreviousDate")
    private val previousDate: String,
    @SerializedName("PreviousURL")
    private val previousUrl: String,
    @SerializedName("Timestamp")
    private val timeStamp: String,
    @SerializedName("Valute")
    private val listValue: Map<String,ValueCloud>
) : Abstract.Object<List<ValueData>, ListValueCloudMapper> {
    override fun map(mapper: ListValueCloudMapper) = mapper.map(listValue.values.toList())
}