package com.example.latestcomposeseed

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.latestcomposeseed.list.ContactList

@Composable
fun ContactsApp(modifier: Modifier = Modifier, content: @Composable () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                    ) {

                    }
                },
            )
        },
        bottomBar = {
            BottomAppBar {

            }
        }
    ) { innerPadding ->
        content()
    }
}
