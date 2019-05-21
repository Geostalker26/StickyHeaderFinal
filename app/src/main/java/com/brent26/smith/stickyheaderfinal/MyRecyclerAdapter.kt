package com.brent26.smith.stickyheaderfinal

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyRecyclerAdapter(//Header header;
    private var list: List<ListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_HEADER) {
            val v = inflater.inflate(R.layout.header, parent, false)
            VHHeader(v)
        } else {
            val v = inflater.inflate(R.layout.recycler_item, parent, false)
            VHItem(v)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is VHHeader) {
            // VHHeader VHheader = (VHHeader)holder;
            val currentItem = list[position] as Header
            holder.txtTitle.text = currentItem.header
        } else if (holder is VHItem) {
            val currentItem = list[position] as ContentItem
            holder.txtName.text = currentItem.name
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (isPositionHeader(position)) TYPE_HEADER else TYPE_ITEM
    }

    private fun isPositionHeader(position: Int): Boolean {
        return list[position] is Header
    }

    override fun getItemCount(): Int {
        return list.size
    }

    internal inner class VHHeader(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById<View>(R.id.txtHeader) as TextView

    }

    internal inner class VHItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView = itemView.findViewById<View>(R.id.txtName) as TextView

    }

    companion object {
        private val TYPE_HEADER = 0
        private val TYPE_ITEM = 1
    }
}