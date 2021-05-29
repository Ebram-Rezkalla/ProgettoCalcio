package Calcio.it.ProgettoProgrammazioneAdOggetti;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ParserJson;

@RestController


public class calcioController {
	
	ParserJson parserdodo= new ParserJson("https://api.football-data.org/v2/competitions/2019");
	
	
	@GetMapping("/Hello") 
	public ResponseEntity<Object> ChiamataAPI(){
	return new ResponseEntity<>(parserdodo.ChiamtaAPI(),HttpStatus.OK);
	}
	
}