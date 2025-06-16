package com.example.app_fateclanches.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_fateclanches.R
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_fateclanches.adapter.ComidaAdapter
import com.example.app_fateclanches.api.UsuarioRetrofit
import com.example.app_fateclanches.models.Comida
import com.example.app_fateclanches.servico.ServicoUsuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarrinhoActivity : AppCompatActivity() {
    /*

    var listaComida: ArrayList<Comida> = ArrayList()

    private lateinit var listaComida: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun carregaComidas() {
            val comida = UsuarioRetrofit.usuario.create(ServicoUsuario::class.java)
            comida.getComida().enqueue(object : Callback<List<Comida>> {
                override fun onResponse(
                    call: Call<List<Comida>>,
                    response: Response<List<Comida>>
                ) {
                    if (response.isSuccessful) {
                        listaComida = response.body() as ArrayList<Comida>
                        val adapter = ComidaAdapter(listaComida)
                        listComida.adapter = adapter
                        listComida.layoutManager = LinearLayoutManager(this@CarrinhoActivity)
                    } else {
                        Log.e("Erro ao carregar", response.message())
                    }
                }

                override fun onFailure(call: Call<List<Comida>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}
*/
}