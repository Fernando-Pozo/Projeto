package com.estudo.loja.service

import com.estudo.loja.controller.request.PatchPrecoDto
import com.estudo.loja.controller.request.PostProdutoRequest
import com.estudo.loja.model.Produto
import com.estudo.loja.repository.LojaRepository
import org.springframework.stereotype.Service

@Service
class ProdutoService(private val repo: LojaRepository) {

    fun getProductById(id: String): Produto? {
        return repo.findById(id)
    }

    fun saveProduct(product: Produto) {
        return repo.save(product)
    }

    fun updateProductPrice(id: String, precoDto: PatchPrecoDto): Produto? {
        val product = getProductById(id) ?: return null
        product.valor = precoDto.valor
        saveProduct(product)
        return product
    }

    fun deleteProduct(id: String) {
        return repo.delete(id)
    }

}