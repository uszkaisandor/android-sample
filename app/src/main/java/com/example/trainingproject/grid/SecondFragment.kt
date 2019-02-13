package com.example.trainingproject.grid

import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trainingproject.BaseFragment
import com.example.trainingproject.R
import kotlinx.android.synthetic.main.second_fragment.*

class SecondFragment : BaseFragment() {

    private val ITEM_WIDTH = 84

    override fun getTitle(): Int {
        return R.string.grid
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        getItemNumbers()
    }

    private fun setAdapter() {
        val itemNumberWhatFillDisplayWidth = getDisplayWidth() / ITEM_WIDTH
        recyclerViewGrid?.layoutManager = GridLayoutManager(requireActivity(), itemNumberWhatFillDisplayWidth)
        recyclerViewGrid?.setHasFixedSize(true)
        recyclerViewGrid?.adapter = GridAdapter(requireActivity(), ArrayList())
    }

    private fun getItemNumbers() {
        val numbersForList = (1..32).toList().toTypedArray()
        val gridItemList = arrayListOf<GridItem>()
        for (i in numbersForList){
            val item = GridItem(i)
            gridItemList.add(item)
        }
        if (gridItemList.isNotEmpty()){
            (recyclerViewGrid?.adapter as GridAdapter).setDataSet(gridItemList)
            recyclerViewGrid?.adapter?.notifyDataSetChanged()
        }

    }

    // Get display width in pixels
    private fun getDisplayWidth(): Int {
        val displayMetrics = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        val displayWidthInPixels = displayMetrics.widthPixels
        //  Return display width in dp
        return (displayWidthInPixels / Resources.getSystem().displayMetrics.density).toInt()
    }

}
