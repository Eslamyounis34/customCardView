package com.example.halfandhalfcardview

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.halfandhalfcardview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var planetList = mutableListOf<Planet>()
    lateinit var planetAdapter: PlanetAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPlanetList()


    }

    private fun initPlanetList() {
        val bitmapOne = BitmapFactory.decodeResource(resources, R.drawable.planet_one)
        val bitmapTwo = BitmapFactory.decodeResource(resources, R.drawable.planet_two)
        val bitmapThree = BitmapFactory.decodeResource(resources, R.drawable.planet_three)
        val bitmapFour = BitmapFactory.decodeResource(resources, R.drawable.planet_four)
        val bitmapFive = BitmapFactory.decodeResource(resources, R.drawable.planet_five)

        var planetOne = Planet("Earth", "150", "10", "12750", bitmapOne)
        var planetTwo = Planet("Mars", "278", "27", "6750", bitmapTwo)
        var planetThree = Planet("Jupiter", "320", "54", "28750", bitmapThree)
        var planetFour = Planet("Uranus", "430", "66", "39980", bitmapFour)
        var planetFive = Planet("Neptune", "650", "80", "65440", bitmapFive)

        planetList.add(planetOne)
        planetList.add(planetTwo)
        planetList.add(planetThree)
        planetList.add(planetFour)
        planetList.add(planetFive)
        planetList.add(planetOne)
        planetList.add(planetThree)
        planetList.add(planetTwo)
        planetList.add(planetFour)
        planetList.add(planetFive)



        planetAdapter= PlanetAdapter(applicationContext)
        binding.planetsRecycler.apply {
            adapter=planetAdapter
            planetAdapter.setListOfPlanets(planetList as ArrayList<Planet>)
        }
    }
}