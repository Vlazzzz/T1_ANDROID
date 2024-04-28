package com.example.tema1_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tema1_android.Models.AfricanAnimal
import com.example.tema1_android.Models.AnimalModel
import com.example.tema1_android.Models.AntarcticAnimal
import com.example.tema1_android.Models.AsianAnimal
import com.example.tema1_android.Models.AustralianAnimal
import com.example.tema1_android.Models.EuropeanAnimal
import com.example.tema1_android.Models.NorthAmericanAnimal
import com.example.tema1_android.Models.SouthAmericanAnimal
import com.example.tema1_android.adapters.AnimalsAdapter

class AnimalListFragment : Fragment()
{
    private val animalList = arrayListOf<AnimalModel>(
        AfricanAnimal("Lion", "Africa"),
        AfricanAnimal("Elephant", "Africa"),
        AfricanAnimal("Giraffe", "Africa"),
        AfricanAnimal("Zebra", "Africa"),
        AfricanAnimal("Hippopotamus", "Africa"),
        AfricanAnimal("Gorilla", "Africa"),
        AfricanAnimal("Crocodile", "Africa"),
        AfricanAnimal("Hyena", "Africa"),
        AfricanAnimal("Rhino", "Africa"),
        AfricanAnimal("Leopard", "Africa"),
        EuropeanAnimal("Bear", "Europe"),
        EuropeanAnimal("Wolf", "Europe"),
        EuropeanAnimal("Fox", "Europe"),
        EuropeanAnimal("Deer", "Europe"),
        EuropeanAnimal("Rabbit", "Europe"),
        EuropeanAnimal("Boar", "Europe"),
        EuropeanAnimal("Moose", "Europe"),
        EuropeanAnimal("Hedgehog", "Europe"),
        EuropeanAnimal("Squirrel", "Europe"),
        EuropeanAnimal("Badger", "Europe"),
        AntarcticAnimal("Penguin", "Antarctica"),
        AntarcticAnimal("Seal", "Antarctica"),
        AntarcticAnimal("Whale", "Antarctica"),
        AntarcticAnimal("Albatross", "Antarctica"),
        AntarcticAnimal("Krill", "Antarctica"),
        AntarcticAnimal("Orca", "Antarctica"),
        AntarcticAnimal("Walrus", "Antarctica"),
        AntarcticAnimal("Polar Bear", "Antarctica"),
        AntarcticAnimal("Arctic Fox", "Antarctica"),
        AntarcticAnimal("Snow Petrel", "Antarctica"),
        AsianAnimal("Tiger", "Asia"),
        AsianAnimal("Panda", "Asia"),
        AsianAnimal("Monkey", "Asia"),
        AsianAnimal("Elephant", "Asia"),
        AsianAnimal("Snake", "Asia"),
        AsianAnimal("Toucan", "Asia"),
        AsianAnimal("Peacock", "Asia"),
        AsianAnimal("Parrot", "Asia"),
        AsianAnimal("Cobra", "Asia"),
        AsianAnimal("Lemur", "Asia"),
        AustralianAnimal("Kangaroo", "Australia"),
        AustralianAnimal("Koala", "Australia"),
        AustralianAnimal("Platypus", "Australia"),
        AustralianAnimal("Emu", "Australia"),
        AustralianAnimal("Dingo", "Australia"),
        AustralianAnimal("Cassowary", "Australia"),
        AustralianAnimal("Wombat", "Australia"),
        AustralianAnimal("Wallaby", "Australia"),
        AustralianAnimal("Quokka", "Australia"),
        AustralianAnimal("Tasmanian Devil", "Australia"),
        NorthAmericanAnimal("Bison", "North America"),
        NorthAmericanAnimal("Grizzly Bear", "North America"),
        NorthAmericanAnimal("Raccoon", "North America"),
        NorthAmericanAnimal("Beaver", "North America"),
        NorthAmericanAnimal("Moose", "North America"),
        NorthAmericanAnimal("Bald Eagle", "North America"),
        NorthAmericanAnimal("Coyote", "North America"),
        NorthAmericanAnimal("Mountain Lion", "North America"),
        NorthAmericanAnimal("Opossum", "North America"),
        NorthAmericanAnimal("Skunk", "North America"),
        SouthAmericanAnimal("Jaguar", "South America"),
        SouthAmericanAnimal("Anaconda", "South America"),
        SouthAmericanAnimal("Sloth", "South America"),
        SouthAmericanAnimal("Tapir", "South America"),
        SouthAmericanAnimal("Macaw", "South America"),
        SouthAmericanAnimal("Capuchin Monkey", "South America"),
        SouthAmericanAnimal("Anteater", "South America"),
        SouthAmericanAnimal("Piranha", "South America"),
        SouthAmericanAnimal("Toucan", "South America"),
        SouthAmericanAnimal("Capybara", "South America")
    )

    private val adapter = AnimalsAdapter(animalList, ::goToBigCardFragment)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ) = inflater.inflate(R.layout.fragment_animal_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupItemList()
    }

    private fun setupItemList() {
        animalList.shuffle()
        view?.findViewById<RecyclerView>(R.id.rv_animal_list)?.apply {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = this@AnimalListFragment.adapter
        }
    }

    private fun goToBigCardFragment(animalName: String, continentName: String) {
        val action = AnimalListFragmentDirections.actionAnimalListFragmentToFragmentBigCard(animalName, continentName)
        findNavController().navigate(action)
    }
}