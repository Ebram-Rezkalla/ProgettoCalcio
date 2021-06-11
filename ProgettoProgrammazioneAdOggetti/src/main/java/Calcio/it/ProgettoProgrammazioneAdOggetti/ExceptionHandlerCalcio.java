package Calcio.it.ProgettoProgrammazioneAdOggetti;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import exception.BodyException;
import exception.ExceptionModel;
import exception.IdNotFound;

@ControllerAdvice
public class ExceptionHandlerCalcio {
	
	@ExceptionHandler(value= {IdNotFound.class})
	public ResponseEntity <Object> handleidnotfound (IdNotFound e){
		
		ExceptionModel exceptionmodel =new ExceptionModel (e.getMessage(),HttpStatus.BAD_REQUEST,ZonedDateTime.now(ZoneId.of("Z")));
	return new ResponseEntity <>(exceptionmodel,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value= {BodyException.class})
	public ResponseEntity <Object> handlebodyexception (BodyException e){
		
		ExceptionModel exceptionmodel =new ExceptionModel (e.getMessage(),HttpStatus.BAD_REQUEST,ZonedDateTime.now(ZoneId.of("Z")));
	return new ResponseEntity <>(exceptionmodel,HttpStatus.BAD_REQUEST);
	}
	

}
