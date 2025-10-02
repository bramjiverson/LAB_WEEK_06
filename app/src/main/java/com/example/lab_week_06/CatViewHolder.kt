package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

/**
 * ViewHolder for displaying a single cat item in the RecyclerView.
 *
 * This class holds references to the views in the item layout and contains
 * the logic to bind a CatModel object to those views. Its only responsibilities
 * are finding views and populating them with data.
 *
 * @param containerView The root view of the item layout (e.g., a ConstraintLayout).
 * @param imageLoader An interface used to load the cat's photo.
 */
class CatViewHolder(
    containerView: View, // Changed from private to default (public)
    private val imageLoader: ImageLoader
    // The OnClickListener has been removed from the constructor
) : RecyclerView.ViewHolder(containerView) {

    companion object {
        // Unicode symbols for gender representation.
        private const val FEMALE_SYMBOL = "\u2640" // ♀
        private const val MALE_SYMBOL = "\u2642"   // ♂
        private const val UNKNOWN_SYMBOL = "?"
    }

    // Lazily initialize views to improve performance.
    private val catBiographyView: TextView by lazy {
        containerView.findViewById(R.id.cat_biography)
    }
    private val catBreedView: TextView by lazy {
        containerView.findViewById(R.id.cat_breed)
    }
    private val catGenderView: TextView by lazy {
        containerView.findViewById(R.id.cat_gender)
    }
    private val catNameView: TextView by lazy {
        containerView.findViewById(R.id.cat_name)
    }
    private val catPhotoView: ImageView by lazy {
        containerView.findViewById(R.id.cat_photo)
    }

    /**
     * Binds the data from a CatModel object to the views in the ViewHolder.
     * This method is called by the adapter's onBindViewHolder.
     *
     * @param cat The data model for the current cat item.
     */
    fun bindData(cat: CatModel) {
        // The setOnClickListener has been removed from here.
        // It's now handled in the adapter's onBindViewHolder.

        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBiographyView.text = cat.biography

        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
            else -> "Unknown"
        }

        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }
    }
    // The redundant OnClickListener interface has been removed from here.
}
