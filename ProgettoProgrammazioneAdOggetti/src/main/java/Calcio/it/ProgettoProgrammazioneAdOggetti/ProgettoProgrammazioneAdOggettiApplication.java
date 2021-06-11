package Calcio.it.ProgettoProgrammazioneAdOggetti;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import service.APICall;

@SpringBootApplication
public class ProgettoProgrammazioneAdOggettiApplication {

	public static void main(String[] args) throws IOException  {
		SpringApplication.run(ProgettoProgrammazioneAdOggettiApplication.class, args);
		
		APICall apicall = new APICall();
		
		apicall.writefileSquadre();
		
		apicall.writefileStagioni(); 

	}

}
