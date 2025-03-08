package com.estudo.loja.strategy.dto

import com.estudo.loja.model.Pagamento

interface PagamentoStrategy {
    fun processarPagamento(request: Pagamento)
}