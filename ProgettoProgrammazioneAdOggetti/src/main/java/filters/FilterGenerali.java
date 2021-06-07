package filters;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;

import com.sun.el.parser.ParseException;

import stats.StatsGenerali;

public class FilterGenerali {
	String id1;
	String id2;
	StatsGenerali statsgenerali=new StatsGenerali();
	
	public FilterGenerali(String id1,String id2) {
		this.id1=id1;
		this.id2=id2;
		
	}
	
	
	
public int MassimoSquadreFilter() throws MalformedURLException, JSONException, IOException, ParseException, org.apache.tomcat.util.json.ParseException  {
			
			int massimo=statsgenerali.MassimoNumeroSquadre(id1,id2,"null");
			return  massimo;
		}



public int MinimoSquadreFilter() throws MalformedURLException, JSONException, IOException, ParseException, org.apache.tomcat.util.json.ParseException  {
	
	int minimo=statsgenerali.MinimoNumeroSquadre(id1, id2, "null");
	return  minimo;
	}


public double MedioSquadreFilter() throws MalformedURLException, JSONException, IOException, org.apache.tomcat.util.json.ParseException {
	
	double media=statsgenerali.MedioNumeroSquadre(id1, id2, "null");
	return media;
	}
/*
public int MediaDurataFilter() throws MalformedURLException, JSONException, IOException, org.apache.tomcat.util.json.ParseException, java.text.ParseException {
	
	int mediadurata=statsgenerali.MediaDurataSg("mese", id1, id2, "null");
	return mediadurata;
	}*/

public double MediaStagioniFilter() throws MalformedURLException, JSONException, IOException, org.apache.tomcat.util.json.ParseException {
	
	double mediastagioni=statsgenerali.MediaStagioniSalvate(id1, id2, "null");
	return mediastagioni;
	
	
	
}


}
