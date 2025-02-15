package com.estudo.loja.extension

import com.estudo.loja.controller.request.PostProdutoRequest
import com.estudo.loja.model.Produto


fun PostProdutoRequest.toProdutoModel(): Produto {
    return Produto(
        nome = this.nome,
        valor = this.valor,
        marca = this.marca
    )
}
