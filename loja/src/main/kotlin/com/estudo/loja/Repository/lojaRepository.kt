package com.estudo.loja.Repository

import com.estudo.loja.model.Produto
import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.Key

@Repository
class lojaRepository(private val dynamoDbTemplate: DynamoDbTemplate) {

    fun findById(id: String): Produto? {
        return dynamoDbTemplate.load(
            Key.builder()
                .partitionValue(id)
                .build(), Produto::class.java
        )
    }

    fun salvar(produto: Produto) {
        dynamoDbTemplate.save(produto)
    }

    fun delete(produto: Produto) {
        dynamoDbTemplate.delete(produto)
    }

}