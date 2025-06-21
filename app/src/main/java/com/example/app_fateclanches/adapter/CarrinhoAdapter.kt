package com.example.app_fateclanches.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app_fateclanches.R
import com.example.app_fateclanches.models.ItemCarrinho
import com.example.app_fateclanches.util.CarrinhoManager

class CarrinhoAdapter(
    private val itens: MutableList<ItemCarrinho>,
    private val onItemRemovido: () -> Unit
) : RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder>() {

    inner class CarrinhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.txtNome)
        val preco: TextView = itemView.findViewById(R.id.txtPreco)
        val quantidade: TextView = itemView.findViewById(R.id.txtQuantidade)
        val imagem: ImageView = itemView.findViewById(R.id.imgProduto)
        val btnRemover: ImageButton = itemView.findViewById(R.id.btnRemover)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrinhoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comida_item, parent, false)
        return CarrinhoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarrinhoViewHolder, position: Int) {
        val item = itens[position]
        holder.nome.text = item.comida.nome
        holder.preco.text = "R$ %.2f".format(item.comida.preco * item.quantidade)
        holder.quantidade.text = "Qtd: ${item.quantidade}"

        Glide.with(holder.itemView.context)
            .load(item.comida.imagemUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imagem)

        holder.btnRemover.setOnClickListener {
            CarrinhoManager.removerItem(item)
            itens.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itens.size)
            onItemRemovido() // Atualiza total
        }
    }

    override fun getItemCount(): Int = itens.size
}
