package com.theolin.selectablecard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTest( text :String , selected: Boolean, onClick: () -> Unit){

    Card(
        onClick = { /* Do something */ },
        modifier =
        Modifier
            .size(width = 180.dp, height = 100.dp)
            .selectable(selected = selected, onClick = {  })
            .background(if (selected) Color.Black else Color.Red)
    ) {
        Box(Modifier.fillMaxSize()) {
            Text(text, Modifier.align(Alignment.Center))
        }
    }
}
