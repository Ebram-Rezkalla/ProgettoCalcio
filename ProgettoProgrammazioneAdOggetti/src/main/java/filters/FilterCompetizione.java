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
	
	public FilterCompetizione(String tipo,String id) {

		this.tipo=tipo;
		this.id=id;
		
}

	public int  GetNumberTipo(String tipo) {
		
		if (tipo.equals("Total"))
			 return 0;
		 
		 if (tipo.equals("Home"))
			 return 1;
		 
		 if (tipo.equals("Away"))
			 return 2;
		return (Integer) null;
		}
	
	
	
	
	
	public ArrayList<String> SquadraMigliorAttacoFilter() throws MalformedURLException, JSONException, IOException, ParseException {
		
		return SquadraMigliorAttacco(id,GetNumberTipo(tipo));
		}
	public ArrayList<String> SquadraMigliorDifesaFilter() throws MalformedURLException, JSONException, IOException, ParseException{
		
		return SquadraMigliorDifesa(id,GetNumberTipo(tipo));
	}
	
public ArrayList<String> SquadraMigliorDifferenzaFilter() throws MalformedURLException, JSONException, IOException, ParseException{
		
		return SquadraMigliorDifferenza(id,GetNumberTipo(tipo));
	}

public ArrayList<String> SquadraMaggiorVinciteFilter() throws MalformedURLException, JSONException, IOException, ParseException{
	
	return SquadraMaggiorVincite(id,GetNumberTipo(tipo));
	
	
}

public ArrayList<String> SquadraMaggiorPerditeFilter() throws MalformedURLException, JSONException, IOException, ParseException{
	
	return SquadraMaggiorPerdite(id,GetNumberTipo(tipo));
	
}

}
