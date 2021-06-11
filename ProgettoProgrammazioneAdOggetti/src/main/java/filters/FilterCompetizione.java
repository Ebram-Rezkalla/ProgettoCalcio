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

	
	public FilterCompetizione(String tipo,String id, int n, String pu) {
		super(id,tipo,n,pu);
		this.tipo=tipo;
		this.id=id;
		this.n=n;
		this.pu=pu;
}

	
public void VerificaNumero(int n) {
		sq=parserjson.ParserSquadre(id,GetNumberTipo( tipo));
		if(n==0)
			throw new BodyException("Errore,Puoi Usare Solo la lettera (n) Come key.");
		if(n<0||n>sq.size())
			throw new NotFound("Numero Inserito Non Corretto,Puoi Inserire Un Numero Compreso tra 1 e "+sq.size()+".");
		
		
	}
	
	public void Verificaultimo(String pu)  {
		if(pu==null)
			throw new BodyException("Errore,Puoi Usare Solo (pu) Come Key.");
		if(!(pu.equals("u")||pu.equals("p")||pu.equals("P")||pu.equals("U")))
			throw new NotFound ("Lettera Inserita Non Coretta,Si Prega di Usare La Lettera (P/p) Per Le Prime N Squadre e La Lettera (U/u) per Le Ultime N Squadre.");
		
	}
	
	public  void VerificaId (String id) {
		if(id==null)
			throw new BodyException("Errore,Puoi Usare Solo (id) Come Key");
		
	}
	
	
	
public ArrayList<String> SquadraMigliorAttacoFilter() {
		VerificaId(id);
		VerificaNumero(n);
		Verificaultimo(pu);
		return super.SquadraMigliorAttacco();
		}
public ArrayList<String> SquadraMigliorDifesaFilter() {
		
		return super.SquadraMigliorDifesa();
	}
	
public ArrayList<String> SquadraMigliorDifferenzaFilter(){
		
		return super.SquadraMigliorDifferenza();
	}

public ArrayList<String> SquadraMaggiorVinciteFilter() {
	
	return super.SquadraMaggiorVincite();
	
	
}

public ArrayList<String> SquadraMaggiorPerditeFilter() {
	
	return super.SquadraMaggiorPerdite();
	
}

}
