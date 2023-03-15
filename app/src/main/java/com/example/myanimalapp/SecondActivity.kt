package com.example.myanimalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myanimalapp.databinding.ActivityMainBinding
import com.example.myanimalapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra("name").toString()
        val description = intent.getStringExtra("description").toString()
        val photoId = intent.getIntExtra("photoId", 0).toInt()
        Log.d("photo", photoId.toString())
        binding.name.text = name
        binding.description.text = description
        binding.photo.setImageResource(photoId)

    }
}