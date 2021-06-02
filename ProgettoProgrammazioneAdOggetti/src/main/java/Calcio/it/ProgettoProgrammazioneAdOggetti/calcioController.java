package Calcio.it.ProgettoProgrammazioneAdOggetti;

import java.io.IOException;
import java.net.MalformedURLException;

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
	public ResponseEntity<Object> ParserStagioni() throws JSONException, MalformedURLException, IOException{
	return new ResponseEntity<>(parserdodo.ParserStagioni(),HttpStatus.OK);
	}}
	