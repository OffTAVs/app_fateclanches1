package com.example.app_fateclanches.util

import com.example.app_fateclanches.models.ItemCarrinho

object CarrinhoManager {
    val itensCarrinho = mutableListOf<ItemCarrinho>()

    fun adicionarItem(item: ItemCarrinho) {
        val existente = itensCarrinho.find { it.comida.nome == item.comida.nome }
        if (existente != null) {
            existente.quantidade += item.quantidade
        } else {
            itensCarrinho.add(item)
        }
    }

    fun removerItem(item: ItemCarrinho) {
        itensCarrinho.remove(item)
    }

    fun limparCarrinho() {
        itensCarrinho.clear()
    }
}