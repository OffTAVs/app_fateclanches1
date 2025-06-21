package com.example.app_fateclanches.view

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_fateclanches.R
import com.example.app_fateclanches.adapter.CarrinhoAdapter
import com.example.app_fateclanches.util.CarrinhoManager

class CarrinhoActivity : AppCompatActivity() {

    private lateinit var recyclerViewComida: RecyclerView
    private lateinit var totalTextView: TextView
    private lateinit var adapter: CarrinhoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        recyclerViewComida = findViewById(R.id.recyclerViewComidas)
        totalTextView = findViewById(R.id.txtTotal)

        recyclerViewComida.layoutManager = LinearLayoutManager(this)
        adapter = CarrinhoAdapter(CarrinhoManager.itensCarrinho.toMutableList()) {
            calcularTotal()
        }
        recyclerViewComida.adapter = adapter

        calcularTotal()

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

        val spinnerPagamento = findViewById<Spinner>(R.id.spinnerPagamento)
        val btnProximo = findViewById<Button>(R.id.btnProximo)

// Lista de métodos de pagamento
        val metodosPagamento = listOf("Selecione", "Pix", "Cartão de Crédito", "Cartão de Débito", "Dinheiro")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, metodosPagamento)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPagamento.adapter = adapter

        btnProximo.setOnClickListener {
            val metodoSelecionado = spinnerPagamento.selectedItem.toString()

            if (metodoSelecionado == "Selecione") {
                Toast.makeText(this, "Escolha um método de pagamento", Toast.LENGTH_SHORT).show()
            } else if (CarrinhoManager.itensCarrinho.isEmpty()) {
                Toast.makeText(this, "Seu carrinho está vazio", Toast.LENGTH_SHORT).show()
            } else {
                // Aqui você pode enviar para o backend, ou abrir tela de confirmação
                Toast.makeText(this, "Pagamento com $metodoSelecionado confirmado!", Toast.LENGTH_LONG).show()

                // Limpar o carrinho
                CarrinhoManager.itensCarrinho.clear()
              //  finish() // direcionara para a página de método de pagamento
            }
        }

    }

    private fun calcularTotal() {
        val total = CarrinhoManager.itensCarrinho.sumOf { it.comida.preco * it.quantidade }
        totalTextView.text = "Total: R$ %.2f".format(total)
    }
}
