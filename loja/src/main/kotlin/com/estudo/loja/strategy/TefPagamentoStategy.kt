package com.estudo.loja.strategy

import com.estudo.loja.model.Pagamento
import com.estudo.loja.strategy.dto.PagamentoStrategy

class TefPagamentoStategy : PagamentoStrategy {
    override fun processarPagamento(request: Pagamento) {
        println("Processando pagamento via TEF: ${request.valorTotal}")
    }
}