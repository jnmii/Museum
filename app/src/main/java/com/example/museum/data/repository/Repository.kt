package com.example.museum.data.repository

import com.example.museum.data.model.ArtModel
import retrofit2.http.Path

interface Repository {
   suspend fun getArtById(@Path("id") id: String): ArtModel

   suspend fun getAllArt(): List<ArtModel>
}