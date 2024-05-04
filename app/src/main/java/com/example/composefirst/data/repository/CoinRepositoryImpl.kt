package com.example.composefirst.data.repository

import com.example.composefirst.data.remote.CoinPaprikaApi
import com.example.composefirst.domain.model.CoinsDataModel
import com.example.composefirst.domain.model.CoinsDetailDataModel
import com.example.composefirst.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinsDataModel> {
        return api.getCoins()
    }

    override suspend fun getCoinDetail(coinId: String): CoinsDetailDataModel {
        return api.getCoinById(coinId)
    }

}