package com.example.composefirst.ui.screen.coinListScreen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefirst.common.Resource
import com.example.composefirst.domain.model.CoinsDataModel
import com.example.composefirst.domain.use_case.GetCoinsUseCase
import com.example.composefirst.ui.screen.destinations.CoinScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListScreenViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {

    val coins = mutableStateListOf<CoinsDataModel>()
    val isLoading = mutableStateOf(false)
    val error = mutableStateOf("")

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    coins.addAll(result.data ?: emptyList())
                    isLoading.value = false
                }

                is Resource.Error ->
                    error.value = result.message ?: ""

                is Resource.Loading -> isLoading.value = true
            }
        }.launchIn(viewModelScope)
    }

    fun toMenu(navigator: DestinationsNavigator, coinDataModel: CoinsDataModel) {
        navigator.navigate(CoinScreenDestination(navArgs = coinDataModel))
    }
}