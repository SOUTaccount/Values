package com.example.value.di

import com.example.value.data.mapper.*
import com.example.value.domain.mapper.BaseListValueDataToDomainMapper
import com.example.value.domain.mapper.BaseValueDataToDomainMapper
import com.example.value.domain.mapper.ListValueDomainToUiMapper
import com.example.value.domain.mapper.ValueDomainToUiMapper
import com.example.value.presentation.mapper.BaseListValueDomainToUiMapper
import com.example.value.presentation.mapper.BaseValueDomainToUiMapper
import dagger.Binds
import dagger.Module

/**
 * Created by Vladimir Stebakov on 31.07.2022
 */
@Module
interface ValueMapperModule {

    @Binds
    fun provideValueDomainToUiMapper(mapper: BaseValueDomainToUiMapper): ValueDomainToUiMapper

    @Binds
    fun provideBaseListValueDataToDomainMapper(mapper: BaseListValueDataToDomainMapper): ListValueDataToDomainMapper

    @Binds
    fun provideValueCloudMapper(mapper: ListValueCloudMapper.Base): ListValueCloudMapper

    @Binds
    fun provideToValueMapper(mapper: ToValueDataMapper.Base): ToValueDataMapper

    @Binds
    fun provideValueDataToDomainMapper(mapper: BaseValueDataToDomainMapper): ValueDataToDomainMapper

    @Binds
    fun provideListValueDomainToUiMapper(mapper: BaseListValueDomainToUiMapper): ListValueDomainToUiMapper

    @Binds
    fun provideValueLocalMapper(mapper: ListValueLocalMapper.Base): ListValueLocalMapper

    @Binds
    fun provideToDbMapper(mapper: ToValueDbMapper.Base): ToValueDbMapper

}