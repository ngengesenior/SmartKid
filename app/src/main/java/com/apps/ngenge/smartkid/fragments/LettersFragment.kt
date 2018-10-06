package com.apps.ngenge.smartkid.fragments

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.apps.ngenge.smartkid.R
import com.apps.ngenge.smartkid.adapters.LettersRecyclerAdapter
import com.apps.ngenge.smartkid.utils.Utils
import kotlinx.android.synthetic.main.fragment_letters.*
import java.util.*

class LettersFragment:Fragment(),Utils.FragmentChangeListener,TextToSpeech.OnInitListener
{
    private lateinit var textToSpeech: TextToSpeech
    override fun onInit(status: Int) {
        val result = textToSpeech.setLanguage(Locale.US)
        if(result== TextToSpeech.LANG_MISSING_DATA ||
                result == TextToSpeech.LANG_NOT_SUPPORTED)
        {

            Log.d("LANG_SUPPORT","Language not supported")

        }

        else{

        }
    }

    override fun replaceFragment() {


    }

    private lateinit var lettersList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lettersList = resources.getStringArray(R.array.letters)
        textToSpeech = TextToSpeech(this@LettersFragment.context,this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_letters,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = LettersRecyclerAdapter(lettersList,this@LettersFragment.context!!,{letterItem:String -> letterClicked(letterItem)})
        lettersRecyclerView.adapter = adapter

    }


    companion object {

        fun newInstance():LettersFragment{
            return LettersFragment()
        }
    }


    private fun letterClicked(string:String)
    {
        textToSpeech.speak(string,TextToSpeech.QUEUE_FLUSH,null)
        Toast.makeText(this@LettersFragment.context,string, Toast.LENGTH_SHORT)
                .show()
    }
}