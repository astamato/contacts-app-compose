package com.example.latestcomposeseed.data

import com.example.latestcomposeseed.list.ContactResponse

interface ContactRemoteDataSource {

    suspend fun getAll(): ContactResponse

}
