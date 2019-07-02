package com.example.demoproject3.data.api.response

import com.google.gson.annotations.SerializedName

data class DogCeoResponse<T>(
    @SerializedName(DogCeoJsonKeys.MESSAGE) val message: T,
    @SerializedName(DogCeoJsonKeys.STATUS) val status: String
)
