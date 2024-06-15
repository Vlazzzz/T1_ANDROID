package com.example.tema1_android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tema1_android.data.models.AnimalDbModel
import com.example.tema1_android.data.tasks.GetAllAnimalsTask
import com.example.tema1_android.data.tasks.GetAllContinentsTask
import com.example.tema1_android.data.tasks.InsertAnimalTask
import com.example.tema1_android.data.tasks.UpdateAnimalTask
import com.example.tema1_android.helpers.extensions.formatLetters


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val closeButton = findViewById<Button>(R.id.button_close)
        closeButton.setOnClickListener {
            finish() // Această linie va închide activitatea când butonul este apăsat
        }

        val etAnimalName = findViewById<EditText>(R.id.et_animal_name)
        val etAnimalContinent = findViewById<EditText>(R.id.et_continent_name)
        val addAnimalButton = findViewById<Button>(R.id.button_add)

        val database = ApplicationController.instance.projectDatabase

        addAnimalButton.setOnClickListener {
            val animalName = etAnimalName.text.toString().run { formatLetters() }
            val animalContinent = etAnimalContinent.text.toString().run { formatLetters() }

            if (animalName.isEmpty() || animalContinent.isEmpty()
                || animalName.isBlank() || animalContinent.isBlank()
            ) {
                Toast.makeText(this, "Add text in all fields!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            GetAllContinentsTask(
                onSuccess = { continents ->
                    if (continents.none { it.name == animalContinent }) {
                        Toast.makeText(this, "Continent does not exist!", Toast.LENGTH_SHORT).show()
                        return@GetAllContinentsTask
                    }
                }
            ).execute(
            )

            val animal = AnimalDbModel(name = animalName, continent = animalContinent)

            GetAllAnimalsTask(
                onSuccess = { animals ->
                    val animalToUpdate = animals.find { it.name == animalName }
                    if (animalToUpdate != null) {
                        animalToUpdate.continent = animalContinent
                        UpdateAnimalTask(
                            onSuccess = {
                                runOnUiThread {
                                    etAnimalName.text.clear()
                                    etAnimalContinent.text.clear()
                                    Toast.makeText(this, "Animal updated!", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                        ).execute(animalToUpdate)
                    } else {
                        InsertAnimalTask {
                            runOnUiThread {
                                etAnimalName.text.clear()
                                etAnimalContinent.text.clear()
                                Toast.makeText(this, "Animal added!", Toast.LENGTH_SHORT).show()
                            }
                        }.execute(animal)
                    }
                }
            ).execute(
            )
        }
    }
}