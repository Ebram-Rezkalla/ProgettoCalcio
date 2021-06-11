package Calcio.it.ProgettoProgrammazioneAdOggetti;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import filters.FilterCompetizione;
import filters.FilterGenerali;
import service.ServiceCalcio;

@RestController


public class calcioController {
	
	ServiceCalcio servicecalcio=new ServiceCalcio();



	@GetMapping("/Competizioni") 

	public ResponseEntity<Object> getall()  {
	return new ResponseEntity<>(servicecalcio.getall(),HttpStatus.OK);
	}
	
		
	
	
	@GetMapping("/Competizione") 

	public ResponseEntity<Object> getSpecificComp(@RequestParam (value="id", defaultValue="") String code) {
		return new ResponseEntity<>(servicecalcio.getSpecificComp(code),HttpStatus.OK);

	}
	
	
	@GetMapping("/Stats") 

	public ResponseEntity<Object> GetStats()  {
	return new ResponseEntity<>(servicecalcio.GetStats(),HttpStatus.OK);
	}
	
	@PostMapping("/Filter")
	public ResponseEntity<Object> GetFiltri(@RequestBody FilterGenerali filter) {
		return new ResponseEntity<>(servicecalcio.GetFiltri(filter),HttpStatus.OK);
	}
	
	
	@GetMapping("/StatsComp") 

	public ResponseEntity<Object> GetStatsComp(@RequestParam (value="id", defaultValue="") String code) {
	return new ResponseEntity<>(servicecalcio.GetStatsComp(code),HttpStatus.OK);
	}
	
	@PostMapping("/FilterComp")
	public ResponseEntity<Object> GetFiltriComp(@RequestBody FilterCompetizione filtercompetizioni) {
		return new ResponseEntity<>(servicecalcio.GetFiltriComp(filtercompetizioni),HttpStatus.OK);
	}
	
}
	