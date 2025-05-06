package com.example.rasanusantara

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(private val context: Context, private val dataList: List<ListData>)
    : ArrayAdapter<ListData>(context, 0, dataList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item, parent, false)

        val currentItem = dataList[position]

        val img = itemView.findViewById<ImageView>(R.id.item_image)
        val name = itemView.findViewById<TextView>(R.id.item_name)
        val prov = itemView.findViewById<TextView>(R.id.item_prov)

        img.setImageResource(currentItem.image)
        name.text = currentItem.name
        prov.text = currentItem.prov

        return itemView
    }
}
