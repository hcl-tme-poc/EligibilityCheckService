package com.poc.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages={"com.accountmanagement.api"})
public class ApiValidationExceptionHandler extends ResponseEntityExceptionHandler {

	 @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	            MethodArgumentNotValidException ex,
	            HttpHeaders headers, 
	            HttpStatus status,
	            WebRequest request
	    ) {
	        BindingResult bindingResult = ex
	                .getBindingResult();

	        List<ValidationError> allErrors = new ArrayList<ValidationError>();
			for (ObjectError error :bindingResult.getAllErrors()){
				ValidationError valError = new ValidationError();
				valError.setErrorCode(error.getCode());
				valError.setMessage(error.getDefaultMessage());	
				allErrors.add(valError);
			}


	        return new ResponseEntity<>(allErrors, HttpStatus.UNPROCESSABLE_ENTITY);
	    }
}
