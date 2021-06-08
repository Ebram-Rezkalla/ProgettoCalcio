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
import model.StatsGeneraliModel;
import service.ParserJson;

public class StatsGenerali {
	
	ParserJson statistiche=new ParserJson();
	ArrayList<Squadra> S1 = new ArrayList<Squadra>();
	ArrayList<Squadra> S2 = new ArrayList<Squadra>();
	ArrayList<Squadra> S3 = new ArrayList<Squadra>();
	ArrayList<Stagione> Sg = new ArrayList<Stagione>();
	
	
	ArrayList<Stagione> Sta1 = new ArrayList<Stagione>();
	ArrayList<Stagione> Sta2 = new ArrayList<Stagione>();
	ArrayList<Stagione> Sta3 = new ArrayList<Stagione>();
	boolean f;
	
	StatsGeneraliModel statsgeneralimodel;
	 double MediaGiorniStagione;


	public StatsGenerali(String id1,String id2,String id3) throws MalformedURLException, JSONException, IOException, Exception{
		S1=statistiche.ParserSquadre(id1);
		S2=statistiche.ParserSquadre(id2);
		Sta1=statistiche.ParserStagioni(id1);
		Sta2=statistiche.ParserStagioni(id2);
		if(!(id3.equals("null"))) {
		Sta3=statistiche.ParserStagioni(id3);
		S3=statistiche.ParserSquadre(id3);
		}

		}
	
	public int MassimoNumeroSquadre(boolean f) throws MalformedURLException, JSONException, IOException, ParseException {
		if(f) {
			
			if(S1.size()>=S2.size())
				return S1.size();
			else return S2.size();
			
		}
		else { 
		
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
	
	
	
	public int MinimoNumeroSquadre(boolean f) throws MalformedURLException, JSONException, IOException, ParseException {
		if(f) {
			
			if(S1.size()<=S2.size())
				return S1.size();
			else return S2.size();
			
		}
		else { 
		
		if (S1.size()<=S2.size()) {
			if(S1.size()<=S3.size()){
				return S1.size();
			}else return S3.size();
		}else {
			if (S2.size()<=S3.size())
			return S2.size(); 
		}
	
	return S3.size();
		
		}}
	
	
	
	public double MedioNumeroSquadre(boolean f) throws MalformedURLException, JSONException, IOException, ParseException {
		if(f) {
		
		int	sommafilter=S1.size()+S2.size();
		double mediafilter=(sommafilter/2);
		return mediafilter;
			}else {
		
		int somma=S1.size()+S2.size()+S3.size();
		double media= (somma/3);
		return media;
			}
		
	}
	


public double  DurataGiorni(ArrayList<Stagione> Sg) throws MalformedURLException, JSONException, IOException, ParseException, java.text.ParseException {

		

		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date DataInizio=sdf.parse(Sg.get(0).getDataInizio());
		Date DataFine=sdf.parse(Sg.get(0).getDataFine());

		double differenzaTempo= (DataFine.getTime() - DataInizio.getTime());
		double differenzaGironi=(differenzaTempo / (1000 * 60 * 60 * 24))% 365;
	
			return differenzaGironi;
			}
	
	
	
	
	public int  MediaDurataSgMesi(boolean f) throws MalformedURLException, JSONException, IOException, ParseException, java.text.ParseException {
		if(f) {
			double giorniSg1= DurataGiorni(Sta1);
			double giorniSg2= DurataGiorni(Sta2);
			 MediaGiorniStagione = (giorniSg1+giorniSg2)/2;
			
		}else {
		 double giorniSg1= DurataGiorni(Sta1);
		 double giorniSg2= DurataGiorni(Sta2);
		 double giorniSg3= DurataGiorni(Sta3);
		  MediaGiorniStagione = (giorniSg1+giorniSg2+giorniSg3)/3;
		}
		int MediaMesiStagione=(int) (MediaGiorniStagione/30);
				
			return MediaMesiStagione;
		
	}
	
	public int MediaDurataSggiorni(boolean f) throws MalformedURLException, JSONException, IOException, ParseException, java.text.ParseException {
		int prova =MediaDurataSgMesi(f);
		int restogiorni = (int) (MediaGiorniStagione - (30*prova));
		return restogiorni;
	}
	
	
	public double MediaStagioniSalvate (boolean f) throws MalformedURLException, JSONException, IOException, ParseException {
		
		if(f) {
			int sommafilter=Sta1.size()+Sta2.size();
			double mediafilter= (sommafilter/2);
			return mediafilter;
			}
		else {
			
			int somma=Sta1.size()+Sta2.size()+Sta3.size();
			double media= (somma/3);
			return media;
	
			}
		}
	

	


}
