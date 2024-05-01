package com.abhishek.ecommercebackendsystem.ExceptionHandler;

import com.abhishek.ecommercebackendsystem.Dtos.ExceptionDto;
import com.abhishek.ecommercebackendsystem.Exceptions.InvalidProductIdException;
import com.abhishek.ecommercebackendsystem.Exceptions.NoProductsFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(ArithmeticException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolution("Arithmetic Exception");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolution("ArrayIndexOutOfBoundsException");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolution("RuntimeException");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ExceptionDto> handleInvalidProductIdException(InvalidProductIdException invalidProductIdException){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Invalid Product Id " + invalidProductIdException.getId() + " passed.");
        exceptionDto.setResolution("ProductNotFoundException");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
    @ExceptionHandler(NoProductsFoundException.class)
    public ResponseEntity<ExceptionDto> handleNoProductsFoundException(NoProductsFoundException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something Went Wrong");
        exceptionDto.setResolution("NoProductsFoundException");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleGeneralException(Exception ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolution("GeneralException");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
