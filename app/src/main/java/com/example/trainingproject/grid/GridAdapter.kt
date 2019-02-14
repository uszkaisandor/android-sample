package com.example.trainingproject.grid

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingproject.R
import com.example.trainingproject.service.RandomColor
import kotlinx.android.synthetic.main.item_grid.view.*

class GridAdapter(
    private var context: Context,
    private var gridItems: List<GridItem>
) : RecyclerView.Adapter<GridAdapter.GridItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GridItemHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_grid, parent, false)
        return GridItemHolder(view)
    }

    override fun getItemCount(): Int {
        return gridItems.size
    }

    fun setDataSet(gridItems: List<GridItem>) {
        this.gridItems = gridItems
    }


    override fun onBindViewHolder(holder: GridItemHolder, p1: Int) {
        val dynamicPosition: Int = holder.adapterPosition
        val gridItem: GridItem = gridItems[dynamicPosition]
        setText(holder, gridItem)
        setColor(holder)
    }

    private fun setColor(holder: GridItemHolder) {
        holder.cardNumber?.setBackgroundColor(RandomColor.generateColor())
    }


    @SuppressLint("SetTextI18n")
    private fun setText(holder: GridItemHolder, gridItem: GridItem) {
        holder.cardNumber?.text = gridItem.cardNumber.toString()
        //holder.cardNumber?.setBackgroundColor(RandomColor.generateColor())
    }

    class GridItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardNumber: TextView? = itemView.gridItemNumber
    }

}