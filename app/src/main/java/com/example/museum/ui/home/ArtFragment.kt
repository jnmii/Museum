package com.example.museum.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.museum.databinding.FragmentArtBinding
import com.example.museum.data.model.ArtModel
import com.example.museum.data.remote.MuseumCall
import com.example.museum.data.repository.Repository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ArtFragment : Fragment() {


    @Inject
    lateinit var repository: Repository
    private var _binding: FragmentArtBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentArtBinding.inflate(inflater, container, false)
        loadData()

        return binding.root
    }


    private fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {

        //    binding.idProgressBar.visibility = View.VISIBLE

       //     val viewModel by viewModels<ArtViewModel>()

        //    try {
                var artObject = repository.getArtById("112")
            val art: MutableList<ArtModel> = mutableListOf()
            art.add(artObject)
             //  val art = apiCall.getAllArt()

                binding.rvCategory.apply { layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    adapter = ArtAdapter(art)

                }
         //   }catch (e: Exception){

           // }finally {
               // binding.idProgressBar.visibility = View.GONE
           // }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}