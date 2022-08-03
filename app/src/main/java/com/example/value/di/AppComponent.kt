package com.example.value.di

import android.app.Application
import android.content.Context
import com.example.value.App
import com.example.value.core.ResourceProvider
import com.example.value.presentation.screens.favorites.FavoritesValueFragment
import com.example.value.presentation.screens.value.ValueFragment
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */

@Component(
    modules = [
        AppModule::class,
        CoreModule::class,
        ValueRemoteModule::class,
        NetworkModule::class,
        ValueInteractorModule::class,
        ValueMapperModule::class,
    ]
)

interface AppComponent {

    fun inject(app: App)
    fun inject(valueFragment: ValueFragment)
    fun inject(favoritesValueFragment: FavoritesValueFragment)
    fun resourceProvider(): ResourceProvider
    fun context(): Context
    fun retrofit(): Retrofit

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun core(coreModule: CoreModule): Builder
        fun build(): AppComponent
    }
}
