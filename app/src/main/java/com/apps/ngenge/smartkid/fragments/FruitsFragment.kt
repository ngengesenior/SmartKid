package com.apps.ngenge.smartkid.fragments

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.apps.ngenge.smartkid.adapters.FruitsRecyclerAdapter
import com.apps.ngenge.smartkid.R
import com.apps.ngenge.smartkid.models.Fruit
import kotlinx.android.synthetic.main.fragment_fruits.*
import java.util.*

class FruitsFragment:Fragment(),TextToSpeech.OnInitListener{
    private lateinit var textToSpeech: TextToSpeech
    override fun onInit(status: Int) {

        if(status == TextToSpeech.SUCCESS)
        {
            val result = textToSpeech.setLanguage(Locale.US)
            if(result== TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED)
            {

                Log.d("LANG_SUPPORT","Language not supported")

            }

            else{

            }
        }
    }

    private lateinit var fruits:ArrayList<Fruit>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fruits = makeFruits()
        textToSpeech = TextToSpeech(this@FruitsFragment.context,this)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = FruitsRecyclerAdapter(fruits, this@FruitsFragment.context!!,{fruitItem:Fruit -> fruitClicked(fruitItem)})
        fruitsRecyclerView.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_fruits,container,false)

        return view
    }

    companion object {
        fun newInstance():FruitsFragment {
            return FruitsFragment()
        }
    }

    private fun fruitClicked(fruit: Fruit)
    {

        textToSpeech.speak(fruit.name,TextToSpeech.QUEUE_FLUSH,null)
    }

    private fun makeFruits():ArrayList<Fruit>
    {
        val fruitsFromXML = resources.getStringArray(R.array.fruits)
        val fruitsArrayList = ArrayList<Fruit>()
        for (item in fruitsFromXML)
        {
            fruitsArrayList.add(Fruit(item))

        }

        return fruitsArrayList
    }

}