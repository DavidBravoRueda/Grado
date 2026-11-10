package com.example.todolistapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    private val tareas = mutableListOf<Tarea>()
    private lateinit var tareaAdapter: TareaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        tareaAdapter = TareaAdapter(tareas, { tarea ->
            tareas.remove(tarea)
            tareaAdapter.notifyDataSetChanged()
        }, { tarea ->
            tareaAdapter.notifyDataSetChanged()
        })
        recyclerView.adapter = tareaAdapter

        val btnAgregar: Button = findViewById(R.id.btnAgregar)
        val editTextTarea: EditText = findViewById(R.id.editTextTarea)

        btnAgregar.setOnClickListener {
            val tareaNombre = editTextTarea.text.toString()
            if (tareaNombre.isNotEmpty()) {
                val nuevaTarea = Tarea(id = tareas.size.toLong(), nombre = tareaNombre)
                tareas.add(nuevaTarea)
                tareaAdapter.notifyItemInserted(tareas.size - 1)
                editTextTarea.text.clear()
            } else {
                Toast.makeText(this, "Por favor ingresa una tarea", Toast.LENGTH_SHORT).show()
            }
        }
    }
}