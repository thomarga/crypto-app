package com.example.composefirst.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composefirst.ui.screen.NavGraphs
import com.example.composefirst.ui.screen.coinListScreen.CoinListScreenViewModel
import com.example.composefirst.ui.screen.coinScreen.CoinScreenViewModel
import com.example.composefirst.ui.screen.destinations.CoinListScreenDestination
import com.example.composefirst.ui.screen.destinations.CoinScreenDestination
import com.example.composefirst.ui.theme.ComposefirstTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposefirstTheme {
                DestinationsNavHost(
                    dependenciesContainerBuilder = {
                        dependency(CoinListScreenDestination) { hiltViewModel<CoinListScreenViewModel>() }
                        dependency(CoinScreenDestination) { hiltViewModel<CoinScreenViewModel>() }
                    },
                    navGraph = NavGraphs.root
                )
            }
        }
    }
}