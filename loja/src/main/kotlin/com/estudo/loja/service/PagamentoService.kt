package com.estudo.loja.service

import com.estudo.loja.model.Pagamento
import com.estudo.loja.repository.PagamentoRepository
import com.estudo.loja.strategy.PagamentoFactory
import org.springframework.stereotype.Service

@Service
class PagamentoService(private val repository: PagamentoRepository){

    fun processar(request: Pagamento){
        val tipoPagamento = request.tipo ?: throw IllegalArgumentException("O tipo de pagamento não pode ser nulo.")
        val strategy = PagamentoFactory.getPagamentoFactory(tipoPagamento)
        strategy.processarPagamento(request)
        repository.save(request)
    }

}