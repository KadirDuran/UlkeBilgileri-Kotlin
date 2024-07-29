package com.example.testapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.testapp.databinding.ActivityCountryInfoBinding
import com.example.testapp.databinding.ActivityMainBinding

class CountryInfo : AppCompatActivity() {
    private lateinit var binding: ActivityCountryInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding Process Start
        binding = ActivityCountryInfoBinding .inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //Binding Process Finish


        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dataIntent = intent
        val data = dataIntent.getSerializableExtra("counrtyInfo") as Country
        binding.txtCountry.text = data.name.toString()
        binding.txtInfo.text = data.info.toString()
        binding.img.setImageResource(data.img)

    }
}