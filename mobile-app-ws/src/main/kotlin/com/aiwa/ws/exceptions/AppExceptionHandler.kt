package com.aiwa.ws.exceptions

import com.aiwa.ws.exceptions.service.UserServiceException
import com.aiwa.ws.model.error.ErrorMessageModel
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class AppExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [Exception::class])
    fun handleAnyException(ex: Exception, req: WebRequest): ResponseEntity<Any> {
        return ResponseEntity(
                ErrorMessageModel(Date(), ex.localizedMessage),
                HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    // Customized Exceptions call

    @ExceptionHandler(value = [NullPointerException::class, UserServiceException::class])
    fun handleUserServiceException(ex: Exception, req: WebRequest): ResponseEntity<Any> {
        return ResponseEntity(
                ErrorMessageModel(Date(), ex.localizedMessage),
                HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

}