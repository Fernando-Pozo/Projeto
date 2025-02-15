package com.estudo.loja.controller.response

class ErrorResponse (
    var message: String,
    var internalCode: String,
    var errors: List<FieldErrorResponse>?
)