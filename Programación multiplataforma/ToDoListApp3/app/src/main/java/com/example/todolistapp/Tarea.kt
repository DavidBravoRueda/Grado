package com.example.todolistapp

data class Tarea(
    val id: Long,
    val nombre: String,
    var completada: Boolean = false
) {
    fun marcarComoCompletada() {
        completada = true
    }

    fun marcarComoNoCompletada() {
        completada = false
    }

    override fun toString(): String {
        return "$nombre - ${if (completada) "Completada" else "Pendiente"}"
    }
}
