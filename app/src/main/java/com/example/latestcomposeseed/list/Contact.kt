package com.example.latestcomposeseed.list

data class Contact(val name: Name)

data class Name(val first: String, val last:String)

data class ContactResponse(
    val info: Info? = null,
    val results: List<Contact> = listOf()
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
