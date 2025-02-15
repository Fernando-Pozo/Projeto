package com.estudo.loja.controller

import com.estudo.loja.controller.request.PatchPrecoDto
import com.estudo.loja.controller.request.PostProdutoRequest
import com.estudo.loja.extension.toProdutoModel
import com.estudo.loja.model.Produto
import com.estudo.loja.service.ProdutoService
import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/produtos")
class ProdutoController(
    @Qualifier("dynamoDbTemplate") private val dynamoDbTemplate: DynamoDbTemplate,
    private val produtoService: ProdutoService
) {

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: String): ResponseEntity<Produto> {
        val product = produtoService.getProductById(id)
        return product?.let { ResponseEntity.ok(product) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addProduto(@RequestBody produto: PostProdutoRequest) {
        produtoService.saveProduct(produto.toProdutoModel())
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun patchById(@PathVariable("id") id: String, @RequestBody precoDto: PatchPrecoDto){
        produtoService.updateProductPrice(id, precoDto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable("id") id: String){
        produtoService.deleteProduct(id)
    }

}