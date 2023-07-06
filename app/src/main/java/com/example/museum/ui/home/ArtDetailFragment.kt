package com.example.museum.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.museum.R
import com.example.museum.databinding.FragmentDetailArtBinding
import com.example.museum.data.model.ArtModel
import com.example.museum.data.repository.Repository
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class ArtDetailFragment : Fragment() {
    @Inject
    lateinit var repository: Repository
    lateinit var binding: FragmentDetailArtBinding
    lateinit var art: ArtModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailArtBinding.inflate(inflater, container, false)
        // val currentId = arguments?.getString("id_art") ?: ""
        art = Gson().fromJson(arguments?.getString("item"), ArtModel::class.java)
        loadArtData()

        return binding.root
    }

    private fun loadArtData() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.idProgressBar.visibility = View.VISIBLE

            try {
                binding.apply {
                    tvName.text = getString(R.string.art_name, art.objectName)
                    tvDepartment.text = getString(R.string.art_department, art.department)


                    val constituentName = art.constituents?.get(0)?.name

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

