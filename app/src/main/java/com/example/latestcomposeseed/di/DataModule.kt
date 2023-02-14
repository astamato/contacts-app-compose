package com.example.latestcomposeseed.di

import com.example.latestcomposeseed.data.ContactRemoteDataSource
import com.example.latestcomposeseed.data.ContactRetrofitDataSource
import com.example.latestcomposeseed.data.ContactsRepository
import com.example.latestcomposeseed.data.ContactsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun contactRetrofitDataSource(impl: ContactRetrofitDataSource): ContactRemoteDataSource

    @Binds
    abstract fun contactsRepository(impl: ContactsRepositoryImpl): ContactsRepository
}
