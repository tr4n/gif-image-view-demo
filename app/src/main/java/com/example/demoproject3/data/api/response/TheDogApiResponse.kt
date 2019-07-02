package com.example.demoproject3.data.api.response

import com.google.gson.annotations.SerializedName

data class TheDogApiResponse(
    @SerializedName(TheDogApiJsonKeys.WEIGHT) val weight: Weight,
    @SerializedName(TheDogApiJsonKeys.HEIGHT) val height: Height,
    @SerializedName(TheDogApiJsonKeys.ID) val id: Int,
    @SerializedName(TheDogApiJsonKeys.NAME) val name: String,
    @SerializedName(TheDogApiJsonKeys.BREED_FOR) val breedFor: String,
    @SerializedName(TheDogApiJsonKeys.BREED_GROUP) val breedGroup: String,
    @SerializedName(TheDogApiJsonKeys.LIFE_SPAN) val lifeSpan: String,
    @SerializedName(TheDogApiJsonKeys.TEMPERAMENT) val temperament: String,
    @SerializedName(TheDogApiJsonKeys.DESCRIPTION) val description: String?,
    @SerializedName(TheDogApiJsonKeys.HISTORY) val history: String?,
    @SerializedName(TheDogApiJsonKeys.ALT_NAMES) val altNames: String?,
    @SerializedName(TheDogApiJsonKeys.ORIGIN) val origin: String?
) {
    data class Weight(
        @SerializedName(TheDogApiJsonKeys.IMPERIAL) val imperial: String,
        @SerializedName(TheDogApiJsonKeys.METRIC) val metric: String
    )

    data class Height(
        @SerializedName(TheDogApiJsonKeys.IMPERIAL) val imperial: String,
        @SerializedName(TheDogApiJsonKeys.METRIC) val metric: String
    )
}
