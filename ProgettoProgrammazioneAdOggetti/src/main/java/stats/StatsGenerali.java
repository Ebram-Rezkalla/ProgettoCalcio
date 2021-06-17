package stats;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Squadra;
import model.Stagione;
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
	double MediaGiorniStagione;

	/* Costruttore StatsGenerali che prende :
	 * id1 , id2 e id3 per le tre competizioni e popula ArrayList per le squadre e stagioni 
	 */
	public StatsGenerali(String id1,String id2,String id3) {
 		S1=statistiche.ParserSquadre(id1,0);
		S2=statistiche.ParserSquadre(id2,0);
		Sta1=statistiche.ParserStagioni(id1);
		Sta2=statistiche.ParserStagioni(id2);
		if(!(id3.equals("null"))) {
		Sta3=statistiche.ParserStagioni(id3);
		S3=statistiche.ParserSquadre(id3,0);
		}

		}
	// metodo che restituisce il numero massimo di squadre
	public int MassimoNumeroSquadre(boolean f)  {
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
	
	// metodo che restituisce il numero minimo di squadre
	public int MinimoNumeroSquadre(boolean f)  {
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
	
	// metodo che restituisce il numero medio di squadre
	public double MedioNumeroSquadre(boolean f)  {
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
	
	// metodo che restituisce la durata della stagione in giorni
    public double  DurataGiorni(ArrayList<Stagione> Sg)   {

		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date DataInizio = null;
		Date DataFine = null;
		try {
			DataInizio = sdf.parse(Sg.get(0).getDataInizio());
		DataFine=sdf.parse(Sg.get(0).getDataFine());
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		
		double differenzaTempo= (DataFine.getTime() - DataInizio.getTime());
		double differenzaGironi=(differenzaTempo / (1000 * 60 * 60 * 24))% 365;
	
			return differenzaGironi;
			}
	
     //metodo che restituisce la durata della stagione in mesi
	public int  MediaDurataSgMesi(boolean f)  {
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
	 //metodo che restituisce il resto di giorni da mesi della durata della stagione 
	public int MediaDurataSggiorni(boolean f) {
		int prova =MediaDurataSgMesi(f);
		int restogiorni = (int) (MediaGiorniStagione - (30*prova));
		return restogiorni;
	}
	
	 //metodo che restituisce la media delle stagione salvate della competizione 
	public double MediaStagioniSalvate (boolean f)  {		
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
