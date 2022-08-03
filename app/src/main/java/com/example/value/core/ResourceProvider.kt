package com.example.value.core

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
interface ResourceProvider {
    fun getString(@StringRes id: Int): String
    fun getString(@StringRes id: Int, vararg args: Any): String

    @Singleton
    class Base @Inject constructor(@Named("AppContext") private val context: Context) :
        ResourceProvider {
        override fun getString(id: Int) = context.getString(id)

        override fun getString(id: Int, vararg args: Any) = context.getString(id, args)

    }
}