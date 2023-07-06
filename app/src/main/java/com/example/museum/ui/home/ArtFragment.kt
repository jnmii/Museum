package com.example.museum.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.museum.data.model.ArtModel
import com.example.museum.databinding.FragmentArtBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtFragment : Fragment() {

    lateinit var _binding: FragmentArtBinding

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentArtBinding.inflate(inflater, container, false)

        val viewModel :ArtViewModel by viewModels()

        if (!viewModel.isLoaded) {
            viewModel.loadData()
        }
        viewModel.artLiveData.observe(viewLifecycleOwner) {
             loadData(it)
        }


        return _binding.root
    }


    private fun loadData(result: MutableList<ArtModel>) {
        _binding.apply {
            //    binding.idProgressBar.visibility = View.VISIBLE
            //     val viewModel by viewModels<ArtViewModel>()
            //    try {

            //  val art = apiCall.getAllArt()
            _binding.rvCategory.apply {
                layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                adapter = ArtAdapter(result)
            }
            //   }catch (e: Exception){
            // }finally {
            // binding.idProgressBar.visibility = View.GONE
            // }}

        }
    }
}


