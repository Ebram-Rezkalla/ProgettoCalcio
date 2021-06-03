package Calcio.it.ProgettoProgrammazioneAdOggetti;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
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
	
	ParserJson parserdodo= new ParserJson();
	
	
	@GetMapping("/Hello") 
	public ResponseEntity<Object> ParserCompetizioni() throws MalformedURLException, JSONException, IOException, ParseException {
	return new ResponseEntity<>(parserdodo.ParserCompetizioni(),HttpStatus.OK);
	}
	
}
	