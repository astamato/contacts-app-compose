package com.example.latestcomposeseed.data

import com.example.latestcomposeseed.di.Dispatcher
import com.example.latestcomposeseed.di.Dispatchers
import com.example.latestcomposeseed.list.ContactResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ContactsRepositoryImpl @Inject constructor(
    private val contactRemoteDataSource: ContactRemoteDataSource,
    @Dispatcher(Dispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : ContactsRepository {

    override fun getAll(): Flow<ContactResponse> =
        flow { emit(contactRemoteDataSource.getAll()) }.flowOn(ioDispatcher)

}
