package com.example.parciale1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.parciale1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createScheduleButton.setOnClickListener {
            val intent = Intent(this, AddScheduleActivity::class.java)
            startActivity(intent)
        }

        binding.viewScheduleButton.setOnClickListener {
            val intent = Intent(this, ViewScheduleActivity::class.java)
            startActivity(intent)
        }

        binding.currentSubjectButton.setOnClickListener {
            val intent = Intent(this, CurrentSubjectActivity::class.java)
            startActivity(intent)
        }
    }
}