package com.example.latestcomposeseed.data

import com.example.latestcomposeseed.list.ContactResponse
import javax.inject.Inject

class ContactRetrofitDataSource @Inject constructor(private val service: ContactsRetrofitAPI) :
    ContactRemoteDataSource {

    override suspend fun getAll(): ContactResponse = service.getContacts()

}
