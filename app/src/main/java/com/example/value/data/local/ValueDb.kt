package com.example.value.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.value.data.mapper.ToValueDataMapper

/**
 * Created by Vladimir Stebakov on 03.08.2022
 */
@Entity(tableName = "favorites")
data class ValueDb(
    @PrimaryKey(autoGenerate = true)
    var favoriteId: Int = 0,
    var id: String,
    var numCode: String,
    var charCode: String,
    var nominal: Int,
    var name: String,
    var value: Double,
    var previousValue: Double
) : LocalValue {
    override fun map(mapper: ToValueDataMapper) =
        mapper.map(id, numCode, charCode, nominal, name, value, previousValue)
}
