package com.example.app_fateclanches.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_fateclanches.databinding.CategoriaItemBinding
import com.example.app_fateclanches.models.Categoria
import com.example.app_fateclanches.view.ComidasActivity

class CategoriaAdapter (private  val context: Context, private val listaCategoria: MutableList<Categoria>):
    RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val itemCategoria = CategoriaItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return CategoriaViewHolder(itemCategoria)
    }

    override fun getItemCount() = listaCategoria.size

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        holder.imgCategoria.setImageResource(listaCategoria[position].img!!)
        holder.txtCategoria.text = listaCategoria[position].nome

        holder.imgCategoria.setOnClickListener {
            val intent = Intent(context, ComidasActivity::class.java)
            intent.putExtra("categoria", listaCategoria[position].nome)
            context.startActivity(intent)
        }

    }



    inner class CategoriaViewHolder(binding: CategoriaItemBinding): RecyclerView.ViewHolder(binding.root){
        val imgCategoria = binding.imgCategoria
        val txtCategoria = binding.txtCategoria

    }
}


