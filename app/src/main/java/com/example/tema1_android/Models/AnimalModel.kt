package com.example.tema1_android.Models

enum class AnimalContinent(val key: Int) {
    EUROPE(0),
    AFRICA(1),
    ASIA(2),
    NORTH_AMERICA(3),
    SOUTH_AMERICA(4),
    AUSTRALIA(5),
    ANTARCTICA(6)
}

sealed class AnimalModel(val type: AnimalContinent, open val name: String, open val continent: String)

data class EuropeanAnimal(override val name: String, override val continent: String) : AnimalModel(AnimalContinent.EUROPE, name, continent)
data class AfricanAnimal(override val name: String, override val continent: String) : AnimalModel(AnimalContinent.AFRICA, name, continent)
data class AsianAnimal(override val name: String, override val continent: String) : AnimalModel(AnimalContinent.ASIA, name, continent)
data class NorthAmericanAnimal(override val name: String, override val continent: String) : AnimalModel(AnimalContinent.NORTH_AMERICA, name, continent)
data class SouthAmericanAnimal(override val name: String, override val continent: String) : AnimalModel(AnimalContinent.SOUTH_AMERICA, name, continent)
data class AustralianAnimal(override val name: String, override val continent: String) : AnimalModel(AnimalContinent.AUSTRALIA, name, continent)
data class AntarcticAnimal(override val name: String, override val continent: String) : AnimalModel(AnimalContinent.ANTARCTICA, name, continent)
