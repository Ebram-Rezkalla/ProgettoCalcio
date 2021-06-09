package service;

import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import filters.FilterGenerali;
import model.Competizione;
import model.Stagione;
import model.StatsGeneraliModel;
import stats.StatsGenerali;

public class ServiceCalcio {
	
	ParserJson servicecomp=new ParserJson();
	ArrayList<String> out=new ArrayList<String>();
	ArrayList<String> outone=new ArrayList<String>();
	StatsGenerali statsgenerali;


	ArrayList<Stagione> staglist=new ArrayList<Stagione>();
	
	 StatsGeneraliModel statsgeneralimodel;
	 StatsGeneraliModel filtergeneralimodel;
	public ServiceCalcio () {
			
		
	}
	
	
	public ArrayList<String>getall() throws MalformedURLException, JSONException, IOException, ParseException {
		
		
		getcompetizione("2019");
		getcompetizione("2015");
		getcompetizione("2002");
		
		
		return out;
		}
		
		
	public void getcompetizione(String code) throws MalformedURLException, JSONException, IOException, ParseException {
		
		
		Competizione compi=servicecomp.ParserCompetizioni(code);
		String id="id:"+compi.getId();
		String nomepaese="nome paese:"+compi.getNomepaese();
		String nome="nome:"+compi.getNome();
	staglist=compi.getStagionelist();
	Stagione stag=staglist.get(0);
	String datainizio="Data inizio:"+stag.getDataInizio();
	String datafine="Data fine:"+stag.getDataFine();
	String vincitore="Vincitore:"+stag.getVincitore();
	out.add(id);out.add(nome);out.add(nomepaese);out.add(datainizio);out.add(datafine);out.add(vincitore);

		
		
	}
		
		public Competizione getSpecificComp (String code) throws MalformedURLException, JSONException, IOException, ParseException {
			
			Competizione compi=servicecomp.ParserCompetizioni(code);
			
		
			return compi;
			
			
			
		}
		
		
		
		
		public  StatsGeneraliModel GetStats() throws MalformedURLException, JSONException, IOException, ParseException, Exception {
			
			
				 statsgenerali=new StatsGenerali("2019", "2015", "2002");
		
			int massimo=statsgenerali.MassimoNumeroSquadre(false);
			int minimo=statsgenerali.MinimoNumeroSquadre(false);
			double media=statsgenerali.MedioNumeroSquadre(false);
			int mediamesi=statsgenerali.MediaDurataSgMesi(false);
			int mediagiorni=statsgenerali.MediaDurataSggiorni(false);
			double mediasg=statsgenerali.MediaStagioniSalvate(false);
			statsgeneralimodel= new StatsGeneraliModel(massimo,minimo,media,mediamesi,mediagiorni,mediasg);
			

				return statsgeneralimodel;
			
			

			
		}
		
		
		
	
		public StatsGeneraliModel GetFiltri(FilterGenerali filter) throws MalformedURLException, JSONException, IOException, ParseException, com.sun.el.parser.ParseException, java.text.ParseException  {
			
			int massimo=filter.MassimoSquadreFilter();
			int minimo=filter.MinimoSquadreFilter();
			double media=filter.MedioSquadreFilter();
			int mediamesi=filter.MediaDurataFilterMesi();
			int mediagiorni=filter.MediaDurataFilterGiorni();
			double mediasg=filter.MediaStagioniFilter();
			filtergeneralimodel= new StatsGeneraliModel(massimo,minimo,media,mediamesi,mediagiorni,mediasg);
			
					
			return  filtergeneralimodel;
			
		}
		
		
	}

	
	
		
		
		
	
	
	
	
	

