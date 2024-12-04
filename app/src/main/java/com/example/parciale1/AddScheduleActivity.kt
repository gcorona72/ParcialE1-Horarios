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
            val day = binding.daySpinner.selectedItem.toString()
            val startTime = binding.startTimeEditText.text.toString()
            val endTime = binding.endTimeEditText.text.toString()

            if (subject.isNotEmpty() && day.isNotEmpty() && startTime.isNotEmpty() && endTime.isNotEmpty()) {
                // Guardar el horario en la base de datos
                val db = MySqlite3Database(this)
                db.insertData(subject, day, startTime, endTime)
                Toast.makeText(this, "Horario Guardado: $subject el $day de $startTime a $endTime", Toast.LENGTH_LONG).show()
                finish() // Cierra esta pantalla después de guardar
            } else {
                Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}