package com.estudo.loja.repository

import com.estudo.loja.model.Produto
import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.Key

@Repository
class LojaRepository(private val dynamoDbTemplate: DynamoDbTemplate) {

    fun findById(id: String): Produto? {
        return dynamoDbTemplate.load(
            Key.builder()
                .partitionValue(id)
                .build(), Produto::class.java
        )
    }

    fun save(product: Produto) {
        dynamoDbTemplate.save(product)
    }

    fun delete(id: String) {
        val product = Produto().apply { this.id = id }
        dynamoDbTemplate.delete(product)
    }

}