package com.example.composefirst.domain.use_case

import com.example.composefirst.common.Resource
import com.example.composefirst.domain.model.CoinsDetailDataModel
import com.example.composefirst.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repositoryImpl: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinsDetailDataModel>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repositoryImpl.getCoinDetail(coinId)
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}