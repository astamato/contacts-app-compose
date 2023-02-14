package com.example.latestcomposeseed.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.latestcomposeseed.ui.theme.LatestComposeSeedTheme

@Composable
fun ContactList(
    modifier: Modifier = Modifier, contactDetailViewModel: ContactListViewModel = hiltViewModel()
) {

    val contacts: List<Contact> by contactDetailViewModel.uiState.collectAsStateWithLifecycle()
    ContactList(modifier = modifier, contacts =  contacts)

}

@Composable
fun ContactList(
    modifier: Modifier = Modifier, contacts: List<Contact>
) {
    LazyColumn(modifier = modifier) {
        items(contacts) {
            ContactListItem(contact = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LatestComposeSeedTheme {
//        ContactList()
    }
}