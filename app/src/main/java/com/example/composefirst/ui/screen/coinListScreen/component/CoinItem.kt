package com.example.composefirst.ui.screen.coinListScreen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composefirst.domain.model.CoinsDataModel

@Composable
fun CoinItem(
    coin: CoinsDataModel,
    coinClickItem: (CoinsDataModel) -> Unit,
) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .fillMaxSize()

            .clickable { coinClickItem(coin) }) {

        Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})", color = Color.White)
        Text(
            text = if (coin.isActive) "active" else "inactive",

            color = if (coin.isActive) Color.Green else Color.Red,
        )

    }
}