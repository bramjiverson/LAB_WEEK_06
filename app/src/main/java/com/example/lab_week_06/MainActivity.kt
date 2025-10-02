package com.example.lab_week_06 // Corrected package name

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.data.CatRepository
import com.example.lab_week_06.model.CatModel

// --- Missing Imports Added Below ---
import com.example.lab_week_06.CatAdapter
import com.example.lab_week_06.GlideImageLoader
import com.example.lab_week_06.ImageLoader

class MainActivity : AppCompatActivity() {

    // Declare RecyclerView and its adapter
    private lateinit var catRecyclerView: RecyclerView
    private lateinit var catAdapter: CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView from the layout
        catRecyclerView = findViewById(R.id.cat_recycler_view)

        // Initialize the ImageLoader implementation
        val imageLoader: ImageLoader = GlideImageLoader(this)

        // Initialize the CatAdapter
        catAdapter = CatAdapter(layoutInflater, imageLoader)

        // Set up the RecyclerView with a LinearLayoutManager and the adapter
        catRecyclerView.layoutManager = LinearLayoutManager(this)
        catRecyclerView.adapter = catAdapter

        // Load the data from the repository and submit it to the adapter
        val catList: List<CatModel> = CatRepository().getCats()
        catAdapter.setData(catList)
    }
}
