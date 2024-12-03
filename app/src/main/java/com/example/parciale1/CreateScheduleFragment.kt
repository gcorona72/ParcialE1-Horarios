package com.example.parciale1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class CreateScheduleFragment : Fragment(R.layout.fragment_create_schedule) {

    private lateinit var db: MySqlite3Database

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = MySqlite3Database(requireContext())

        val nameEditText = view.findViewById<EditText>(R.id.editTextName)
        val dayEditText = view.findViewById<EditText>(R.id.editTextDay)
        val startTimeEditText = view.findViewById<EditText>(R.id.editTextStartTime)
        val endTimeEditText = view.findViewById<EditText>(R.id.editTextEndTime)
        val saveButton = view.findViewById<Button>(R.id.buttonSave)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val day = dayEditText.text.toString().trim()
            val startTime = startTimeEditText.text.toString().trim()
            val endTime = endTimeEditText.text.toString().trim()

            if (name.isNotEmpty() && day.isNotEmpty() && startTime.isNotEmpty() && endTime.isNotEmpty()) {
                db.insertData(name, day, startTime, endTime)
                Toast.makeText(requireContext(), "Asignatura guardada", Toast.LENGTH_SHORT).show()
                nameEditText.text.clear()
                dayEditText.text.clear()
                startTimeEditText.text.clear()
                endTimeEditText.text.clear()
            } else {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
