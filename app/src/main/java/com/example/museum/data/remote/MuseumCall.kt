package com.example.museum.data.remote

import com.example.museum.data.model.ArtModel
import retrofit2.http.GET
import retrofit2.http.Path

interface MuseumCall {
    @GET(ApiDetails.End_Point_All_Art)
    suspend fun getAllArt(): List<ArtModel>

    @GET(ApiDetails.End_Point_Art_By_Id)
    suspend fun getArtById(@Path("id") id: String): ArtModel
}