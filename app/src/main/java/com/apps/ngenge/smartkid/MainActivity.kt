package com.apps.ngenge.smartkid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.apps.ngenge.smartkid.fragments.FruitsFragment
import com.apps.ngenge.smartkid.fragments.LettersFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var position = -1
    private val positionKey = "POSTION"
    private lateinit var fragmentManager: FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        position = 1

        fragmentManager = supportFragmentManager

        if (savedInstanceState == null) {

            fragmentManager.beginTransaction()

                    .add(R.id.fragmentContainer, LettersFragment.newInstance())
                    .commit()
        }


        fabNext.setOnClickListener {
            val fragment = fragmentManager.findFragmentById(R.id.fragmentContainer)
            val transaction = fragmentManager.beginTransaction()
            transaction.setCustomAnimations(R.animator.slide_up,R.animator.slide_down)

            if (fragment is LettersFragment) {

                transaction.replace(R.id.fragmentContainer,FruitsFragment.newInstance())
                transaction.addToBackStack(null)
                transaction.commit()

            }

            else if(fragment is FruitsFragment)
            {
                Log.d("RAGTYPE","FRAGFR")
                transaction.replace(R.id.fragmentContainer,LettersFragment.newInstance())
                fragmentManager.popBackStack()
                transaction.addToBackStack(null)
                transaction.commit()

            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.next_action -> {





            }
        }


        return super.onOptionsItemSelected(item)
    }




    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putInt(positionKey, position)
        super.onSaveInstanceState(outState)
    }


}
