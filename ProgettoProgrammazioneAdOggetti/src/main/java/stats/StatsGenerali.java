package stats;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;

import model.Squadra;
import model.Stagione;
import service.ParserJson;

public class StatsGenerali {
	
	ParserJson statistiche=new ParserJson();
	ArrayList<Squadra> italiaS = new ArrayList<Squadra>();
	ArrayList<Squadra> germaniaS = new ArrayList<Squadra>();
	ArrayList<Squadra> franciaS = new ArrayList<Squadra>();
	ArrayList<Stagione> Sg = new ArrayList<Stagione>();
	



	public StatsGenerali(){
		
		
		}
	
	
	public int MassimoNumeroSquadre() throws MalformedURLException, JSONException, IOException, ParseException {
		
		italiaS =statistiche.ParserSquadre("2019");
		germaniaS=statistiche.ParserSquadre("2002");
		franciaS=statistiche.ParserSquadre("2015");
		if (italiaS.size()>=germaniaS.size()) {
			if(italiaS.size()>=franciaS.size()){
				return italiaS.size();
			}else return franciaS.size();
		}else {
			if (germaniaS.size()>=franciaS.size())
			return germaniaS.size(); 
		}
	
	return franciaS.size();
		
	}
	
	public int MinimoNumeroSquadre() throws MalformedURLException, JSONException, IOException, ParseException {
		
		italiaS =statistiche.ParserSquadre("2019");
		germaniaS=statistiche.ParserSquadre("2002");
		franciaS=statistiche.ParserSquadre("2015");
		if (italiaS.size()<=germaniaS.size()) {
			if(italiaS.size()<=franciaS.size()){
				return italiaS.size();
			}else return franciaS.size();
		}else {
			if (germaniaS.size()<=franciaS.size())
			return germaniaS.size(); 
		}
	
	return franciaS.size();
		
		
		
		
	}
	
	public double MedioNumeroSquadre() throws MalformedURLException, JSONException, IOException, ParseException {
		
		italiaS =statistiche.ParserSquadre("2019");
		germaniaS=statistiche.ParserSquadre("2002");
		franciaS=statistiche.ParserSquadre("2015");
		int somma=italiaS.size()+germaniaS.size()+franciaS.size();
		double media= (somma/3);
		return media;
		
		
	}
	
	
	public int  MediaDurataGiorni(String tipo,String codice) throws MalformedURLException, JSONException, IOException, ParseException, java.text.ParseException {
		
		Sg=statistiche.ParserStagioni(codice);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date DataInizio=sdf.parse(Sg.get(0).getDataInizio());
		Date DataFine=sdf.parse(Sg.get(0).getDataFine());
		double differenzaTempo= (DataFine.getTime() - DataInizio.getTime());
		double differenzaGironi=(differenzaTempo / (1000 * 60 * 60 * 24))% 365;
		int differenzaMesi=(int) (differenzaGironi/30);
		int restogiorni = (int) (differenzaGironi - (30*differenzaMesi));
		
		if(tipo.equals("giorno"))
			return restogiorni;
		else 
			return differenzaMesi;
		
	}
	
	
	
	
	

}
