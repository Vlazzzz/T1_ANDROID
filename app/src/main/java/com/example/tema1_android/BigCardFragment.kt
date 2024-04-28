package com.example.tema1_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs

class BigCardFragment : Fragment() {
    private var animalName: String? = null
    private var animalContinent: String? = null

    private val arguments: BigCardFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_big_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animalName = arguments.animalName
        animalContinent = arguments.continentName

        view?.findViewById<TextView>(R.id.tv_animal_big_card)?.text = animalName
        view?.findViewById<TextView>(R.id.tv_continent_big_card)?.text = animalContinent

        when(animalContinent) {
            "Antarctica" -> {
                // Set the background color to blue
                view.setBackgroundColor(resources.getColor(R.color.cyan))
            }
            "Asia" -> {
                // Set the background color to red
                view.setBackgroundColor(resources.getColor(R.color.red))
            }
            "Europe" -> {
                // Set the background color to purple
                view.setBackgroundColor(resources.getColor(R.color.green))
            }
            "Australia" -> {
                // Set the background color to green
                view.setBackgroundColor(resources.getColor(R.color.purple))
            }
            "Africa" -> {
                // Set the background color to brown
                view.setBackgroundColor(resources.getColor(R.color.yellow))
            }
            "North America" -> {
                // Set the background color to yellow
                view.setBackgroundColor(resources.getColor(R.color.brown))
            }
            "South America" -> {
                // Set the background color to orange
                view.setBackgroundColor(resources.getColor(R.color.orange))
            }
        }
    }
}