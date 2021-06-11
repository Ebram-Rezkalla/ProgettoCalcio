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
 
	// Costruttore FilterCompetizione
	
	public FilterCompetizione(String tipo,String id, int n, String pu) {
		super(id,tipo,n,pu);
		this.tipo=tipo;
		this.id=id;
		this.n=n;
		this.pu=pu;
}

<<<<<<< HEAD
	
public void VerificaNumero(int n) {
=======
	// metodo che verifica la correttezza del numero di squadre inserito dal cliente
public void VerificaNumero(int n) throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound {
		
>>>>>>> branch 'master' of https://github.com/Ebram-Rezkalla/ProgettoCalcio
		sq=parserjson.ParserSquadre(id,GetNumberTipo( tipo));
<<<<<<< HEAD
		if(n==0)
			throw new BodyException("Errore,Puoi Usare Solo la lettera (n) Come key.");
		if(n<0||n>sq.size())
			throw new NotFound("Numero Inserito Non Corretto,Puoi Inserire Un Numero Compreso tra 1 e "+sq.size()+".");
		
=======
		if(n<=0||n>sq.size())
			throw new BodyException("Numnero Inserito non giusto, puoi inserire un numero compreso tra 1 e "+sq.size()+".");	
>>>>>>> branch 'master' of https://github.com/Ebram-Rezkalla/ProgettoCalcio
		
	}

    //metodo che verifica la correttezza del tipo di filter inserito dal cliente
	
	public void Verificaultimo(String pu)  {
		if(pu==null)
			throw new BodyException("Errore,Puoi Usare Solo (pu) Come Key.");
		if(!(pu.equals("u")||pu.equals("p")||pu.equals("P")||pu.equals("U")))
			throw new NotFound ("Lettera Inserita Non Coretta,Si Prega di Usare La Lettera (P/p) Per Le Prime N Squadre e La Lettera (U/u) per Le Ultime N Squadre.");
		
<<<<<<< HEAD
	}
	
	public  void VerificaId (String id) {
		if(id==null)
			throw new BodyException("Errore,Puoi Usare Solo (id) Come Key");
		
=======
		if(!(pu.equals("u")||pu.equals("p")))
			return pu;
		else return pu;
>>>>>>> branch 'master' of https://github.com/Ebram-Rezkalla/ProgettoCalcio
	}
<<<<<<< HEAD
	
	
	
public ArrayList<String> SquadraMigliorAttacoFilter() {
		VerificaId(id);
=======
	 
	//metodo che restitusce le squadre di miglior attacco filtrate chiamando il metodo SquadraMigliorAttacco

public ArrayList<String> SquadraMigliorAttacoFilter() throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound {
>>>>>>> branch 'master' of https://github.com/Ebram-Rezkalla/ProgettoCalcio
		VerificaNumero(n);
		Verificaultimo(pu);
		return super.SquadraMigliorAttacco();
		}
<<<<<<< HEAD
public ArrayList<String> SquadraMigliorDifesaFilter() {
=======
//metodo che restitusce le squadre di miglior difesa filtrate chiamando il metodo SquadraMigliorDifesa

public ArrayList<String> SquadraMigliorDifesaFilter() throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound{
>>>>>>> branch 'master' of https://github.com/Ebram-Rezkalla/ProgettoCalcio
		
		return super.SquadraMigliorDifesa();
	}
	
<<<<<<< HEAD
public ArrayList<String> SquadraMigliorDifferenzaFilter(){
=======
//metodo che restitusce le squadre di miglior differenza goal filtrate chiamando il metodo SquadraMigliorDifferenza

public ArrayList<String> SquadraMigliorDifferenzaFilter() throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound{
>>>>>>> branch 'master' of https://github.com/Ebram-Rezkalla/ProgettoCalcio
		
		return super.SquadraMigliorDifferenza();
	}

<<<<<<< HEAD
public ArrayList<String> SquadraMaggiorVinciteFilter() {
=======
//metodo che restitusce le squadre con maggior vincite filtrate chiamando il metodo SquadraMaggiorVincite


public ArrayList<String> SquadraMaggiorVinciteFilter() throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound{
>>>>>>> branch 'master' of https://github.com/Ebram-Rezkalla/ProgettoCalcio
	
	return super.SquadraMaggiorVincite();
	
	
}

<<<<<<< HEAD
public ArrayList<String> SquadraMaggiorPerditeFilter() {
=======

//metodo che restitusce le squadre con maggior perdite filtrate chiamando il metodo SquadraMaggiorPerdite

public ArrayList<String> SquadraMaggiorPerditeFilter() throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound{
>>>>>>> branch 'master' of https://github.com/Ebram-Rezkalla/ProgettoCalcio
	
	return super.SquadraMaggiorPerdite();
	
}

}
