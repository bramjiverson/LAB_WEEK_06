package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

// --- Missing Imports Added Below ---
import com.example.lab_week_06.ImageLoader
import com.example.lab_week_06.CatViewHolder

/**
 * Adapter for the RecyclerView that displays a list of cats.
 *
 * @param layoutInflater Inflater to create views from the XML layout.
 * @param imageLoader An abstraction for loading images (e.g., GlideImageLoader).
 * @param onClickListener A listener to handle item click events.
 */
class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener // onClickListener is now a required parameter
) : RecyclerView.Adapter<CatViewHolder>() {

    private val cats = mutableListOf<CatModel>()

    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        notifyDataSetChanged() // In a production app, consider using DiffUtil for better performance.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        // Pass the imageLoader to the ViewHolder, but not the click listener yet.
        return CatViewHolder(view, imageLoader)
    }

    override fun getItemCount() = cats.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        // Get the data for the current item
        val cat = cats[position]

        // Bind the data to the views within the ViewHolder
        holder.bindData(cat)

        // Set the click listener on the entire item view
        // This is the standard place to set item-specific listeners
        holder.itemView.setOnClickListener {
            onClickListener.onItemClick(cat)
        }
    }

    /**
     * An interface that the hosting Activity or Fragment will implement
     * to receive click events.
     */
    interface OnClickListener {
        fun onItemClick(cat: CatModel)
    }
}
