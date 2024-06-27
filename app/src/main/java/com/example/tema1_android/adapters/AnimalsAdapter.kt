package com.example.tema1_android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tema1_android.Models.AfricanAnimal
import com.example.tema1_android.Models.AnimalContinent
import com.example.tema1_android.Models.AnimalModel
import com.example.tema1_android.Models.AntarcticAnimal
import com.example.tema1_android.Models.AsianAnimal
import com.example.tema1_android.Models.AustralianAnimal
import com.example.tema1_android.Models.EuropeanAnimal
import com.example.tema1_android.Models.NorthAmericanAnimal
import com.example.tema1_android.Models.SouthAmericanAnimal
import com.example.tema1_android.R

class AnimalsAdapter(
    private val animals: List<AnimalModel>,
    private val goToBigCard: (String, String) -> Unit,
    private val deleteItem: (AnimalModel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            AnimalContinent.EUROPE.key -> {
                val itemView = inflater.inflate(R.layout.europe_continent, parent, false)
                EuropeanAnimalViewHolder(itemView)
            }
            AnimalContinent.AFRICA.key -> {
                val itemView = inflater.inflate(R.layout.africa_continent, parent, false)
                AfricanAnimalViewHolder(itemView)
            }
            AnimalContinent.ASIA.key -> {
                val itemView = inflater.inflate(R.layout.asia_continent, parent, false)
                AsianAnimalViewHolder(itemView)
            }
            AnimalContinent.ANTARCTICA.key -> {
                val itemView = inflater.inflate(R.layout.antarctica_continent, parent, false)
                AntarcticAnimalViewHolder(itemView)
            }
            AnimalContinent.AUSTRALIA.key -> {
                val itemView = inflater.inflate(R.layout.australia_continent, parent, false)
                AustralianAnimalViewHolder(itemView)
            }
            AnimalContinent.NORTH_AMERICA.key -> {
                val itemView = inflater.inflate(R.layout.north_america_continent, parent, false)
                NorthAmericanAnimalViewHolder(itemView)
            }
            AnimalContinent.SOUTH_AMERICA.key -> {
                val itemView = inflater.inflate(R.layout.south_america_continent, parent, false)
                SouthAmericanAnimalViewHolder(itemView)
            }
            else -> {
                throw IllegalArgumentException("Invalid view type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Popularea datelor în ViewHolder
        val currentAnimal = animals[position]
        holder.itemView.setOnClickListener {
            // La clic pe element, apelează metoda goToBigCardFragment
            goToBigCard(currentAnimal.name, currentAnimal.continent)
        }
        when(holder)
        {
            is EuropeanAnimalViewHolder -> (currentAnimal as? EuropeanAnimal)?.let { holder.bind(it) }
            is AfricanAnimalViewHolder -> (currentAnimal as? AfricanAnimal)?.let { holder.bind(it) }
            is AsianAnimalViewHolder -> (currentAnimal as? AsianAnimal)?.let { holder.bind(it) }
            is AntarcticAnimalViewHolder -> (currentAnimal as? AntarcticAnimal)?.let { holder.bind(it) }
            is AustralianAnimalViewHolder -> (currentAnimal as? AustralianAnimal)?.let { holder.bind(it) }
            is NorthAmericanAnimalViewHolder -> (currentAnimal as? NorthAmericanAnimal)?.let { holder.bind(it) }
            is SouthAmericanAnimalViewHolder -> (currentAnimal as? SouthAmericanAnimal)?.let { holder.bind(it) }
        }
    }

    override fun getItemCount(): Int {
        // Returnarea numărului de elemente din lista de animale
        return animals.size
    }

    override fun getItemViewType(position: Int): Int {
        // Returnarea tipului de element din lista de animale
        return animals[position].type.key
    }

    // Clasa ViewHolder care va fi asociată fiecărui element din RecyclerView
    inner class EuropeanAnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val continentTextView: TextView
        val deleteBtn: ImageButton
        init {
            nameTextView = itemView.findViewById(R.id.tv_european_animal_card)
            continentTextView = itemView.findViewById(R.id.tv_european_continent_card)
            deleteBtn = itemView.findViewById(R.id.ib_delete_european_animal)
        }
        fun bind(animal: EuropeanAnimal) {
            nameTextView.text = animal.name
            continentTextView.text = animal.continent
            deleteBtn.setOnClickListener {
                deleteItem(animal)
            }
        }
    }

    inner class AfricanAnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val continentTextView: TextView
        val deleteBtn: ImageButton
        init {
            nameTextView = itemView.findViewById(R.id.tv_african_animal_card)
            continentTextView = itemView.findViewById(R.id.tv_african_continent_card)
            deleteBtn = itemView.findViewById(R.id.ib_delete_african_animal)
        }
        fun bind(animal: AfricanAnimal) {
            nameTextView.text = animal.name
            continentTextView.text = animal.continent
            deleteBtn.setOnClickListener {
                deleteItem(animal)
            }
        }
    }

    inner class AsianAnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val continentTextView: TextView
        val deleteBtn: ImageButton
        init {
            nameTextView = itemView.findViewById(R.id.tv_asian_animal_card)
            continentTextView = itemView.findViewById(R.id.tv_asian_continent_card)
            deleteBtn = itemView.findViewById(R.id.ib_delete_asian_animal)
        }
        fun bind(animal: AsianAnimal) {
            nameTextView.text = animal.name
            continentTextView.text = animal.continent
            deleteBtn.setOnClickListener {
                deleteItem(animal)
            }
        }
    }

    inner class AntarcticAnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val continentTextView: TextView
        val deleteBtn: ImageButton
        init {
            nameTextView = itemView.findViewById(R.id.tv_antarctic_animal_card)
            continentTextView = itemView.findViewById(R.id.tv_antarctic_continent_card)
            deleteBtn = itemView.findViewById(R.id.ib_delete_antarctic_animal)
        }
        fun bind(animal: AntarcticAnimal) {
            nameTextView.text = animal.name
            continentTextView.text = animal.continent
            deleteBtn.setOnClickListener {
                deleteItem(animal)
            }
        }
    }

    inner class AustralianAnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val continentTextView: TextView
        val deleteBtn: ImageButton
        init {
            nameTextView = itemView.findViewById(R.id.tv_australian_animal_card)
            continentTextView = itemView.findViewById(R.id.tv_australian_continent_card)
            deleteBtn = itemView.findViewById(R.id.ib_delete_australian_animal)
        }
        fun bind(animal: AustralianAnimal) {
            nameTextView.text = animal.name
            continentTextView.text = animal.continent
            deleteBtn.setOnClickListener {
                deleteItem(animal)
            }
        }
    }

    inner class NorthAmericanAnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val continentTextView: TextView
        val deleteBtn: ImageButton
        init {
            nameTextView = itemView.findViewById(R.id.tv_northamerican_animal_card)
            continentTextView = itemView.findViewById(R.id.tv_northamerican_continent_card)
            deleteBtn = itemView.findViewById(R.id.ib_delete_northamerican_animal)
        }
        fun bind(animal: NorthAmericanAnimal) {
            nameTextView.text = animal.name
            continentTextView.text = animal.continent
            deleteBtn.setOnClickListener {
                deleteItem(animal)
            }
        }
    }

    inner class SouthAmericanAnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView
        val continentTextView: TextView
        val deleteBtn: ImageButton
        init {
            nameTextView = itemView.findViewById(R.id.tv_southamerican_animal_card)
            continentTextView = itemView.findViewById(R.id.tv_southamerican_continent_card)
            deleteBtn = itemView.findViewById(R.id.ib_delete_southamerican_animal)
        }
        fun bind(animal: SouthAmericanAnimal) {
            nameTextView.text = animal.name
            continentTextView.text = animal.continent
            deleteBtn.setOnClickListener {
                deleteItem(animal)
            }
        }
    }
}
