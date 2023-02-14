package com.example.latestcomposeseed.list

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.latestcomposeseed.ui.theme.LatestComposeSeedTheme

@Composable
fun ContactListItem(modifier: Modifier = Modifier, contact: Contact) {
    Row(modifier = modifier) {
        Text(contact.name.first)
    }
}

//@Preview
//@Composable
//fun ContactListItemPreview() {
//    LatestComposeSeedTheme {
//        ContactListItem(contact = Contact("ale"))
//    }
//}