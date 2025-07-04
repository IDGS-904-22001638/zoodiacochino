package com.example.zoodiacochino

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Pantalla para ingresar los datos del usuario.
 * @param onSiguiente Callback que se ejecuta al presionar "Siguiente", enviando los datos del usuario.
 */
@Composable
fun UsuarioScreen(onSiguiente: (Usuario) -> Unit) {
    // Estados para los campos del formulario
    var nombre by remember { mutableStateOf("") }
    var apellidoP by remember { mutableStateOf("") }
    var apellidoM by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("") }
    var mes by remember { mutableStateOf("") }
    var año by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("Masculino") }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Datos Personales",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        // Campo para el nombre
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            isError = showError && nombre.isBlank()
        )

        // Campos para apellidos
        OutlinedTextField(
            value = apellidoP,
            onValueChange = { apellidoP = it },
            label = { Text("Apellido Paterno") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = apellidoM,
            onValueChange = { apellidoM = it },
            label = { Text("Apellido Materno") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // Campos para fecha de nacimiento
        Row(Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = dia,
                onValueChange = { dia = it },
                label = { Text("Día") },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            OutlinedTextField(
                value = mes,
                onValueChange = { mes = it },
                label = { Text("Mes") },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            OutlinedTextField(
                value = año,
                onValueChange = { año = it },
                label = { Text("Año") },
                modifier = Modifier.weight(1f),
                isError = showError && año.isBlank()
            )
        }

        // Selección de sexo
        Text("Sexo:", modifier = Modifier.padding(top = 8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sexo == "Masculino",
                onClick = { sexo = "Masculino" }
            )
            Text("Masculino")
            RadioButton(
                selected = sexo == "Femenino",
                onClick = { sexo = "Femenino" },
                modifier = Modifier.padding(start = 16.dp)
            )
            Text("Femenino")
        }

        // Mostrar error si los campos obligatorios están vacíos
        if (showError && (nombre.isBlank() || año.isBlank())) {
            Text(
                "Por favor complete todos los campos obligatorios",
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        // Botón para continuar
        Button(
            onClick = {
                if (nombre.isNotBlank() && año.isNotBlank()) {
                    val user = Usuario(
                        nombre, apellidoP, apellidoM,
                        dia, mes, año, sexo
                    )
                    onSiguiente(user)
                } else {
                    showError = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Siguiente")
        }
    }
}