package com.example.app_fateclanches.models

import java.io.Serializable

data class Usuario(
    val _id:String?,
    val nome:String,
    val email:String,
    val senha:String,
    val confirmarsenha:String,
): Serializable
