package com.example.onlinelms.usermanagement.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.onlinelms.usermanagement.exception.ErrorInfo;
import com.example.onlinelms.usermanagement.exception.UserException;

@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception exception){
		ErrorInfo errorInfo= new ErrorInfo();
		errorInfo.setErrorMessage("user Exception");
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(errorInfo,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorInfo> userExceptionHandler(UserException exception){
		ErrorInfo errorInfo= new ErrorInfo();
		errorInfo.setErrorMessage("user Exception");
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(errorInfo,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception){
		ErrorInfo errorInfo= new ErrorInfo();
		errorInfo.setErrorMessage("user Exception");
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(errorInfo,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
