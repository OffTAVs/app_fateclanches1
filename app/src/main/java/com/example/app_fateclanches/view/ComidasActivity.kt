package com.example.app_fateclanches.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_fateclanches.R
import com.example.app_fateclanches.adapter.LanchesAdapter
import com.example.app_fateclanches.api.UsuarioRetrofit
import com.example.app_fateclanches.models.Comida
import com.example.app_fateclanches.servico.ServicoUsuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComidasActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var categoria: String

    private lateinit var btnCarrinho: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comidas)

        val categoriaSelecionada = intent.getStringExtra("categoria") ?: "Lanches"

        recyclerView = findViewById(R.id.recyclerViewMenuLanches)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val api = UsuarioRetrofit.usuario.create(ServicoUsuario::class.java)

        api.listarProdutos().enqueue(object : Callback<List<Comida>> {
            override fun onResponse(call: Call<List<Comida>>, response: Response<List<Comida>>) {
                if (response.isSuccessful) {
                    val produtos = response.body()?.filter {
                        it.categoria.equals(categoriaSelecionada, ignoreCase = true)
                    } ?: emptyList()

                    recyclerView.adapter = LanchesAdapter(produtos)

                    if (produtos.isEmpty()) {
                        Toast.makeText(this@ComidasActivity, "Nenhum item encontrado na categoria $categoriaSelecionada", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@ComidasActivity, "Erro ao carregar produtos", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Comida>>, t: Throwable) {
                Toast.makeText(this@ComidasActivity, "Erro de rede: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

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
            startActivity(Intent(this, PerfilActivity::class.java).putExtra("categoria","Perfil"))
        }

        // Agora é seguro acessar os elementos do layout
        btnCarrinho = findViewById(R.id.btnCarrinho)
        btnCarrinho.setOnClickListener { novoProduto() }
    }
    private fun novoProduto() {
        val intent=Intent(this,CarrinhoActivity::class.java)
        startActivity(intent)
    }
}

