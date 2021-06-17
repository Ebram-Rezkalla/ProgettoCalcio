package Calcio.it.ProgettoProgrammazioneAdOggetti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import service.APICall;

@SpringBootApplication
public class ProgettoProgrammazioneAdOggettiApplication {

	public static void main(String[] args)  {
		SpringApplication.run(ProgettoProgrammazioneAdOggettiApplication.class, args);
		
// All'inizio dell'esecuzione del programma viene effetuata la chiamata all'API e viene scritto tutto su due file locali
		
		APICall apicall = new APICall();
		
		apicall.writefileSquadre();
		
		apicall.writefileStagioni(); 

	}

}
