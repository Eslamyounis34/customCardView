package com.example.halfandhalfcardview

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.halfandhalfcardview.databinding.PlanetItemBinding


class PlanetAdapter(var context: Context) : RecyclerView.Adapter<PlanetAdapter.ViewHolder>() {

    class ViewHolder(var binding: PlanetItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    var planetsList = ArrayList<Planet>()
    private lateinit var binding: PlanetItemBinding

    fun setListOfPlanets(listOfPlanets: ArrayList<Planet>) {
        this.planetsList = listOfPlanets
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding =
            PlanetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = planetsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem = planetsList[position]

        binding.apply {
            planetName.text = currentItem.name
            planetDistance.text = "Distansce from sun : " + currentItem.distance
            planetGravity.text = "Surface Gravity : " + currentItem.gravity
            planetDiameter.text = "Diameter : " + currentItem.diameter

            planetImage.load(currentItem.image)
            {
                crossfade(true)
                crossfade(800)
            }
        }


    }
}