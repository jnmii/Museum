package com.example.museum.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.museum.databinding.FragmentHomeBinding
import com.example.museum.remote.ApiCall
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class ArtFragment : Fragment() {


    @Inject
    lateinit var apiCall: ApiCall
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        loadData()

        return binding.root
    }


    private fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {

            binding.idProgressBar.visibility = View.VISIBLE

            try {

                var result = apiCall.getAllArt()
                apiCall.getAllArt()

                binding.rvCategory.apply {
                    layoutManager =
                        StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    adapter = ArtAdapter(result)
                }
            }catch (e: Exception){

            }finally {
                binding.idProgressBar.visibility = View.GONE
            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}