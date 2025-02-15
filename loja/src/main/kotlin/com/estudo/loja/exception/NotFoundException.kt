package com.estudo.loja.exception

class NotFoundException(override val message: String, val errorCode: String): Exception()