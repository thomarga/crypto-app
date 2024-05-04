package com.example.composefirst.domain.repository

import com.example.composefirst.domain.model.CoinsDataModel
import com.example.composefirst.domain.model.CoinsDetailDataModel

interface CoinRepository {
    suspend fun getCoins(): List<CoinsDataModel>

    suspend fun getCoinDetail(coinId: String): CoinsDetailDataModel
}