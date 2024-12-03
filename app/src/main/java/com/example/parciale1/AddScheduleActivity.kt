package com.example.parciale1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.parciale1.databinding.ActivityAddScheduleBinding


class AddScheduleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar acción del botón "Guardar"
        binding.saveButton.setOnClickListener {
            val subject = binding.subjectEditText.text.toString()
            val time = binding.timeEditText.text.toString()

            if (subject.isNotEmpty() && time.isNotEmpty()) {
                // Guardar el horario (lógica básica de ejemplo)
                Toast.makeText(this, "Horario Guardado: $subject a las $time", Toast.LENGTH_LONG).show()
                finish() // Cierra esta pantalla después de guardar
            } else {
                Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
