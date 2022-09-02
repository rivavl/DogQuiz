package com.marina.dogquiz.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marina.dogquiz.R
import com.marina.dogquiz.guess_breed.presentation.fragment.ChooseLevelFragment
import com.marina.dogquiz.guide.presentation.fragment.BreedListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}