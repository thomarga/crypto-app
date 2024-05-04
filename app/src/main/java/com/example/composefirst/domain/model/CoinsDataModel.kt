package com.example.composefirst.domain.model

import com.google.gson.annotations.SerializedName


data class CoinsDataModel(
    @SerializedName(value = "id")
    var id: String?,

    @SerializedName(value = "name")
    var name: String?,

    @SerializedName(value = "symbol")
    var symbol: String?,

    @SerializedName(value = "rank")
    var rank: Int? = null,

    @SerializedName(value = "is_active")
    var isActive: Boolean,

    @SerializedName(value = "type")
    var type: String?,

    )