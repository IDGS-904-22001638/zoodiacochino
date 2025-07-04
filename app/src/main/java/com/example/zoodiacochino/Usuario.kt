package com.example.zoodiacochino

/**
 * Clase de datos que representa la información del usuario.
 */
data class Usuario(
    var nombre: String = "",
    var apellidoPaterno: String = "",
    var apellidoMaterno: String = "",
    var diaNacimiento: String = "",
    var mesNacimiento: String = "",
    var anioNacimiento: String = "",
    var sexo: String = ""
)