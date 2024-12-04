package com.example.parciale1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class ViewScheduleFragment : Fragment(R.layout.fragment_view_schedule) {

    private lateinit var db: MySqlite3Database

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = MySqlite3Database(requireContext())

        val dayEditText = view.findViewById<EditText>(R.id.editTextDay)
        val searchButton = view.findViewById<Button>(R.id.buttonSearch)
        val resultTextView = view.findViewById<TextView>(R.id.textViewResults)

        searchButton.setOnClickListener {
            val day = dayEditText.text.toString().trim()

            if (day.isNotEmpty()) {
                val subjects = db.readData(day)

                val resultText = if (subjects.isNotEmpty()) {
                    subjects.joinToString("\n") {
                        "Asignatura: ${it.name}, Hora Inicio: ${it.startTime}, Fin: ${it.endTime}"
                    }
                } else {
                    "No hay asignaturas registradas para este día."
                }
                resultTextView.text = resultText
            } else {
                resultTextView.text = "Por favor, introduce un día."
            }
        }
    }
}