package com.example.app_fateclanches.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_fateclanches.databinding.CategoriaItemBinding
import com.example.app_fateclanches.models.Categoria

class CategoriaAdapter (private  val context: Context, private val listaContato: MutableList<Categoria>):
    RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>() {

    inner class CategoriaViewHolder(binding: CategoriaItemBinding): RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}


