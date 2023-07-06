package com.example.museum

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.museum.data.model.ArtModel
import com.example.museum.data.model.ConstituentModel
import com.example.museum.data.remote.MuseumCall
import com.example.museum.data.repository.Repository
import com.example.museum.data.repository.RepositoryImpl
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RepositoryTest {
    //allow me to use the threads
    private val testDistpacther = StandardTestDispatcher()


    //allow to run tests with priority
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var repository: Repository

    @Mock
    lateinit var museumCall: MuseumCall

    @Before
    fun startUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDistpacther)// assume this as the main thread
        repository = RepositoryImpl(museumCall)
    }

    @After
    fun clear() {
        Mockito.clearAllCaches()
    }


    @Test
    fun getArtById_Succes() = runTest {
        val artPiece = ArtModel(
            objectId = 123,
            isHighlight = true,
            accessionNumber = "AC1234",
            accessionYear = "2022",
            isPublicDomain = false,
            primaryImage = "https://example.com/image.jpg",
            primaryImageSmall = "https://example.com/image_small.jpg",
            additionalImages = listOf("https://example.com/image2.jpg", "https://example.com/image3.jpg"),
            constituents = null,
            department = "Fine Arts",
            objectName = "Painting",
            title = "Untitled",
            culture = "Western",
            period = "Contemporary",
            dynasty = null,
            reign = null,
            portfolio = null,
            artistRole = "Artist",
            artistPrefix = null,
            artistDisplayName = "John Doe",
            artistDisplayBio = "An artist who creates unique works of art.",
            artistSuffix = null,
            artistAlphaSort = "Doe, John",
            artistNationality = "American",
            artistBeginDate = "1980",
            artistEndDate = null,
            artistGender = "Male",
            artistWikidataUrl = "https://example.com/wikidata/789",
            artistUlanUrl = null,
            objectDate = "2021",
            objectBeginDate = 2021,
            objectEndDate = null,
            medium = "Oil on canvas",
            dimensions = "50x50 cm",
            measurements = null,
            creditLine = "Gift of John Smith",
            geographyType = "City",
            city = "New York",
            state = "New York",
            county = null,
            country = "United States",
            region = null,
            subregion = null,
            locale = null,
            locus = null,
            excavation = null,
            river = null,
            classification = "Painting",
            rightsAndReproduction = null,
            linkResource = "https://example.com/artwork/123",
            metadataDate = "2022-01-01",
            repository = "Museum of Modern Art",
            objectURL = "https://example.com/artwork/123",
            tags = null,
            objectWikidataUrl = "https://example.com/wikidata/012",
            isTimelineWork = false,
            galleryNumber = null
        )
        // defining the API response in MOCK
        Mockito.`when`(museumCall.getArtById("123")).thenReturn(artPiece)

        val result = repository.getArtById("123")

        assertEquals(result.isHighlight, artPiece.isHighlight)
    }
}






