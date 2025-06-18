package com.example.app_fateclanches.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_fateclanches.R
import com.example.app_fateclanches.models.Comida
import com.bumptech.glide.Glide // Importe o Glide

class LanchesAdapter(private val lista: List<Comida>) :
    RecyclerView.Adapter<LanchesAdapter.ProdutoViewHolder>() {

    class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome = itemView.findViewById<TextView>(R.id.txtNome)
        val preco = itemView.findViewById<TextView>(R.id.txtPreco)
        val imagem = itemView.findViewById<ImageView>(R.id.imgProduto)
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

        // Se a imagem vier por URL, carregue com Glide
        Glide.with(holder.itemView.context)
            .load(produto.imagemUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imagem)
    }

    override fun getItemCount() = lista.size
}
