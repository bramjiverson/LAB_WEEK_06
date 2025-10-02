package com.example.lab_week_06 // Corrected package name

import android.os.Bundle
import androidx.appcompat.app.AlertDialog // <-- Added import for AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
// The CatRepository import is not used in this version, so it can be removed or left.
// import com.example.lab_week_06.data.CatRepository
import com.example.lab_week_06.model.CatBreed // <-- Added import for CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender // <-- Added import for Gender

// --- Imports that were previously commented out ---
import com.example.lab_week_06.CatAdapter
import com.example.lab_week_06.GlideImageLoader

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        // Corrected the ID to match your previous layout files
        findViewById(R.id.cat_recycler_view)
    }

    private val catAdapter by lazy {
        // Glide is used here to load the images
        // Here we are passing an anonymous OnClickListener object to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object:
            CatAdapter.OnClickListener {
            // When an item is clicked, the pop-up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter

        // Setup the layout manager for the recycler view
        // A layout manager is used to set the structure of the item views.
        // For this tutorial, we're using a vertical linear structure.
        recyclerView.layoutManager = LinearLayoutManager(this) // The other parameters are defaults

        // Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.BalineseJavanese,
                    name = "Fred",
                    biography = "Silent and deadly",
                    imageUrl = "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.ExoticShorthair,
                    name = "Wilma",
                    biography = "Cuddly assassin",
                    imageUrl = "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    gender = Gender.Unknown,
                    breed = CatBreed.AmericanCurl,
                    name = "Curious George",
                    biography = "Award winning investigator",
                    imageUrl = "https://cdn2.thecatapi.com/images/bar.jpg"
                )
            )
        )
    }

    // This will create a pop up dialog when one of the items from the recycler view is clicked.
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            // Set the title for the dialog
            .setTitle("Cat Selected")
            // Set the message for the dialog
            .setMessage("You have selected cat ${cat.name}")
            // Set the "OK" button and its click action (in this case, it does nothing but close the dialog)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
