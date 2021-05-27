package Calcio.it.ProgettoProgrammazioneAdOggetti;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.HelloWorldClass;

@RestController


public class calcioController {
	@GetMapping("/Hello")
	
	public HelloWorldClass  exampleMethod(@RequestParam(name= "param1", defaultValue= "World")String param1) {
	return new HelloWorldClass ("Ad","Mancini");
	}
	
@PostMapping("/Ebram1")
	
	public HelloWorldClass  exampleMethod2(@RequestBody HelloWorldClass body) {
		return body;
}
}