package Calcio.it.ProgettoProgrammazioneAdOggetti;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import exception.NotFound;
import service.APICall;
import service.ParserJson;

@SpringBootTest
class ProgettoProgrammazioneAdOggettiApplicationTests {
	
	ParserJson parserjsontest;
	APICall apicalltest;

	@BeforeEach
	void contextLoads() {
		parserjsontest=new ParserJson();
		apicalltest=new APICall();
	}
	@AfterEach
	void tearDown() throws Exception{}

	@Test
	@DisplayName("Test1, Verifica codice competizione")
	void GetNumbertest() {
		assertEquals(0,parserjsontest.GetNumber("2019"));
	}
	
	@Test
	@DisplayName("Test2, Verifica il Lancio dell'eccezione in caso viene inserito un id non valido")
	void NotFoundtest() {
		try {
			parserjsontest.GetNumber("2017");
		}catch(NotFound e) {}
		
	}

	@Test
	@DisplayName("Test3, Verifica la lettura da un file locale ")
	void readFiletest() {
		String test= apicalltest.readfile("datisquadre");
		assertNotNull(test);
	}
	

}
