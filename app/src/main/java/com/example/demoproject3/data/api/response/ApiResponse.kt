package com.example.demoproject3.data.api.response

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName(JsonKeys.MESSAGE) val message: T,
    @SerializedName(JsonKeys.STATUS) val status: String
)
