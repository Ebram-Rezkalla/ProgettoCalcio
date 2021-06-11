package Calcio.it.ProgettoProgrammazioneAdOggetti;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sun.el.parser.ParseException;

import exception.BodyException;
import exception.ExceptionModel;
import exception.NotFound;

@ControllerAdvice
public class ExceptionHandlerCalcio {
	
	@ExceptionHandler(value= {NotFound.class})
	public ResponseEntity <Object> handleidnotfound (NotFound e){
		
		ExceptionModel exceptionmodel =new ExceptionModel (e.getMessage(),HttpStatus.BAD_REQUEST,ZonedDateTime.now(ZoneId.of("Z")));
	return new ResponseEntity <>(exceptionmodel,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value= {BodyException.class})
	public ResponseEntity <Object> handlebodyexception (BodyException e){
		
		ExceptionModel exceptionmodel =new ExceptionModel (e.getMessage(),HttpStatus.BAD_REQUEST,ZonedDateTime.now(ZoneId.of("Z")));
	return new ResponseEntity <>(exceptionmodel,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value= {HttpRequestMethodNotSupportedException.class})
	public ResponseEntity <Object> handleJSONexception (HttpRequestMethodNotSupportedException e){
		
		ExceptionModel exceptionmodel =new ExceptionModel ("Metodo Non Consentito per Questa Rotta",HttpStatus.BAD_REQUEST,ZonedDateTime.now(ZoneId.of("Z")));
	return new ResponseEntity <>(exceptionmodel,HttpStatus.BAD_REQUEST);
	}
	
}
