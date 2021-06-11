package filters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;

import exception.BodyException;
import exception.IdNotFound;
import stats.StatsCompetizione;

public class FilterCompetizione extends StatsCompetizione {
	private String tipo;
	private String id;
	private int n;
	private String pu;
 
	// Costruttore FilterCompetizione
	
	public FilterCompetizione(String tipo,String id, int n, String pu) throws MalformedURLException, JSONException, IOException, ParseException {
		super(id,tipo,n,pu);
		this.tipo=tipo;
		this.id=id;
		this.n=n;
		this.pu=pu;
}

	// metodo che verifica la correttezza del numero di squadre inserito dal cliente
public void VerificaNumero(int n) throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound {
		
		sq=parserjson.ParserSquadre(id,GetNumberTipo( tipo));
		if(n<=0||n>sq.size())
			throw new BodyException("Numnero Inserito non giusto, puoi inserire un numero compreso tra 1 e "+sq.size()+".");	
		
	}

    //metodo che verifica la correttezza del tipo di filter inserito dal cliente
	
	public String Verificaultimo(String pu) throws MalformedURLException, JSONException, IOException, ParseException {
		
		if(!(pu.equals("u")||pu.equals("p")))
			return pu;
		else return pu;
	}
	 
	//metodo che restitusce le squadre di miglior attacco filtrate chiamando il metodo SquadraMigliorAttacco

public ArrayList<String> SquadraMigliorAttacoFilter() throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound {
		VerificaNumero(n);
		return super.SquadraMigliorAttacco();
		}
//metodo che restitusce le squadre di miglior difesa filtrate chiamando il metodo SquadraMigliorDifesa

public ArrayList<String> SquadraMigliorDifesaFilter() throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound{
		
		return super.SquadraMigliorDifesa();
	}
	
//metodo che restitusce le squadre di miglior differenza goal filtrate chiamando il metodo SquadraMigliorDifferenza

public ArrayList<String> SquadraMigliorDifferenzaFilter() throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound{
		
		return super.SquadraMigliorDifferenza();
	}

//metodo che restitusce le squadre con maggior vincite filtrate chiamando il metodo SquadraMaggiorVincite


public ArrayList<String> SquadraMaggiorVinciteFilter() throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound{
	
	return super.SquadraMaggiorVincite();
	
	
}


//metodo che restitusce le squadre con maggior perdite filtrate chiamando il metodo SquadraMaggiorPerdite

public ArrayList<String> SquadraMaggiorPerditeFilter() throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound{
	
	return super.SquadraMaggiorPerdite();
	
}

}
