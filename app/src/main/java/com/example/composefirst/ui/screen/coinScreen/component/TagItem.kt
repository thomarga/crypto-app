package com.example.composefirst.ui.screen.coinScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TagItem(tag: String) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .border(width = 2.dp, color = Color.Green, shape = RoundedCornerShape(12.dp)),
        content = {
            Text(text = tag, color = Color.Green, modifier = Modifier.padding(6.dp))
        }
    )
}