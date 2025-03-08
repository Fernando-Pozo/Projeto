package com.estudo.loja.controller.request

import com.estudo.loja.strategy.PagamentoTipo
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

class PostPagamentoRequest (

    @field:NotNull
    val tipo: PagamentoTipo,

    @field:Min(value = 0)
    val valorTotal: Double
)