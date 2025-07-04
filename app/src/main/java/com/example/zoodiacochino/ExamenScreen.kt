package com.example.zoodiacochino

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Pantalla que muestra el examen con preguntas y opciones de respuesta.
 * @param onTerminar Callback que se ejecuta al finalizar el examen, enviando las respuestas del usuario.
 */
@Composable
fun ExamenScreen(preguntas: List<Pregunta>, onTerminar: (List<Int>) -> Unit) {
    // Estado para almacenar las respuestas seleccionadas por el usuario
    val respuestas = remember { mutableStateListOf<Int>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Examen de Conocimientos",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Mostrar cada pregunta con sus opciones
        preguntas.forEachIndexed { index, pregunta ->
            Text(
                "${index + 1}. ${pregunta.texto}",
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Mostrar las opciones de respuesta como RadioButtons
            pregunta.opciones.forEachIndexed { opcionIndex, opcion ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    RadioButton(
                        selected = respuestas.getOrNull(index) == opcionIndex,
                        onClick = {
                            if (respuestas.size <= index) {
                                respuestas.add(opcionIndex)
                            } else {
                                respuestas[index] = opcionIndex
                            }
                        }
                    )
                    Text(opcion)
                }
            }
        }

        // Botón para terminar el examen
        Button(
            onClick = { onTerminar(respuestas) },
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Terminar Examen")
        }
    }
}