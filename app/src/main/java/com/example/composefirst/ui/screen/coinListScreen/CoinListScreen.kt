package com.example.composefirst.ui.screen.coinListScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composefirst.ui.screen.coinListScreen.component.CoinItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RootNavGraph(true)
@Destination
@Composable
fun CoinListScreen(
    viewModel: CoinListScreenViewModel,
    navigator: DestinationsNavigator
) {
    Scaffold(
        modifier = Modifier.background(color = Color.Black)

    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black), content = {
            if (viewModel.isLoading.value) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            if (viewModel.error.value.isNotBlank()) {
                Text(
                    text = viewModel.error.value,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                items(viewModel.coins) { coin ->
                    CoinItem(coin = coin, coinClickItem = { viewModel.toMenu(navigator, coin) })
                }
            }

        })
    }
}




