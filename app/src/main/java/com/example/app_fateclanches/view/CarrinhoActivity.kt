package com.example.app_fateclanches.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_fateclanches.R
import com.example.app_fateclanches.adapter.CarrinhoAdapter
import com.example.app_fateclanches.api.UsuarioRetrofit
import com.example.app_fateclanches.models.Comida
import com.example.app_fateclanches.servico.ServicoUsuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarrinhoActivity : AppCompatActivity() {

    private lateinit var recyclerViewComida: RecyclerView
    private var listaCarrinho: ArrayList<Comida> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        recyclerViewComida = findViewById(R.id.recyclerViewComidas)
        recyclerViewComida.layoutManager = LinearLayoutManager(this)

        carregaCarrinho()
    }

    private fun carregaCarrinho() {
        val lanche = UsuarioRetrofit.usuario.create(ServicoUsuario::class.java)
        lanche.getLanche().enqueue(object : Callback<List<Comida>> {
            override fun onResponse(call: Call<List<Comida>>, response: Response<List<Comida>>) {
                if (response.isSuccessful) {
                    listaCarrinho = response.body() as ArrayList<Comida>
                    recyclerViewComida.adapter = CarrinhoAdapter(this@CarrinhoActivity, listaCarrinho)
                    recyclerViewComida.layoutManager = LinearLayoutManager(this@CarrinhoActivity)
                } else {
                    Log.e("Erro ao carregar", response.message())
                }
            }

            override fun onFailure(call: Call<List<Comida>>, t: Throwable) {
                Log.e("Erro Retrofit", t.message ?: "Erro desconhecido")
            }
        })
    }
}
