package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper // <-- Added import
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.ImageLoader
import com.example.lab_week_06.CatViewHolder

/**
 * Adapter for the RecyclerView that displays a list of cats.
 */
class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<CatViewHolder>() {

    private val cats = mutableListOf<CatModel>()

    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        notifyDataSetChanged()
    }

    /**
     * Removes an item from the list at a given position and notifies the adapter.
     */
    fun removeItem(position: Int) {
        if (position in cats.indices) { // Safety check
            cats.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader)
    }

    override fun getItemCount() = cats.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = cats[position]
        holder.bindData(cat)
        holder.itemView.setOnClickListener {
            onClickListener.onItemClick(cat)
        }
    }

    /**
     * An interface that the hosting Activity or Fragment will implement to receive click events.
     */
    interface OnClickListener {
        fun onItemClick(cat: CatModel)
    }
}

/**
 * A callback class for ItemTouchHelper to handle swipe-to-delete functionality.
 * This class is now outside the CatAdapter.
 *
 * @param adapter The CatAdapter instance to call removeItem() on.
 */
class SwipeToDeleteCallback(private val adapter: CatAdapter) : ItemTouchHelper.SimpleCallback(0,
    ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    // This is used for drag-and-drop, which we don't need.
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    // This is called when an item is swiped.
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        adapter.removeItem(position) // Call removeItem on the adapter instance
    }
}
