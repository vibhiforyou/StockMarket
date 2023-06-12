package com.example.userprofile.exception.handler;


import com.example.userprofile.exception.BadRequestException;
import com.example.userprofile.model.dto.ErrorDTO;
import com.example.userprofile.exception.NoDataFoundException;
import com.example.userprofile.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@SuppressWarnings("unused")
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorDTO response = new ErrorDTO(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleNoDataFoundException(NoDataFoundException exception) {
        ErrorDTO response = new ErrorDTO(HttpStatus.NO_CONTENT.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleBadRequestException(BadRequestException exception) {
        ErrorDTO response = new ErrorDTO(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
