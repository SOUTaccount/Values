package com.example.value.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
interface Communication<T : Any> : Abstract.Mapper.Data<T, Unit> {
    fun observe(owner: LifecycleOwner, observer: Observer<T>)

    abstract class Base<T : Any> : Communication<T> {
        private val liveData = MutableLiveData<T>()
        override fun map(data: T) {
            liveData.value = data
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) =
            liveData.observe(owner, observer)
    }
}