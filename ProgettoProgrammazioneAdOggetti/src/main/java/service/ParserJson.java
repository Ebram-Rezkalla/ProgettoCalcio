package service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import exception.IdNotFound;
import model.Competizione;
import model.Squadra;
import model.Stagione;

public class ParserJson extends APICall  {

	Squadra s;
	Stagione sg;
	Competizione comp;

public ParserJson() {
	
	
}


public ArrayList<Squadra> ParserSquadre (String codice,int tipo) throws IdNotFound  {
	
	ArrayList<Squadra> squadraList=new ArrayList<>();
	int n= GetNumber (codice);
			
			JSONArray squadretot;
			try {
				squadretot = new JSONArray(readfile("datisquadre.json"));
			
			JSONObject competizione =squadretot.getJSONObject(n);
			JSONArray standings = competizione.getJSONArray("standings");
			JSONObject competizione2=standings.getJSONObject(tipo);
			JSONArray Teams = competizione2.getJSONArray("table");
			for(int i=0;i<Teams.length();i++) {
			JSONObject squadra1=Teams.getJSONObject(i);
			JSONObject dati=squadra1.getJSONObject("team");
			s=new Squadra((int)squadra1.get("position"),(String)dati.get("name"),(int)squadra1.get("won"),(int)squadra1.get("lost"),(int)squadra1.get("goalsFor"),(int)squadra1.get("goalsAgainst"),(int)squadra1.get("goalDifference"));
			squadraList.add(s);
			}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return squadraList;
			}


public ArrayList<Stagione> ParserStagioni (String codice) throws IdNotFound  {
	
	ArrayList<Stagione> StagioneList=new ArrayList<>();
	int n= GetNumber (codice);
			
			JSONArray stagionitot;
			try {
				stagionitot = new JSONArray(readfile("datistagioni.json"));
			
			JSONObject Stagioneobj = stagionitot.getJSONObject(n);
			JSONArray Stagioni = Stagioneobj.getJSONArray("seasons");
			for(int i=0;i<Stagioni.length();i++) {
			JSONObject Stagione=Stagioni.getJSONObject(i);
			if(Stagione.get("winner").equals(null)) {
			sg=new Stagione((String) Stagione.get("startDate"),(String) Stagione.get("endDate"),"null");
			StagioneList.add(sg);
				}
			else {
			JSONObject vincitore=Stagione.getJSONObject("winner");
			sg=new Stagione((String) Stagione.get("startDate"),(String) Stagione.get("endDate"),(String) vincitore.get("name"));
			StagioneList.add(sg);
			}}} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return StagioneList;
		}
			



public Competizione ParserCompetizioni (String codice) throws IdNotFound  {
	int n= GetNumber (codice);
		JSONArray stagionitot;
		try {
			stagionitot = new JSONArray(readfile("datistagioni.json"));
			JSONObject competizioneobj;
			competizioneobj = stagionitot.getJSONObject(n);
			JSONObject area;
			area = competizioneobj.getJSONObject("area");
			comp=new Competizione ((String)area.get("name"),(String)competizioneobj.get("name"),(int)competizioneobj.get("id"),ParserStagioni(codice),ParserSquadre(codice,0));
			} catch (JSONException | IdNotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return comp;
			}


 public int GetNumber (String codice) throws IdNotFound {
	 
	 if (codice.equals("2019"))
		 return 0;
	 
	 if (codice.equals("2015"))
		 return 1;
	 
	 if (codice.equals("2002"))
		 return 2;
	 else throw new IdNotFound();
 }



}
