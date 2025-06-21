package com.example.app_fateclanches.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_fateclanches.R

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageView>(R.id.nav_lanches).setOnClickListener {
            startActivity(Intent(this, ComidasActivity::class.java).putExtra("categoria", "Lanche"))
        }

        findViewById<ImageView>(R.id.nav_bebidas).setOnClickListener {
            startActivity(Intent(this, ComidasActivity::class.java).putExtra("categoria", "Bebida"))
        }

        findViewById<ImageView>(R.id.nav_bomboniere).setOnClickListener {
            startActivity(Intent(this, ComidasActivity::class.java).putExtra("categoria", "Acompanhamento"))
        }

        findViewById<ImageView>(R.id.nav_perfil).setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }
    }
}