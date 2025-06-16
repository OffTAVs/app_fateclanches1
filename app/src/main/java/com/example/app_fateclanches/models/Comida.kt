package com.example.app_fateclanches.models

import java.io.Serializable

data class Comida(
    val nome: String,
    val quantidade: Int,
    val preco: Double,
    val imagem: Int
): Serializable
