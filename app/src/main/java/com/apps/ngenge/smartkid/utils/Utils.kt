package com.apps.ngenge.smartkid.utils

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.ImageView


class Utils{
    companion object {
        fun setImageFromString(imageView: ImageView,name:String,context: Context)
        {
            val id = context.resources.getIdentifier(name,"drawable",context.packageName)
            imageView.setImageResource(id)

        }
    }


    interface FragmentChangeListener{

        fun replaceFragment()

    }
}