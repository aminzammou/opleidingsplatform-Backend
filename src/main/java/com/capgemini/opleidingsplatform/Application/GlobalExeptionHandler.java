package com.capgemini.opleidingsplatform.Application;

import com.capgemini.opleidingsplatform.domain.exception.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
@ControllerAdvice
public class GlobalExeptionHandler {

//    @ExceptionHandler(UsernameNotFoundException.class)
//    public ResponseEntity<ExceptionResponse> usernameNotFound(UsernameNotFoundException ex) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setErrorCode("UNAUTHORIZED");
//        exceptionResponse.setErrorMessage(ex.getMessage());
//        exceptionResponse.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.UNAUTHORIZED);
//    }

//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<ExceptionResponse> AccessDeniedException(AccessDeniedException ex) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setErrorCode("FORBIDDEN");
//        exceptionResponse.setErrorMessage("You are not authorized!");
//        exceptionResponse.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.FORBIDDEN);
//    }


    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponse> CategoryNotFoundException(CategoryNotFoundException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setErrorCode("NOT FOUND");
        exceptionResponse.setErrorMessage(ex.getMessage());
        exceptionResponse.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
//
//    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
//    public ResponseEntity<ExceptionResponse> UserNotFoundException(UserNotFoundException ex) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setErrorCode("NOT FOUND");
//        exceptionResponse.setErrorMessage(ex.getMessage());
//        exceptionResponse.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(DuplicateKeyException.class)
//    public ResponseEntity<ExceptionResponse> AirportAlreadyExistsException(AirportAlreadyExistsException ex) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setErrorCode("CONFLICT");
//        exceptionResponse.setErrorMessage(ex.getMessage());
//        exceptionResponse.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.CONFLICT);
//    }
//
//    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
//    public ResponseEntity<ExceptionResponse> UserAlreadyExistsException(UserAlreadyExistsException ex) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setErrorCode("CONFLICT");
//        exceptionResponse.setErrorMessage(ex.getMessage());
//        exceptionResponse.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.CONFLICT);
//    }
//
//    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
//    public ResponseEntity<ExceptionResponse> RouteNotFoundException(RouteNotFoundException ex) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setErrorCode("NOT FOUND");
//        exceptionResponse.setErrorMessage(ex.getMessage());
//        exceptionResponse.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
//    public ResponseEntity<ExceptionResponse> PlaneNotFoundException(PlaneNotFoundException ex) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setErrorCode("NOT FOUND");
//        exceptionResponse.setErrorMessage(ex.getMessage());
//        exceptionResponse.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(DuplicateKeyException.class)
//    public ResponseEntity<ExceptionResponse> PlaneAlreadyExistsException(PlaneAlreadyExistsException ex) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setErrorCode("CONFLICT");
//        exceptionResponse.setErrorMessage(ex.getMessage());
//        exceptionResponse.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.CONFLICT);
//    }
//
//
//    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
//    public ResponseEntity<ExceptionResponse> FlightNotFoundException(FlightNotFoundException ex) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setErrorCode("NOT FOUND");
//        exceptionResponse.setErrorMessage(ex.getMessage());
//        exceptionResponse.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(DuplicateKeyException.class)
//    public ResponseEntity<ExceptionResponse> FlightAlreadyExistsException(FlightAlreadyExistsException ex) {
//        ExceptionResponse exceptionResponse = new ExceptionResponse();
//        exceptionResponse.setErrorCode("CONFLICT");
//        exceptionResponse.setErrorMessage(ex.getMessage());
//        exceptionResponse.setTimestamp(LocalDateTime.now());
//
//        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.CONFLICT);
//    }


}