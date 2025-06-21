package com.example.app_fateclanches.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app_fateclanches.R
import com.example.app_fateclanches.models.Comida
import com.example.app_fateclanches.models.ItemCarrinho
import com.example.app_fateclanches.util.CarrinhoManager

class LanchesAdapter(private val lista: List<Comida>) :
    RecyclerView.Adapter<LanchesAdapter.ProdutoViewHolder>() {

    class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome = itemView.findViewById<TextView>(R.id.txtNome)
        val preco = itemView.findViewById<TextView>(R.id.txtPreco)
        val imagem = itemView.findViewById<ImageView>(R.id.imgProduto)
        val btnMenos = itemView.findViewById<Button>(R.id.btnMenos)
        val btnMais = itemView.findViewById<Button>(R.id.btnMais)
        val txtQuantidade = itemView.findViewById<TextView>(R.id.txtQuantidade)
        val btnAdicionar = itemView.findViewById<Button>(R.id.btnAdicionar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_comidas, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = lista[position]
        holder.nome.text = produto.nome
        holder.preco.text = "R$ %.2f".format(produto.preco)

        Glide.with(holder.itemView.context)
            .load(produto.imagemUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imagem)

        var quantidade = 0
        holder.txtQuantidade.text = quantidade.toString()

        holder.btnMais.setOnClickListener {
            quantidade++
            holder.txtQuantidade.text = quantidade.toString()
        }

        holder.btnMenos.setOnClickListener {
            if (quantidade > 0) {
                quantidade--
                holder.txtQuantidade.text = quantidade.toString()
            }
        }

        holder.btnAdicionar.setOnClickListener {
            if (quantidade > 0) {
                CarrinhoManager.adicionarItem(ItemCarrinho(produto, quantidade))
                Toast.makeText(
                    holder.itemView.context,
                    "${produto.nome} adicionado ao carrinho",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    holder.itemView.context,
                    "Selecione uma quantidade",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun getItemCount() = lista.size
}
