package com.estudo.loja.controller

import com.estudo.loja.controller.request.PostPagamentoRequest
import com.estudo.loja.extension.toPagamentoModel
import com.estudo.loja.service.PagamentoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pagamento")
class PaymentController(
    private val pagamentoService: PagamentoService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun processarPagamento(@RequestBody @Valid request: PostPagamentoRequest) {
        pagamentoService.processar(request.toPagamentoModel())
    }
}