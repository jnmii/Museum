package com.example.museum.remote

import com.example.museum.model.ArtModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCall {
    @GET(ApiDetails.End_Point_All_Art)
    suspend fun getAllArt(): List<ArtModel>

    @GET(ApiDetails.End_Point_Art_By_Id)
    suspend fun getArtById(@Path("id") id: String): List<ArtModel>
}