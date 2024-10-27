package com.gabriel.hamburgueria.exception

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.client.HttpServerErrorException.InternalServerError
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun handleInternalServerErrorException(ex: InternalServerError): ResponseEntity<ExceptionMessage> {
        val messageException = ExceptionMessage(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.message
        )
        return ResponseEntity(messageException, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler
    fun handleNoSuchElementException(ex: NoSuchElementException): ResponseEntity<ExceptionMessage> {
        val messageException = ExceptionMessage(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )
        return ResponseEntity(messageException, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleRuntimeException(ex: RuntimeException): ResponseEntity<ExceptionMessage> {
        val messageException = ExceptionMessage(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )
        return ResponseEntity(messageException, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleRuntimeException(ex: AlimentoNotFoundException): ResponseEntity<ExceptionMessage> {
        val messageException = ExceptionMessage(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(messageException, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionMessage> {
        val erros =  ex.bindingResult.allErrors.map { error ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.getDefaultMessage()
            val message = "$fieldName - $errorMessage"
            message
        }
        val messageException = ExceptionMessage(
            HttpStatus.BAD_REQUEST.value(),
            erros.toString()
        )
        return ResponseEntity(messageException, HttpStatus.BAD_REQUEST)
    }
}