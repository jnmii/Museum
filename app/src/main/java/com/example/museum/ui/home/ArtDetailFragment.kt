package com.example.museum.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.museum.R
import com.example.museum.databinding.FragmentDetailArtBinding
import com.example.museum.remote.ApiCall
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class ArtDetailFragment : Fragment() {
    @Inject
    lateinit var apiCall: ApiCall
    lateinit var binding: FragmentDetailArtBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailArtBinding.inflate(inflater, container, false)
        val currentId = arguments?.getString("id_art") ?: ""
        getArtById(currentId)


        return binding.root
    }

    private fun getArtById(currentId: String) {
        CoroutineScope(Dispatchers.Main).launch {
            binding.idProgressBar.visibility = View.VISIBLE

            try {
                val art = apiCall.getArtById(currentId).get(0)
                binding.apply {
                    tvName.text = getString(R.string.art_name, art.objectName)
                    tvDepartment.text = getString(R.string.art_department, art.department)
                    val constituentName = art.constituents
                    tvConstituent.text = getString(R.string.art_constituent, constituentName)
                    tvRepository.text = getString(R.string.art_repository, art.repository)
                    tvCountry.text = getString(R.string.art_country, art.country)
                    tvMedium.text = getString(R.string.art_medium, art.medium)
                    tvCreationDate.text = getString(R.string.art_creation_date, art.objectDate)

                    Glide.with(requireContext())
                        .load(art.primaryImage)
                        .placeholder(R.drawable.artsy)
                        .into(ivArt)

                    idProgressBar.visibility = View.GONE
                }
            } catch (e: Exception) {
                // Handle the exception
                e.printStackTrace()
                // You can show an error message or perform any other error handling here
            } finally {
                binding.idProgressBar.visibility = View.GONE
            }
        }
    }
}

