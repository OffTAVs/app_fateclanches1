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
import com.example.app_fateclanches.models.Comida
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/*
class CarrinhoActivity : AppCompatActivity() {
    var listaComida:ArrayList<Comida> = ArrayList() //alterei String para contato

    lateinit var listComida:RecyclerView
    lateinit var btnProximo:ImageButton

    fun carregaContatos(){
        val cliente = ClienteRetrofit.cliente.create(ServicoContatos::class.java)
        cliente.getContatos().enqueue( object:Callback<List<Contato>>{
            override fun onResponse(call: Call<List<Contato>>, response: Response<List<Contato>>) {
                if(response.isSuccessful){
                    listaContatos = response.body() as ArrayList<Contato>
                    val adapter = ContatoAdapter(listaContatos)
                    listContatos.adapter = adapter
                    listContatos.layoutManager = LinearLayoutManager(this@MainActivity)
                }
                else{
                    Log.e("Erro ao carregar",response.message())
                }
            }

            override fun onFailure(call: Call<List<Contato>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        } )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listContatos = findViewById(R.id.listContatos)
        btnNovoContato = findViewById(R.id.btnNovoContato)
        btnNovoContato.setOnClickListener { novoContato() }

    }

    override fun onResume() {
        super.onResume()
        carregaContatos()
    }

    private fun novoContato() {
        val intent=Intent(this,FormContatoActivity::class.java)
        startActivity(intent)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        val adapter:ContatoAdapter = listContatos.adapter as ContatoAdapter

        val contato = listaContatos.get(adapter.posicaoClicada)

        if(item.itemId == R.id.menu_mapa){
            val uri = Uri.parse("geo:0,0?q="+contato.endereco+"&z=18")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }
        else if(item.itemId == R.id.menu_telefone){
            val uri = Uri.parse("tel:"+contato.telefone)
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }
        else if(item.itemId == R.id.menu_email){
            val uri = Uri.parse("mailto:"+contato.email)
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }
        else if(item.itemId == R.id.menu_excluir){
            val cliente = ClienteRetrofit.cliente.create(ServicoContatos::class.java)
            cliente.excluiContato(contato._id!!).enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful){
                        carregaContatos()
                    } else {
                        Log.e("Erro na requisição", "onResponse: " + response.message())
                        Toast.makeText(this@MainActivity, "Falha ao Excluir", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Falha na requisição", Toast.LENGTH_LONG).show()
                }
            })
        }

        else if(item.itemId == R.id.menu_editar){
            val intent:Intent = Intent(this, FormContatoActivity::class.java)
            intent.putExtra("contato", contato)
            startActivity(intent)
        }


        return true
    }
}

 */