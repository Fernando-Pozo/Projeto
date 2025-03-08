package com.estudo.loja.strategy

import com.estudo.loja.model.Pagamento
import com.estudo.loja.strategy.dto.PagamentoStrategy

class CartaoPagamentoStategy : PagamentoStrategy {
    override fun processarPagamento(request: Pagamento) {
        println("Processando pagamento via CARTÃO: ${request.valorTotal}")
    }
}