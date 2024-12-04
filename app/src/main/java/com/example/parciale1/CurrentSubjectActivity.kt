package com.example.parciale1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class CurrentSubjectActivity : AppCompatActivity() {

    private lateinit var db: MySqlite3Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_subject)

        db = MySqlite3Database(this)
        val resultTextView = findViewById<TextView>(R.id.textViewCurrentSubject)

        val currentDay = SimpleDateFormat("EEEE", Locale.getDefault()).format(Date())
        val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

        val subjects = db.readData(currentDay)

        val currentSubject = subjects.find {
            val startTime = SimpleDateFormat("HH:mm", Locale.getDefault()).parse(it.startTime)
            val endTime = SimpleDateFormat("HH:mm", Locale.getDefault()).parse(it.endTime)
            val now = SimpleDateFormat("HH:mm", Locale.getDefault()).parse(currentTime)
            now.after(startTime) && now.before(endTime)
        }

        resultTextView.text = currentSubject?.let {
            "Asignatura: ${it.name}, Hora Inicio: ${it.startTime}, Fin: ${it.endTime}"
        } ?: "No hay asignaturas en este momento."
    }
}