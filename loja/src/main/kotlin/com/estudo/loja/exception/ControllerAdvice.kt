package com.estudo.loja.exception

import com.estudo.loja.controller.response.ErrorResponse
import com.estudo.loja.controller.response.FieldErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro =  ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            e.message,
            e.errorCode,
            null
        )
        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(e: MethodArgumentNotValidException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro =  ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            e.message,
            "p-0002",
            e.bindingResult.fieldErrors.map { FieldErrorResponse(it.defaultMessage ?: "invalid", it.field) }
        )
        return ResponseEntity(erro, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}