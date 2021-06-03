package service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;

import model.Competizione;
import model.Stagione;

public class ServiceCalcio {
	
	ParserJson servicecomp=new ParserJson();

	ArrayList<String> out=new ArrayList<String>();

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
		
		
	
		
		
		
	}

	
	
		
		
		
	
	
	
	
	

