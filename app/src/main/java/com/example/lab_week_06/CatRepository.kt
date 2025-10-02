package com.example.lab_week_06.data

import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class CatRepository {
    fun getCats(): List<CatModel> {
        return listOf(
            CatModel(
                name = "Mochi",
                imageUrl = "https://cdn2.thecatapi.com/images/15i.jpg",
                breed = CatBreed.AmericanCurl,
                gender = Gender.Male,
                biography = "Loves to play with yarn and take long naps in the sun."
            ),
            CatModel(
                name = "Luna",
                imageUrl = "https://cdn2.thecatapi.com/images/6v1.jpg",
                breed = CatBreed.BalineseJavanese,
                gender = Gender.Female,
                biography = "A very vocal and intelligent cat who enjoys climbing."
            ),
            CatModel(
                name = "Oliver",
                imageUrl = "https://cdn2.thecatapi.com/images/c25.jpg",
                breed = CatBreed.ExoticShorthair,
                gender = Gender.Male,
                biography = "Quiet, sweet, and loves a good cuddle session."
            )
        )
    }
}
    