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

        // Configuración del botón para abrir la pantalla "Añadir Horario"
        binding.createScheduleButton.setOnClickListener {
            val intent = Intent(this, AddScheduleActivity::class.java)
            startActivity(intent)
        }

        // Configuración del botón para abrir la pantalla "Ver Horario" (opcional, en desarrollo)
        binding.viewScheduleButton.setOnClickListener {
            // Aquí puedes agregar la lógica para mostrar los horarios guardados
        }
    }
}
