package com.example.parciale1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewScheduleActivity : AppCompatActivity() {

    private lateinit var db: MySqlite3Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_schedule)

        db = MySqlite3Database(this)
        val resultTextView = findViewById<TextView>(R.id.textViewResults)

        val subjects = db.readAllData()

        val resultText = if (subjects.isNotEmpty()) {
            subjects.joinToString("\n") {
                "Asignatura: ${it.name}, Día: ${it.day}, Hora Inicio: ${it.startTime}, Fin: ${it.endTime}"
            }
        } else {
            "No hay asignaturas registradas."
        }
        resultTextView.text = resultText
    }
}