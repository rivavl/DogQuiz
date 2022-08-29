package com.marina.dogquiz.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marina.dogquiz.R
import com.marina.dogquiz.presentation.fragment.BreedListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, BreedListFragment()).commit()
    }
}