package com.example.zoodiacochino

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Pantalla que muestra las respuestas del usuario con retroalimentación visual.
 * @param onVerResultado Callback para navegar a la pantalla de resultados.
 */
@Composable
fun RespuestasScreen(
    preguntas: List<Pregunta>,
    respuestasUsuario: List<Int>,
    onVerResultado: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Tus Respuestas",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Mostrar cada pregunta con las respuestas del usuario
        preguntas.forEachIndexed { index, pregunta ->
            Text(
                "Pregunta ${index + 1}: ${pregunta.texto}",
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Mostrar cada opción con colores según su corrección
            pregunta.opciones.forEachIndexed { opcionIndex, opcion ->
                val esCorrecta = opcionIndex == pregunta.respuestaCorrecta
                val fueSeleccionada = respuestasUsuario.getOrNull(index) == opcionIndex

                val color = when {
                    esCorrecta -> Color.Green
                    fueSeleccionada && !esCorrecta -> Color.Red
                    else -> Color.Black
                }

                Text(
                    text = opcion,
                    color = color,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }

        // Botón para ver el resultado final
        Button(
            onClick = onVerResultado,
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Ver Resultados")
        }
    }
}