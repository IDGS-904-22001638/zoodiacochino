package com.example.zoodiacochino

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import java.util.Calendar

/**
 * Pantalla que muestra los resultados finales del usuario.
 * @param onVolver Callback para volver al inicio.
 */
@Composable
fun ResultadoScreen(
    usuario: Usuario,
    preguntas: List<Pregunta>,
    respuestasUsuario: List<Int>,
    imagenesSignos: List<Int>,
    onVolver: () -> Unit
) {
    // Cálculo de la edad y el signo chino
    val edad = Calendar.getInstance().get(Calendar.YEAR) - usuario.anioNacimiento.toIntOrNull()!!
    val signos = listOf("Rata", "Buey", "Tigre", "Conejo", "Dragón", "Serpiente",
        "Caballo", "Cabra", "Mono", "Gallo", "Perro", "Cerdo")
    val signoIndex = (usuario.anioNacimiento.toInt() - 1900) % 12
    val signo = signos[signoIndex]
    val correctas = preguntas.indices.count {
        respuestasUsuario.getOrNull(it) == preguntas[it].respuestaCorrecta
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "¡Resultados Finales!",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text("Hola ${usuario.nombre} ${usuario.apellidoPaterno}")
        Text("Tienes $edad años")
        Text("y tu signo zodiacal es $signo")
        // Imagen del signo chino
        Image(
            painter = painterResource(id = imagenesSignos[signoIndex]),
            contentDescription = signo,
            modifier = Modifier
                .padding(16.dp)
                .size(120.dp)
        )
        Text("Calificacion $correctas")

        // Botón para volver al inicio
        Button(
            onClick = onVolver,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Volver al Inicio")
        }
    }
}