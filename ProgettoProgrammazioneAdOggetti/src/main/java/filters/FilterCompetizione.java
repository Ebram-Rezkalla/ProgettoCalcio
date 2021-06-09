package filters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;

import stats.StatsCompetizione;

public class FilterCompetizione extends StatsCompetizione {
	private String tipo;
	private String id;
	private int n;
	private String pu;

	
	public FilterCompetizione(String tipo,String id, int n, String pu) throws MalformedURLException, JSONException, IOException, ParseException {
		super(id,tipo,n,pu);
		this.tipo=tipo;
		this.id=id;
		this.n=n;
		this.pu=pu;
}

	
public int VerificaNumero(int n) throws MalformedURLException, JSONException, IOException, ParseException {
		
		sq=parserjson.ParserSquadre(id,GetNumberTipo( tipo));
		if(n==0||n>sq.size())
			return 0;
		else return n;
		
	}
	
	public String Verificaultimo(String pu) throws MalformedURLException, JSONException, IOException, ParseException {
		
		if(!(pu.equals("u")||pu.equals("p")))
			return pu;
		else return pu;
		
	}
	
	
	
public ArrayList<String> SquadraMigliorAttacoFilter() throws MalformedURLException, JSONException, IOException, ParseException {
		
		return super.SquadraMigliorAttacco();
		}
public ArrayList<String> SquadraMigliorDifesaFilter() throws MalformedURLException, JSONException, IOException, ParseException{
		
		return SquadraMigliorDifesa();
	}
	
public ArrayList<String> SquadraMigliorDifferenzaFilter() throws MalformedURLException, JSONException, IOException, ParseException{
		
		return SquadraMigliorDifferenza();
	}

public ArrayList<String> SquadraMaggiorVinciteFilter() throws MalformedURLException, JSONException, IOException, ParseException{
	
	return SquadraMaggiorVincite();
	
	
}

public ArrayList<String> SquadraMaggiorPerditeFilter() throws MalformedURLException, JSONException, IOException, ParseException{
	
	return SquadraMaggiorPerdite();
	
}

}
