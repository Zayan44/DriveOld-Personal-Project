package br.com.personalproject.siseventos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.personalproject.siseventos.exception.business.veiculo.VeiculoNaoEncontradoException;
import br.com.personalproject.siseventos.exception.errorresponse.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VeiculoNaoEncontradoException.class)
        public ResponseEntity<ErrorResponse> tratarVeiculo(VeiculoNaoEncontradoException ex, HttpServletRequest request) {
        
             return ResponseEntity
                     .status(HttpStatus.NOT_FOUND)
                     .body(new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), request.getRequestURI()));
        }
}