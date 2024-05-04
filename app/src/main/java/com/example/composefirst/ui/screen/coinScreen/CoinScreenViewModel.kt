package com.example.composefirst.ui.screen.coinScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composefirst.common.Resource
import com.example.composefirst.domain.model.CoinsDataModel
import com.example.composefirst.domain.model.CoinsDetailDataModel
import com.example.composefirst.domain.use_case.GetCoinDetailUseCase
import com.example.composefirst.ui.screen.navArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCoinDetailUseCase: GetCoinDetailUseCase
) : ViewModel() {
    private val argument: CoinsDataModel = savedStateHandle.navArgs()
    var coinDetail: CoinsDetailDataModel? = null
    val isLoading = mutableStateOf(false)
    val error = mutableStateOf("")

    init {
        Log.e(argument.id, "test data id")
        argument.id?.let { getCoinDetail(it) }
    }

    private fun getCoinDetail(coinId: String) {
        getCoinDetailUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Error ->
                    error.value = result.message ?: ""

                is Resource.Loading -> isLoading.value = true
                is Resource.Success -> {
                    coinDetail = result.data
                    isLoading.value = false
                }
            }
        }.launchIn(viewModelScope)
    }
}