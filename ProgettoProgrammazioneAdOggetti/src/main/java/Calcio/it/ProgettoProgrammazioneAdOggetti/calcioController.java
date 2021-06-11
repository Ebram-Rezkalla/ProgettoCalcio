package Calcio.it.ProgettoProgrammazioneAdOggetti;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exception.IdNotFound;
import filters.FilterCompetizione;
import filters.FilterGenerali;
import service.ServiceCalcio;

@RestController


public class calcioController {
	
	ServiceCalcio servicecalcio=new ServiceCalcio();



	@GetMapping("/Competizioni") 

	public ResponseEntity<Object> getall() throws Exception {
	return new ResponseEntity<>(servicecalcio.getall(),HttpStatus.OK);
	}
	
		
	
	
	@GetMapping("/Competizione") 

	public ResponseEntity<Object> getSpecificComp(@RequestParam (value="id", defaultValue="") String code) {
		return new ResponseEntity<>(servicecalcio.getSpecificComp(code),HttpStatus.OK);

	}
	
	
	@GetMapping("/Stats") 

	public ResponseEntity<Object> GetStats() throws Exception {
	return new ResponseEntity<>(servicecalcio.GetStats(),HttpStatus.OK);
	}
	
	@PostMapping("/Filter")
	public ResponseEntity<Object> GetFiltri(@RequestBody FilterGenerali filter) throws MalformedURLException, JSONException, IOException, ParseException, java.text.ParseException, com.sun.el.parser.ParseException {
		return new ResponseEntity<>(servicecalcio.GetFiltri(filter),HttpStatus.OK);
	}
	
	
	@GetMapping("/StatsComp") 

	public ResponseEntity<Object> GetStatsComp(@RequestParam (value="id", defaultValue="") String code) throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound {
	return new ResponseEntity<>(servicecalcio.GetStatsComp(code),HttpStatus.OK);
	}
	
	@PostMapping("/FilterComp")
	public ResponseEntity<Object> GetFiltriComp(@RequestBody FilterCompetizione filtercompetizioni) throws MalformedURLException, JSONException, IOException, ParseException, java.text.ParseException, com.sun.el.parser.ParseException, IdNotFound {
		return new ResponseEntity<>(servicecalcio.GetFiltriComp(filtercompetizioni),HttpStatus.OK);
	}
	
	/*@GetMapping ("error")
	
	public ResponseEntity <Object> errorGet() throw WorngRequest {
		throw new WrongRequest()
	}*/
	
	
		
		

}
	