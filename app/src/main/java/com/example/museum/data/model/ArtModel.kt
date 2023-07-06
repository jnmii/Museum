package com.example.museum.data.model

import com.google.gson.annotations.SerializedName

data class ArtModel (
    @SerializedName("objectID")
    val objectId: Int?,
    @SerializedName("isHighlight")
    val isHighlight: Boolean?,
    @SerializedName("accessionNumber")
    val accessionNumber: String?,
    @SerializedName("accessionYear")
    val accessionYear: String?,
    @SerializedName("isPublicDomain")
    val isPublicDomain: Boolean?,
    @SerializedName("primaryImage")
    val primaryImage: String?,
    @SerializedName("primaryImageSmall")
    val primaryImageSmall: String?,
    @SerializedName("additionalImages")
    val additionalImages: List<String?>?,
    @SerializedName("constituents")
    val constituents: List<ConstituentModel>?,
    @SerializedName("department")
    val department: String?,
    @SerializedName("objectName")
    val objectName: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("culture")
    val culture: String?,
    @SerializedName("period")
    val period: String?,
    @SerializedName("dynasty")
    val dynasty: String?,
    @SerializedName("reign")
    val reign: String?,
    @SerializedName("portfolio")
    val portfolio: String?,
    @SerializedName("artistRole")
    val artistRole: String?,
    @SerializedName("artistPrefix")
    val artistPrefix: String?,
    @SerializedName("artistDisplayName")
    val artistDisplayName: String?,
    @SerializedName("artistDisplayBio")
    val artistDisplayBio: String?,
    @SerializedName("artistSuffix")
    val artistSuffix: String?,
    @SerializedName("artistAlphaSort")
    val artistAlphaSort: String?,
    @SerializedName("artistNationality")
    val artistNationality: String?,
    @SerializedName("artistBeginDate")
    val artistBeginDate: String?,
    @SerializedName("artistEndDate")
    val artistEndDate: String?,
    @SerializedName("artistGender")
    val artistGender: String?,
    @SerializedName("artistWikidata_URL")
    val artistWikidataUrl: String?,
    @SerializedName("artistULAN_URL")
    val artistUlanUrl: String?,
    @SerializedName("objectDate")
    val objectDate: String?,
    @SerializedName("objectBeginDate")
    val objectBeginDate: Int?,
    @SerializedName("objectEndDate")
    val objectEndDate: Int?,
    @SerializedName("medium")
    val medium: String?,
    @SerializedName("dimensions")
    val dimensions: String?,
    @SerializedName("measurements")
    val measurements: Any?, // It was null in the example response, you can update it to the correct type
    @SerializedName("creditLine")
    val creditLine: String?,
    @SerializedName("geographyType")
    val geographyType: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("county")
    val county: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("subregion")
    val subregion: String?,
    @SerializedName("locale")
    val locale: String?,
    @SerializedName("locus")
    val locus: String?,
    @SerializedName("excavation")
    val excavation: String?,
    @SerializedName("river")
    val river: String?,
    @SerializedName("classification")
    val classification: String?,
    @SerializedName("rightsAndReproduction")
    val rightsAndReproduction: String?,
    @SerializedName("linkResource")
    val linkResource: String?,
    @SerializedName("metadataDate")
    val metadataDate: String?,
    @SerializedName("repository")
    val repository: String?,
    @SerializedName("objectURL")
    val objectURL: String?,
    @SerializedName("tags")
    val tags: List<TagModel>?, // It was null in the example response, you can update it to the correct type
    @SerializedName("objectWikidata_URL")
    val objectWikidataUrl: String?,
    @SerializedName("isTimelineWork")
    val isTimelineWork: Boolean?,
    @SerializedName("GalleryNumber")
    val galleryNumber: String?
)