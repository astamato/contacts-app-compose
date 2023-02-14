package com.example.latestcomposeseed.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.latestcomposeseed.data.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class ContactListViewModel @Inject constructor(private val repository: ContactsRepository) :
    ViewModel() {

//    private val _uiState = MutableStateFlow(listOf<Contact>())
    val uiState: StateFlow<List<Contact>> = repository.getAll().map {
        it.results
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = listOf()
    )
}

//    private val _contacts = MutableStateFlow<List<Contact>>(emptyList())
//    val contacts = _contacts.asStateFlow()
//
//    init {
//        _contacts.value = listOf(Contact("Ale"), Contact("Nico"))
//    }
