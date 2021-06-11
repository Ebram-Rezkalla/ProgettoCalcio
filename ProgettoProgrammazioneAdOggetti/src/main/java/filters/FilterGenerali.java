package filters;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;

import com.sun.el.parser.ParseException;

import stats.StatsGenerali;

public class FilterGenerali {
	String id1;
	String id2;
	StatsGenerali statsgenerali;
	
	// Costruttore FilterGenerali
	public FilterGenerali(String id1,String id2) throws MalformedURLException, JSONException, IOException, Exception {
		this.id1=id1;
		this.id2=id2;
		this.statsgenerali=new StatsGenerali(id1,id2,"null");
	}
	
	
	 // metodo che restitusce il massimo numero di squadre filtrate chiamando il metodo MassimoNumeroSquadre
public int MassimoSquadreFilter() throws MalformedURLException, JSONException, IOException, ParseException, org.apache.tomcat.util.json.ParseException  {
			
			int massimo=statsgenerali.MassimoNumeroSquadre(true);
			return  massimo;
		}

// metodo che restitusce il minimo numero di squadre filtrate chiamando il metodo MinimoNumeroSquadre


public int MinimoSquadreFilter() throws MalformedURLException, JSONException, IOException, ParseException, org.apache.tomcat.util.json.ParseException  {
	
	int minimo=statsgenerali.MinimoNumeroSquadre(true);
	return  minimo;
	}

//metodo che restitusce il medio numero di squadre filtrate chiamando il metodo MedioNumeroSquadre


public double MedioSquadreFilter() throws MalformedURLException, JSONException, IOException, org.apache.tomcat.util.json.ParseException {
	
	double media=statsgenerali.MedioNumeroSquadre(true);
	return media;
	}

//metodo che restitusce la durata in mesi delle stagioni filtrate chiamando il metodo MediaDurataSgMesi


public int MediaDurataFilterMesi() throws MalformedURLException, JSONException, IOException, org.apache.tomcat.util.json.ParseException, java.text.ParseException {
	
	int mediadurata=statsgenerali.MediaDurataSgMesi(true);
	return mediadurata;
	}

//metodo che restitusce il resto della durata in gioni  delle stagioni filtrate chiamando il metodo MediaDurataSggiorni


public int MediaDurataFilterGiorni() throws MalformedURLException, JSONException, IOException, org.apache.tomcat.util.json.ParseException, java.text.ParseException {
	
	int mediadurata=statsgenerali.MediaDurataSggiorni(true);
	return mediadurata;
	}

//metodo che restitusce il medio numero delle stagioni filtrate chiamando il metodo MediaStagioniSalvate

public double MediaStagioniFilter() throws MalformedURLException, JSONException, IOException, org.apache.tomcat.util.json.ParseException {
	
	double mediastagioni=statsgenerali.MediaStagioniSalvate(true);
	return mediastagioni;
	
	
	
}


}
