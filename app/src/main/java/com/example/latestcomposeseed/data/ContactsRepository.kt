package com.example.latestcomposeseed.data

import com.example.latestcomposeseed.list.ContactResponse
import kotlinx.coroutines.flow.Flow

interface ContactsRepository {

    fun getAll(): Flow<ContactResponse>

}