package com.apps.ngenge.smartkid.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.ngenge.smartkid.R
import com.apps.ngenge.smartkid.models.Fruit
import com.apps.ngenge.smartkid.utils.Utils
import kotlinx.android.synthetic.main.fruit_layout.view.*

class FruitsRecyclerAdapter(var fruitsList:ArrayList<Fruit>,val context: Context,val clickListener:(Fruit)-> Unit): RecyclerView.Adapter<FruitsRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fruit_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = fruitsList.size




    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val fruitName = fruitsList[position]
        viewHolder.bind(fruitsList[position],clickListener)


    }


    inner class ViewHolder(val view:View): RecyclerView.ViewHolder(view) {
        val fruitImageView = view.fruitImageView
        val fruitNameTextView = view.fruitNameTextView

        fun bind(fruit: Fruit,clickListener: (Fruit) -> Unit)
        {
            Utils.setImageFromString(view.fruitImageView,fruit.name,context)

            view.fruitNameTextView.text = fruit.name.capitalize()
            view.setOnClickListener { clickListener(fruit) }
        }
    }


}