package com.estudo.loja.controller.request

import jakarta.validation.constraints.Min

class PatchPrecoDto (

    @field:Min(value = 0)
    val valor: Double
)