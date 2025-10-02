package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

// --- Corrected Imports ---
import com.example.lab_week_06.CatAdapter
import com.example.lab_week_06.GlideImageLoader
import com.example.lab_week_06.SwipeToDeleteCallback

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.cat_recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object :
            CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup the adapter and layout manager for the recycler view
        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Instantiate SwipeToDeleteCallback and attach it to the RecyclerView
        val swipeToDeleteCallback = SwipeToDeleteCallback(catAdapter)
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // --- UPDATED DATA LIST ---
        // Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.BalineseJavanese,
                    name = "Fred",
                    biography = "Silent and deadly. Enjoys chasing laser dots.",
                    imageUrl = "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.ExoticShorthair,
                    name = "Wilma",
                    biography = "Cuddly assassin. Master of stealthy naps.",
                    imageUrl = "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    gender = Gender.Unknown,
                    breed = CatBreed.AmericanCurl,
                    name = "Curious George",
                    biography = "Award-winning investigator of open cupboards.",
                    imageUrl = "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.AmericanCurl,
                    name = "Daisy",
                    biography = "Loves sunbathing and judging your life choices.",
                    imageUrl = "https://cdn2.thecatapi.com/images/btv.jpg"
                ),
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.ExoticShorthair,
                    name = "Smokey",
                    biography = "A distinguished gentleman who prefers his food on time.",
                    imageUrl = "https://cdn2.thecatapi.com/images/c25.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.BalineseJavanese,
                    name = "Misty",
                    biography = "An elegant dancer, especially at 3 AM on your face.",
                    imageUrl = "https://cdn2.thecatapi.com/images/6v1.jpg"
                ),
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.AmericanCurl,
                    name = "Leo",
                    biography = "Brave explorer of cardboard boxes and paper bags.",
                    imageUrl = "https://cdn2.thecatapi.com/images/15i.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.ExoticShorthair,
                    name = "Chloe",
                    biography = "Professional bird watcher and part-time loaf of bread.",
                    imageUrl = "https://cdn2.thecatapi.com/images/k71.jpg"
                ),
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.BalineseJavanese,
                    name = "Simba",
                    biography = "King of the couch and ruler of all he surveys.",
                    imageUrl = "https://cdn2.thecatapi.com/images/a7g.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.AmericanCurl,
                    name = "Nala",
                    biography = "Expert in getting what she wants with a single look.",
                    imageUrl = "https://cdn2.thecatapi.com/images/aen.jpg"
                )
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
