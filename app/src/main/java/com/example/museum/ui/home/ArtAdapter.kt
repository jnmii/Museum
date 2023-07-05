package com.example.museum.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.museum.R
import com.example.museum.databinding.ItemArtBinding
import com.example.museum.model.ArtModel



class ArtAdapter(val art: List<ArtModel>): RecyclerView.Adapter<ArtAdapter.ViewHolder>() {

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {


        val binding = ItemArtBinding.bind(view)
        fun updateUI(art: ArtModel) {
            binding.apply {
                tvName.text = art.objectName

                Glide.with(view)
                    .load(art.primaryImage)
                    .placeholder(R.drawable.art)

                    .into(ivArt)

                cvArt.setOnClickListener {
                    val navController = Navigation.findNavController(view)
                    navController.navigate(R.id.action_navigation_home_to_navigation_art_detail,
                        bundleOf(
                            "id_art" to art.objectId
                        )
                    )

                }
            }
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_art,parent,false)

        )
    }

    override fun getItemCount(): Int {
        return art.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        art[position]?.let { holder.updateUI(it) }

    }


}