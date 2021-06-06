package service;

import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Competizione;
import model.Stagione;
import stats.StatsGenerali;

public class ServiceCalcio {
	
	ParserJson servicecomp=new ParserJson();
	StatsGenerali statsgenerali=new StatsGenerali();
	StatsGenerali honksh=new StatsGenerali();

	ArrayList<String> out=new ArrayList<String>();
	ArrayList<String> outone=new ArrayList<String>();


	ArrayList<Stagione> staglist=new ArrayList<Stagione>();
	int cont=1;

	public ServiceCalcio () {
		
		
		
	}
	
	
	public ArrayList<String>getall() throws MalformedURLException, JSONException, IOException, ParseException {
		
		if (cont==1) {
		getcompetizione("2019");
		getcompetizione("2015");
		getcompetizione("2002");
		cont++;
		}
		
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
		
		public int GetStats() throws MalformedURLException, JSONException, IOException, ParseException {
			
		int prova =statsgenerali.MassimoNumeroSquadre("2019", "2002", "2015");
			
			return prova;
			
			
			
			
		}
		
		
		
	
		public JSONObject GetFiltri(JSONObject filtro) throws MalformedURLException, JSONException, IOException, ParseException  {
			
			String id1=(String)filtro.get("id1");
			String id2 =(String)filtro.get("id2");
			int prova2=honksh.MassimoNumeroSquadre(id1,id2,"null");
			JSONObject obj=new JSONObject();
			obj.put("Ebram", prova2);
					
			return  obj;
			
		}
		
		
	}

	
	
		
		
		
	
	
	
	
	

