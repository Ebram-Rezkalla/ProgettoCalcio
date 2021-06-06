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
	ArrayList<Squadra> S1 = new ArrayList<Squadra>();
	ArrayList<Squadra> S2 = new ArrayList<Squadra>();
	ArrayList<Squadra> S3 = new ArrayList<Squadra>();
	ArrayList<Stagione> Sg = new ArrayList<Stagione>();
	
	
	ArrayList<Stagione> italiaSta = new ArrayList<Stagione>();
	ArrayList<Stagione> germaniaSta = new ArrayList<Stagione>();
	ArrayList<Stagione> franciaSta = new ArrayList<Stagione>();
	

	public StatsGenerali(){
		
		}
	
	public int MassimoNumeroSquadre(String id1,String id2,String id3) throws MalformedURLException, JSONException, IOException, ParseException {
		if(id3.equals("null")) {
			S1=statistiche.ParserSquadre(id1);
			S2=statistiche.ParserSquadre(id2);
			if(S1.size()>=S2.size())
				return S1.size();
			else return S2.size();
			
		}
		else { 
		S1 =statistiche.ParserSquadre(id1);
		S2=statistiche.ParserSquadre(id2);
		S3=statistiche.ParserSquadre(id3);
		if (S1.size()>=S2.size()) {
			if(S1.size()>=S3.size()){
				return S1.size();
			}else return S3.size();
		}else {
			if (S2.size()>=S3.size())
			return S2.size(); 
		}
	
	return S3.size();
		
		}}
	
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
	

public double  DurataGiorni(String codice) throws MalformedURLException, JSONException, IOException, ParseException, java.text.ParseException {
		
		Sg=statistiche.ParserStagioni(codice);

		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date DataInizio=sdf.parse(Sg.get(0).getDataInizio());
		Date DataFine=sdf.parse(Sg.get(0).getDataFine());
		
		
		double differenzaTempo= (DataFine.getTime() - DataInizio.getTime());
		double differenzaGironi=(differenzaTempo / (1000 * 60 * 60 * 24))% 365;
	
			return differenzaGironi;
			}
	
	
	
	
	public int  MediaDurataSg(String tipo) throws MalformedURLException, JSONException, IOException, ParseException, java.text.ParseException {
		
		 double giorniIt= DurataGiorni("2019");
		 double giorniFr= DurataGiorni("2015");
		 double giorniGe= DurataGiorni("2002");
		 double MediaGiorniStagione = (giorniIt+giorniFr+giorniGe)/3;
		int MediaMesiStagione=(int) (MediaGiorniStagione/30);
		
		int restogiorni = (int) (MediaGiorniStagione - (30*MediaMesiStagione));
		
		if(tipo.equals("giorno"))
			return restogiorni;
		else 
			return MediaMesiStagione;
		
	}
	
	
	public double MediaStagioniSalvate () throws MalformedURLException, JSONException, IOException, ParseException {
	
	italiaSta =statistiche.ParserStagioni("2019");
	germaniaSta=statistiche.ParserStagioni("2002");
	franciaSta=statistiche.ParserStagioni("2015");
	
	
	int somma=italiaSta.size()+germaniaSta.size()+franciaSta.size();
	double media= (somma/3);
	return media;
	
	}
	
	

}
