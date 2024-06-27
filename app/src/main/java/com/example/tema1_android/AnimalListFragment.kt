package com.example.tema1_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
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
import com.example.tema1_android.data.models.AnimalDbModel
import com.example.tema1_android.data.repositories.AnimalRepository
import com.example.tema1_android.data.tasks.GetAllAnimalsTask

class AnimalListFragment : Fragment()
{
    private val animalList = ArrayList<AnimalModel>()

    private val adapter = AnimalsAdapter(animalList, ::goToBigCardFragment, ::deleteItem)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AnimalRepository.getAllAnimals { animals ->
                animalList.clear()
                for(animal in animals) {
                    when(animal.continent) {
                        "Africa" -> animalList.add(AfricanAnimal(animal.name, animal.continent))
                        "Europe" -> animalList.add(EuropeanAnimal(animal.name, animal.continent))
                        "Antarctica" -> animalList.add(AntarcticAnimal(animal.name, animal.continent))
                        "Asia" -> animalList.add(AsianAnimal(animal.name, animal.continent))
                        "Australia" -> animalList.add(AustralianAnimal(animal.name, animal.continent))
                        "North America" -> animalList.add(NorthAmericanAnimal(animal.name, animal.continent))
                        "South America" -> animalList.add(SouthAmericanAnimal(animal.name, animal.continent))
                    }
                }
                adapter.notifyDataSetChanged()
            }
    }

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

    private fun onListChanged() {
        AnimalRepository.getAllAnimals { animals ->
            animalList.clear()
            for(animal in animals) {
                when(animal.continent) {
                    "Africa" -> animalList.add(AfricanAnimal(animal.name, animal.continent))
                    "Europe" -> animalList.add(EuropeanAnimal(animal.name, animal.continent))
                    "Antarctica" -> animalList.add(AntarcticAnimal(animal.name, animal.continent))
                    "Asia" -> animalList.add(AsianAnimal(animal.name, animal.continent))
                    "Australia" -> animalList.add(AustralianAnimal(animal.name, animal.continent))
                    "North America" -> animalList.add(NorthAmericanAnimal(animal.name, animal.continent))
                    "South America" -> animalList.add(SouthAmericanAnimal(animal.name, animal.continent))
                }
            }
            adapter.notifyDataSetChanged()
        }
    }

    private fun deleteItem(animalItem: AnimalModel) {
        var animal: AnimalDbModel? = null
        AnimalRepository.getAllAnimals { animals ->
            for (a in animals) {
                if (a.name == animalItem.name && a.continent == animalItem.continent) {
                    animal = a
                    break
                }
            }
            if(animal != null)
                AnimalRepository.deleteAnimal(animal!!) {
                    Toast.makeText(context, "Animal deleted", Toast.LENGTH_SHORT).show()
                    onListChanged()
                }
        }
    }
}