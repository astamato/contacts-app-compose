package com.example.latestcomposeseed.data

import com.example.latestcomposeseed.list.ContactResponse
import retrofit2.http.GET

interface ContactsRetrofitAPI {

    @GET("api/?seed=foorbar&results=50")
    suspend fun getContacts(): ContactResponse

    companion object {
        const val SEED = "foobar"
    }

}
