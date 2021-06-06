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
import service.ServiceCalcio;
import stats.StatsGenerali;

@RestController


public class calcioController {
	
	ServiceCalcio servicecalcio=new ServiceCalcio();
	StatsGenerali statsgenerali= new StatsGenerali();
	
	@GetMapping("/Competizioni") 

	public ResponseEntity<Object> getall() throws MalformedURLException, JSONException, IOException, ParseException {
	return new ResponseEntity<>(servicecalcio.getall(),HttpStatus.OK);
	}
	
	@GetMapping("/Competizione") 

	public ResponseEntity<Object> getSpecificComp(@RequestParam (value="id", defaultValue="") String code) throws MalformedURLException, JSONException, IOException, ParseException {
	return new ResponseEntity<>(servicecalcio.getSpecificComp(code),HttpStatus.OK);
	}
	
	
	@GetMapping("/Stats") 

	public ResponseEntity<Object> MediaDurataGiorni(@RequestParam (value="tipo", defaultValue="")String tipo) throws MalformedURLException, JSONException, IOException, ParseException, java.text.ParseException {
	return new ResponseEntity<>(statsgenerali.MediaDurataGiorni(tipo),HttpStatus.OK);
	}
	
}
	