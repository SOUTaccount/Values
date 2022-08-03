package com.example.value.data.local

import androidx.room.*

/**
 * Created by Vladimir Stebakov on 03.08.2022
 */
@Dao
interface ValueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavorite(value: ValueDb)

    @Query("SELECT * FROM favorites")
    fun getFavorites(): List<ValueDb>

    @Delete
    suspend fun deleteFavorite(value: ValueDb)
}