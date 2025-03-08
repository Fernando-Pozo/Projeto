package com.estudo.loja.model

import com.estudo.loja.strategy.PagamentoTipo
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import java.util.*

@DynamoDbBean
data class Pagamento (

    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("ID")
    var id: String = UUID.randomUUID().toString(),

    @get:DynamoDbAttribute("tipo")
    var tipo: PagamentoTipo? = null,

    @get:DynamoDbAttribute("valorTotal")
    var valorTotal: Double? = 0.0
)