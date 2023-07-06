package com.example.museum.data.repository

import com.example.museum.data.model.ArtModel
import com.example.museum.data.remote.MuseumCall
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val museumCall: MuseumCall
): Repository {

    override suspend fun getArtById(id: String): ArtModel {
        return museumCall.getArtById(id)
    }

    override suspend fun getAllArt(): List<ArtModel> {
        return museumCall.getAllArt()
    }
}