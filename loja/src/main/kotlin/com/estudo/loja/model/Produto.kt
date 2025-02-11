package com.estudo.loja.model

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import java.util.*

@DynamoDbBean
data class Produto(


    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("ID")
    var id: String = UUID.randomUUID().toString(),

    @get:DynamoDbAttribute("nome_produto")
    var nome: String? = null,

    @get:DynamoDbAttribute("preco")
    var valor: Double? = 0.0,

    @get:DynamoDbAttribute("marca")
    var marca: String? = null

    )
