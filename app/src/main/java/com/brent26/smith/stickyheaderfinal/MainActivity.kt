package com.brent26.smith.stickyheaderfinal

import android.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_item.*


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    internal var arraylist: List<List<ListItem>>? = null
    lateinit var adapter: MyRecyclerAdapter

    private val list: ArrayList<ListItem>
        get() {
            val arrayList = ArrayList<ListItem>()

            val header = Header()
            val header2 = Header()
            val header3 = Header()


            header.header = "First Heading"
            val heading1FirstItem = ContentItem()
            heading1FirstItem.name = "First item in heading 1"

            header2.header = "Second Heading"
            val heading2FirstItem = ContentItem()
            heading2FirstItem.name = "first item in heading 2"

            header3.header = "Third Heading"
            val heading3FirstItem = ContentItem()
            heading3FirstItem.name = "First item in heading 3"


            arrayList.add(header)
            arrayList.add(heading1FirstItem)

            arrayList.add(header2)
            arrayList.add(heading2FirstItem)

            arrayList.add(header3)
            arrayList.add(heading3FirstItem)


            return arrayList
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.my_recycler_view)
        val linearLayoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerAdapter(list)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    fun addHeader(){

    }

}
