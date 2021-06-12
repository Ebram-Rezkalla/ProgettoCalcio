package filters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;

import exception.BodyException;
import exception.NotFound;
import stats.StatsCompetizione;

public class FilterCompetizione extends StatsCompetizione {
	private String tipo;
	private String id;
	private int n;
	private String pu;
 
	/* Costruttore FilterCompetizione che prende:
	 * 1) tipo della partita richiesto
	 * 2) id della competizione disedirata
	 * 3) il numero disedirato di squadre 
	 * 4) "pu" prime o ultime squadre in base alla posizione 
	 */
	
	
	public FilterCompetizione(String tipo,String id, int n, String pu) {
		super(id,tipo,n,pu);
		this.tipo=tipo;
		this.id=id;
		this.n=n;
		this.pu=pu;
}

// metodo che verifica la correttezza del numero di squadre inserito dal utente

public void VerificaNumero(int n) {
		
		sq=parserjson.ParserSquadre(id,GetNumberTipo( tipo));

		if(n==0)
			throw new BodyException("Errore,Puoi Usare Solo la lettera (n) Come key.");
		if(n<0||n>sq.size())
			throw new NotFound("Numero Inserito Non Corretto,Puoi Inserire Un Numero Compreso tra 1 e "+sq.size()+".");
	}

    /*metodo che verifica la correttezza del tipo di filter inserito dal utente
     * ci stanno due Exception 
     * 1 BodyException quando l'utente scrive il key in modo errato 
     * 2 NotFound quando l'utente mette il pu non desiderato oppure vuoto
     */
	
	public void Verificaultimo(String pu)  {
		if(pu==null)
			throw new BodyException("Errore,Puoi Usare Solo (pu) Come Key.");
		if(!(pu.equals("u")||pu.equals("p")||pu.equals("P")||pu.equals("U")))
			throw new NotFound ("Lettera Inserita Non Coretta,Si Prega di Usare La Lettera (P/p) Per Le Prime N Squadre e La Lettera (U/u) per Le Ultime N Squadre.");
		
	}
	
	// metodo per verificare che l'id non sia vuoto e in questo caso manda eccezione di BodyException
	
	public  void VerificaId (String id) {
		if(id==null)
			throw new BodyException("Errore,Puoi Usare Solo (id) Come Key");
		
	}
	
	
//metodo che restitusce le squadre di miglior attacco filtrate chiamando il metodo SquadraMigliorAttacco

public ArrayList<String> SquadraMigliorAttacoFilter() {
		VerificaId(id);
		VerificaNumero(n);
		Verificaultimo(pu);
		return super.SquadraMigliorAttacco();
		}
//metodo che restitusce le squadre di miglior difesa filtrate chiamando il metodo SquadraMigliorDifesa

public ArrayList<String> SquadraMigliorDifesaFilter() {
		
		return super.SquadraMigliorDifesa();
	}
//metodo che restitusce le squadre di miglior differenza goal filtrate chiamando il metodo SquadraMigliorDifferenza

public ArrayList<String> SquadraMigliorDifferenzaFilter(){
		return super.SquadraMigliorDifferenza();
	}
//metodo che restitusce le squadre con maggior vincite filtrate chiamando il metodo SquadraMaggiorVincite

public ArrayList<String> SquadraMaggiorVinciteFilter() {
	return super.SquadraMaggiorVincite();	
}
//metodo che restitusce le squadre con maggior perdite filtrate chiamando il metodo SquadraMaggiorPerdite

public ArrayList<String> SquadraMaggiorPerditeFilter() {	
	return super.SquadraMaggiorPerdite();
	
}

}
