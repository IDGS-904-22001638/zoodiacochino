package com.example.zoodiacochino

import androidx.lifecycle.ViewModel

class ExamenViewModel : ViewModel() {

    // Lista de preguntas
    private val _preguntas = listOf(
        Pregunta("¿Cuál es la suma de 2 + 2?", listOf("8", "6", "4", "3"), 2),
        Pregunta("¿Capital de Francia?", listOf("Roma", "París", "Madrid", "Londres"), 1),
        Pregunta("¿Cuál es el resultado de 5 x 3?", listOf("15", "10", "8", "13"), 0),
        Pregunta("¿Color del cielo despejado?", listOf("Rojo", "Azul", "Verde", "Gris"), 1),
        Pregunta("¿Cuántos días tiene una semana?", listOf("5", "6", "7", "8"), 2),
        Pregunta("¿Cuál es el planeta rojo?", listOf("Tierra", "Venus", "Marte", "Saturno"), 2)
    )

    // Lo ponemos públicamente ya que se necesita acceder desde otras pantallas
    val preguntas: List<Pregunta> = _preguntas
}
