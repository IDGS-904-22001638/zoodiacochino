package com.example.zoodiacochino

/**
 * Clase de datos que representa una pregunta del examen.
 * @param respuestaCorrecta Índice de la respuesta correcta (0 a 3).
 */
data class Pregunta(
    val texto: String,
    val opciones: List<String>,
    val respuestaCorrecta: Int
)