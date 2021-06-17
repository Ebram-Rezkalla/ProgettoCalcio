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
// Classe che gestisce le chiamate Get e Post implementate
public class calcioController {
	
	ServiceCalcio servicecalcio=new ServiceCalcio();

// Rotta Get che mette in esecuzione le informazioni per tutte le competizioni
	@GetMapping("/Competizioni") 

	public ResponseEntity<Object> getall()  {
	return new ResponseEntity<>(servicecalcio.getall(),HttpStatus.OK);
	}
		
	/* Rotta Get che mette in esecuzione le informazioni per una detrerminata competizione dipendente dal id che e' il parametro. 
	 *  id = 2019 per Italia 
        id = 2015 per Francia
        id = 2002 per Germaia
	*/
	@GetMapping("/Competizione") 

	public ResponseEntity<Object> getSpecificComp(@RequestParam (value="id", defaultValue="") String code) {
		return new ResponseEntity<>(servicecalcio.getSpecificComp(code),HttpStatus.OK);
	}
	
	/* Rotta Get che mette in esecuzione le statistiche generali per tutte le competizioni le informazioni di :
	 * massimo numero squadre
	 * minimo numero squadre
	 * medio numero squadre
	 * media stagioni salvate
	 * media durata stagione mesi
	 * media resto durata stagione giorni
	 */
	@GetMapping("/Stats") 

	public ResponseEntity<Object> GetStats()  {
	return new ResponseEntity<>(servicecalcio.GetStats(),HttpStatus.OK);
	}
	
	/*Rotta Post che filtra le statistiche generali per una o due competizioni a scelta 
	 * Filtra in base a  id1 e id2 
	 */
	@PostMapping("/Filter")
	
	public ResponseEntity<Object> GetFiltri(@RequestBody FilterGenerali filter) {
		return new ResponseEntity<>(servicecalcio.GetFiltri(filter),HttpStatus.OK);
	}
	
	/* Rotta Get che mette in esecuzione le statistiche di una specifica competizione in base all'id e da informazione di :
	 * squadra_Maggior_Vincite
	 * squadra_Miglior_Difesa
	 * squadra_Miglior_Differenza
	 * numero_Stagione_Salvate
	 * squadra_Miglior_Attacco
	 * squadra_Maggior_Perdite
	 */
	@GetMapping("/StatsComp") 

	public ResponseEntity<Object> GetStatsComp(@RequestParam (value="id", defaultValue="") String code) {
	return new ResponseEntity<>(servicecalcio.GetStatsComp(code),HttpStatus.OK);
	}
	
	/*Rotta Post che filtra le statistiche di una specifica competizione a scelta in base a 
	 * 1) id quale competizione
	 * 2) tipo di partita
	 * 3) numero di squadre
	 * 4) in base alla posizione delle squadre prime o ultime
	 */
	@PostMapping("/FilterComp")
	
	public ResponseEntity<Object> GetFiltriComp(@RequestBody FilterCompetizione filtercompetizioni) {
		return new ResponseEntity<>(servicecalcio.GetFiltriComp(filtercompetizioni),HttpStatus.OK);
	}
	
}
	