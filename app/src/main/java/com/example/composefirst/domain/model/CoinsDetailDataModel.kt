package com.example.composefirst.domain.model

import com.google.gson.annotations.SerializedName

data class CoinsDetailDataModel(
    @SerializedName(value = "id")
    val coinId: String,

    @SerializedName(value = "name")
    val name: String,

    @SerializedName(value = "description")
    val description: String,

    @SerializedName(value = "symbol")
    val symbol: String,

    @SerializedName(value = "rank")
    val rank: Int,

    @SerializedName(value = "is_active")
    val isActive: Boolean,

    @SerializedName(value = "tags")
    val tags: List<Tag>,

    @SerializedName(value = "logo")
    val logo: String,
)

data class Tag(
    @SerializedName(value = "name")
    val name: String
)