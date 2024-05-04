package com.example.composefirst.data.remote

import com.example.composefirst.domain.model.CoinsDataModel
import com.example.composefirst.domain.model.CoinsDetailDataModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinsDataModel>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinsDetailDataModel
}