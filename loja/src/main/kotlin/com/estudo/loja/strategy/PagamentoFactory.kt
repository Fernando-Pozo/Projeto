package com.estudo.loja.strategy

import com.estudo.loja.strategy.dto.PagamentoStrategy

object PagamentoFactory {
    fun getPagamentoFactory(tipo: PagamentoTipo): PagamentoStrategy {
        return when(tipo) {
            PagamentoTipo.CARTAO -> CartaoPagamentoStategy()
            PagamentoTipo.BOLETO -> BoletoPagamentoStategy()
            PagamentoTipo.TEF -> TefPagamentoStategy()
            else -> throw IllegalArgumentException("Tipo de pagamento inválido: $tipo")
        }
    }
}