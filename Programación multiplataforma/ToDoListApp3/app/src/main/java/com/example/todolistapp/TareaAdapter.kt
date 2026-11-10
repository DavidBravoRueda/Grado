package com.example.todolistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TareaAdapter(
    private val tareas: MutableList<Tarea>,
    private val onEliminar: (Tarea) -> Unit,
    private val onMarcarCompletada: (Tarea) -> Unit
) : RecyclerView.Adapter<TareaAdapter.TareaViewHolder>() {

    inner class TareaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkboxCompletada: CheckBox = itemView.findViewById(R.id.checkbox_completada)
        val textTarea: TextView = itemView.findViewById(R.id.text_tarea)
        val buttonEliminar: ImageButton = itemView.findViewById(R.id.button_eliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TareaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val tarea = tareas[position]

        holder.textTarea.text = tarea.nombre

        holder.checkboxCompletada.isChecked = tarea.completada

        holder.checkboxCompletada.setOnCheckedChangeListener { _, isChecked ->
            tarea.completada = isChecked
            onMarcarCompletada(tarea)
        }

        holder.buttonEliminar.setOnClickListener {
            onEliminar(tarea)
        }
    }

    override fun getItemCount(): Int {
        return tareas.size
    }
}