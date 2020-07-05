package com.wipro.assetmanager.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // Share methods across multiple controller classes
@RestController // Provides a response back
public class ErrorController extends ResponseEntityExceptionHandler {

	/*
	 * @ExceptionHandler(UserNotFoundException.class) public final
	 * ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,
	 * WebRequest request) { ExceptionResponse exceptionResponse = new
	 * ExceptionResponse(new Date(), ex.getMessage(),
	 * request.getDescription(false)); return new ResponseEntity(exceptionResponse,
	 * HttpStatus.NOT_FOUND); }
	 */
	//Handle all exceptions
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}


	/*@ExceptionHandler(GenericException.class)
	public final String handleGenericException(GenericException ex, WebRequest request){
		return ex.getMessage();
	}*/

	@ExceptionHandler(value = {GenericException.class})
	public ModelAndView handleAllGenericException(GenericException ex, 
			WebRequest request) {
		ModelAndView model = new ModelAndView();
		//model.addObject("exception", ex);
		//model.addObject("url", req.getRequestURL());
		model.addObject("errorMessage", ex.getMessage());
		model.setViewName(ex.getViewName());
		return model;
	}

}
