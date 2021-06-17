package Calcio.it.ProgettoProgrammazioneAdOggetti;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import exception.BodyException;
import exception.ExceptionModel;
import exception.NotFound;

//una classe che gestisce il lancio delle eccezioni chiamando la classe ExceptionModel
@ControllerAdvice

public class ExceptionHandlerCalcio {
	
	// gestione dell'eccezione NotFound
	@ExceptionHandler(value= {NotFound.class})
	
	public ResponseEntity <Object> handleidnotfound (NotFound e){
		
		ExceptionModel exceptionmodel =new ExceptionModel (e.getMessage(),HttpStatus.BAD_REQUEST,ZonedDateTime.now(ZoneId.of("Z")));
	return new ResponseEntity <>(exceptionmodel,HttpStatus.BAD_REQUEST);
	}
	
	// gestione dell'eccezione BodyException
	@ExceptionHandler(value= {BodyException.class})
	
	public ResponseEntity <Object> handlebodyexception (BodyException e){
		
		ExceptionModel exceptionmodel =new ExceptionModel (e.getMessage(),HttpStatus.BAD_REQUEST,ZonedDateTime.now(ZoneId.of("Z")));
	return new ResponseEntity <>(exceptionmodel,HttpStatus.BAD_REQUEST);
	}
	
	// gestione dell'eccezione HttpRequestMethodNotSupportedException
	// Questa eccezione e un overwrite dell’eccezione HttpRequestMethodNotSupportedException che viene lanciata quando e’ richiesto un metodo non consentito per una determinata rotta.
	
	@ExceptionHandler(value= {HttpRequestMethodNotSupportedException.class})
	
	public ResponseEntity <Object> handleJSONexception (HttpRequestMethodNotSupportedException e){
		
		ExceptionModel exceptionmodel =new ExceptionModel ("Metodo Non Consentito per Questa Rotta",HttpStatus.BAD_REQUEST,ZonedDateTime.now(ZoneId.of("Z")));
	return new ResponseEntity <>(exceptionmodel,HttpStatus.BAD_REQUEST);
	}
	
}
