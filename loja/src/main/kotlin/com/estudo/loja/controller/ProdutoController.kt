package com.estudo.loja.controller

import com.estudo.loja.model.PrecoDto
import com.estudo.loja.model.Produto
import com.estudo.loja.service.ProdutoService
import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/produtos")
class ProdutoController(
    @Qualifier("dynamoDbTemplate") private val dynamoDbTemplate: DynamoDbTemplate,
    private val produtoService: ProdutoService
) {

//    @GetMapping("/{id}")
//    fun getByIdQuery(@PathVariable("id") id: String): ResponseEntity<Produto> {
//
//        val query = QueryEnhancedRequest.builder()
//            .queryConditional(QueryConditional.keyEqualTo(Key.builder().partitionValue(id).build()))
//            .build()
//
//        val resultados = dynamoDbTemplate.query(query, Produto::class.java)
//
//        val produto = resultados.items().firstOrNull()
//
//        return produto?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
//    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: String): ResponseEntity<Produto> {

        val produto = produtoService.getProdutoById(id)

        return produto?.let { ResponseEntity.ok(produto) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun addProduto(@RequestBody produto: Produto): ResponseEntity<Produto> {
        produtoService.salvarProduto(produto)
        return ResponseEntity.ok(produto)
    }

    @PutMapping("/{id}")
    fun PutById(@PathVariable("id") id: String, @RequestBody precoDto: PrecoDto): ResponseEntity<Void>{
        var produto = produtoService.getProdutoById(id)

        if (produto == null){
            return ResponseEntity.notFound().build()
        }

        produto.valor = precoDto.valor
        produtoService.salvarProduto(produto)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    fun DeleteById(@PathVariable("id") id: String): ResponseEntity<Void>{
        var produto = produtoService.getProdutoById(id)

        if (produto == null){
            return ResponseEntity.notFound().build()
        }

        produtoService.deleteProduto(produto)
        return ResponseEntity.noContent().build()
    }

}