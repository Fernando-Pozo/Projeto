package com.estudo.loja.service

import com.estudo.loja.repository.lojaRepository
import com.estudo.loja.model.Produto
import org.springframework.stereotype.Service

@Service
class ProdutoService(private val repo: lojaRepository) {

    fun getProdutoById(id: String): Produto? {
        return repo.findById(id)
    }

    fun salvarProduto(produto: Produto) {
        return repo.salvar(produto)
    }

    fun deleteProduto(produto: Produto) {
        return repo.delete(produto)
    }

}