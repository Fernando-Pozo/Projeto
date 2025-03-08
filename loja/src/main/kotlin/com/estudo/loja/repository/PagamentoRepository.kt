package com.estudo.loja.repository

import com.estudo.loja.model.Pagamento
import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.springframework.stereotype.Repository

@Repository
class PagamentoRepository(private val dynamoDbTemplate: DynamoDbTemplate) {

    fun save(pagamento: Pagamento) {
        dynamoDbTemplate.save(pagamento)
    }

}