package com.example.museum.model

import com.google.gson.annotations.SerializedName

data class ConstituentModel(
    @SerializedName("constituentID")
    val constituentID: Int?,
    @SerializedName("role")
    val role: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("constituentULAN_URL")
    val constituentULAN_URL: String?,
    @SerializedName("constituentWikidata_URL")
    val constituentWikidata_URL: String?,
    @SerializedName("gender")
    val gender: String?
)