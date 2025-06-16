
package com.example.app_fateclanches.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_fateclanches.databinding.ComidaItemBinding
import com.example.app_fateclanches.models.Comida
import retrofit2.Callback

import android.content.Context
import okhttp3.internal.wait

class ComidaAdapter(
    private val context: Context,
    private val listaCarrinho: MutableList<Comida>
) : RecyclerView.Adapter<ComidaAdapter.ComidaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidaViewHolder {
        val itemComida = ComidaItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ComidaViewHolder(itemComida)
    }

    override fun getItemCount() = listaCarrinho.size

    override fun onBindViewHolder(holder: ComidaViewHolder, position: Int) {
        holder.imgComida.setImageResource(listaCarrinho[position].imagem!!)
        holder.txtComida.text = this.listaCarrinho[position].nome


        // Aqui pode adicionar clique se quiser
        //holder.itemView.setOnClickListener { ... }
    }

    inner class ComidaViewHolder(binding: ComidaItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgComida = binding.imgProduto
        var txtComida = binding.txtTitulo
    }
}

