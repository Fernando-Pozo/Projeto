package com.estudo.loja.extension

import com.estudo.loja.controller.request.PostPagamentoRequest
import com.estudo.loja.controller.request.PostProdutoRequest
import com.estudo.loja.model.Pagamento
import com.estudo.loja.model.Produto


fun PostProdutoRequest.toProdutoModel(): Produto {
    return Produto(
        nome = this.nome,
        valor = this.valor,
        marca = this.marca
    )
}

fun PostPagamentoRequest.toPagamentoModel(): Pagamento {
    return Pagamento(
        tipo = this.tipo,
        valorTotal = this.valorTotal
    )
}