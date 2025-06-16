package com.example.app_fateclanches.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.app_fateclanches.R
import com.example.app_fateclanches.adapter.CategoriaAdapter
import com.example.app_fateclanches.databinding.ActivityCarrinhoBinding
import com.example.app_fateclanches.databinding.ActivityHomeBinding
import com.example.app_fateclanches.models.Categoria

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var categoriaAdapter: CategoriaAdapter
    private val listaCategoria: MutableList<Categoria> = mutableListOf()

    private lateinit var btnCarrinho:ImageButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Inicializa o ViewBinding e carrega o layout
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Agora é seguro acessar os elementos do layout
        btnCarrinho = findViewById(R.id.btnCarrinho)
        btnCarrinho.setOnClickListener { novoProduto() }

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        val recyclerViewCategorias = binding.recyclerViewCategorias
        recyclerViewCategorias.layoutManager = GridLayoutManager(this, 2)
        categoriaAdapter = CategoriaAdapter(this, listaCategoria)
        recyclerViewCategorias.setHasFixedSize(true)
        recyclerViewCategorias.adapter = categoriaAdapter

        getCategorias()



        /*

        findViewById<ImageView>(R.id.nav_lanches).setOnClickListener {
            startActivity(Intent(this, ComidaActivity::class.java).putExtra("categoria", "Lanches"))
        }

        findViewById<ImageView>(R.id.nav_bebidas).setOnClickListener {
            startActivity(Intent(this, ComidasActivity::class.java).putExtra("categoria", "Bebidas"))
        }

        findViewById<ImageView>(R.id.nav_bomboniere).setOnClickListener {
            startActivity(Intent(this, ComidasActivity::class.java).putExtra("categoria", "Bomboniere"))
        }

        findViewById<ImageView>(R.id.nav_perfil).setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }
*/

    }

    private fun novoProduto() {
        val intent=Intent(this,CarrinhoActivity::class.java)
        startActivity(intent)
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
