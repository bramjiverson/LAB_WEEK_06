package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

/**
 * Adapter for the RecyclerView that displays a list of cats.
 *
 * @param layoutInflater Inflater to create views from the XML layout.
 * @param imageLoader An abstraction for loading images (e.g., GlideImageLoader).
 */
class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<CatViewHolder>() {

    // Private mutable list to hold the data for the adapter.
    private val cats = mutableListOf<CatModel>()

    /**
     * Clears the existing data and adds a new list of cats.
     * Notifies the adapter that the data set has changed to trigger a UI refresh.
     *
     * Note: For better performance with large lists, consider using DiffUtil
     * instead of notifyDataSetChanged().
     *
     * @param newCats The new list of CatModel objects to display.
     */
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        // This tells the RecyclerView that the entire dataset has changed.
        notifyDataSetChanged()
    }

    /**
     * Called when RecyclerView needs a new ViewHolder. It inflates the item layout
     * and creates the ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        // Inflate the XML layout for each item in the list.
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        // Create and return a new ViewHolder instance.
        return CatViewHolder(view, imageLoader)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     */
    override fun getItemCount(): Int = cats.size

    /**
     * Called by RecyclerView to display the data at the specified position.
     * It gets the data for the current position and binds it to the ViewHolder.
     */
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        // Get the data model for the current position.
        val cat = cats[position]
        // The holder.bindData function is defined in the CatViewHolder class.
        // It's responsible for populating the item's views with the cat's data.
        holder.bindData(cat)
    }
}
