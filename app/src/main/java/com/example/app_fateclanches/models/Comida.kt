package com.example.app_fateclanches.models

import java.io.Serializable

data class Comida(
    val nome: String,
    val disponivel: Boolean,
    val preco: Double,
    val imagemUrl: String,
    val categoria: String
): Serializable
