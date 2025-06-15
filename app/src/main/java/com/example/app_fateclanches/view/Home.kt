package com.example.app_fateclanches.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.app_fateclanches.R
import com.example.app_fateclanches.adapter.CategoriaAdapter
import com.example.app_fateclanches.databinding.ActivityHomeBinding
import com.example.app_fateclanches.models.Categoria

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var categoriaAdapter: CategoriaAdapter
    private val listaCategoria: MutableList<Categoria> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // ✅ Inicialização do ViewBinding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        val recyclerViewCategorias = binding.recyclerViewCategorias
        recyclerViewCategorias.layoutManager = GridLayoutManager(this, 2)
        categoriaAdapter = CategoriaAdapter(this, listaCategoria)
        recyclerViewCategorias.setHasFixedSize(true)
        recyclerViewCategorias.adapter = categoriaAdapter

        getCategorias()

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
    }

    private fun getCategorias() {
        val catergotia1 = Categoria(R.drawable.ic_lanches_navbar, "Lanches")
        listaCategoria.add(catergotia1)

        val catergotia2 = Categoria(R.drawable.ic_bebidas_navbar, "Bebidas")
        listaCategoria.add(catergotia2)

        val catergotia3 = Categoria(R.drawable.ic_bomboniere_navbar, "Doces")
        listaCategoria.add(catergotia3)

        val catergotia4 = Categoria(R.drawable.ic_perfil_navbar, "Perfil")
        listaCategoria.add(catergotia4)
    }
}
