package com.example.zoodiacochino

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

/**
 * Aplicación principal que gestiona la navegación entre pantallas.
 * - Pantallas: "usuario", "examen", "respuestas", "resultado".
 */
@Composable
fun AppZodiacoChino() {
    // Estado para controlar la pantalla actual
    val pantallaActual = remember { mutableStateOf("usuario") }

    // Datos del usuario ingresados en la primera pantalla
    val usuario = remember { mutableStateOf(Usuario()) }

    // Respuestas del examen
    val respuestas = remember { mutableStateOf(listOf<Int>()) }

    // ViewModel que contiene las preguntas del examen
    val viewModel = ExamenViewModel()

    // Lista de imágenes de los signos del zodiaco chino (deben estar en res/drawable)
    val imagenesSignos = listOf(
        R.drawable.rata, R.drawable.buey, R.drawable.tigre,
        R.drawable.conejo, R.drawable.dragon, R.drawable.serpiente,
        R.drawable.caballo, R.drawable.cabra, R.drawable.mono,
        R.drawable.gallo, R.drawable.perro, R.drawable.cerdo
    )

    // Navegación entre pantallas
    when (pantallaActual.value) {
        "usuario" -> UsuarioScreen { user ->
            usuario.value = user
            pantallaActual.value = "examen"
        }
        "examen" -> ExamenScreen(
            preguntas = viewModel.preguntas,
            onTerminar = { respuestasUsuario ->
                respuestas.value = respuestasUsuario
                pantallaActual.value = "respuestas"
            }
        )
        "respuestas" -> RespuestasScreen(
            preguntas = viewModel.preguntas,
            respuestasUsuario = respuestas.value,
            onVerResultado = { pantallaActual.value = "resultado" }
        )
        "resultado" -> ResultadoScreen(
            usuario = usuario.value,
            preguntas = viewModel.preguntas,
            respuestasUsuario = respuestas.value,
            imagenesSignos = imagenesSignos,
            onVolver = { pantallaActual.value = "usuario" }
        )
    }
}