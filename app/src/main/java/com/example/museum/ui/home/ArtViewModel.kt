package com.example.museum.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.museum.data.model.ArtModel
import com.example.museum.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ArtViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    val artLiveData: MutableLiveData<MutableList<ArtModel>> by lazy{
        MutableLiveData<MutableList<ArtModel>>()
    }
    var isLoaded =false
    fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {
            val result = repository.getArtById("123")
            val art: MutableList<ArtModel> = mutableListOf()
            art.add(result)
            artLiveData.postValue(art)
//            artLiveData.value=result urgently replaces values
            isLoaded= true
        }


        }


    }