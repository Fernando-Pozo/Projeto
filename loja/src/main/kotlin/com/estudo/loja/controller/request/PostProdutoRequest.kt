package com.estudo.loja.controller.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

class PostProdutoRequest (

    @field:NotEmpty
    @field:Size(max = 50)
    val nome: String,

    @field:Min(value = 0)
    val valor: Double,

    @field:NotEmpty
    val marca: String
)