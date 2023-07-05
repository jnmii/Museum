package com.example.museum.model

import com.google.gson.annotations.SerializedName

data class TagModel(
    @SerializedName("term")
    val term: String?,
    @SerializedName("AAT_URL")
    val aatUrl: String?,
    @SerializedName("Wikidata_URL")
    val wikidataUrl: String?
)
