package com.apps.ngenge.smartkid.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.ngenge.smartkid.R
import com.apps.ngenge.smartkid.fragments.LettersFragment
import com.apps.ngenge.smartkid.utils.Utils
import kotlinx.android.synthetic.main.letter_layout.view.*


class LettersRecyclerAdapter(var lettersList:Array<String>, val context: Context,val clickListener: (String)-> Unit): RecyclerView.Adapter<LettersRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.letter_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = lettersList.size




    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val letter = lettersList[position]
        viewHolder.bind(letter)
    }


   inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val capitalLetter = view.capitalLetter
        val smallLetter = view.smallLetter

       fun bind(letter:String)
       {
           capitalLetter.text = letter.capitalize()
           smallLetter.text = letter

           view.setOnClickListener {
               clickListener(letter)
           }

       }
    }



}