package service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Competizione;
import model.Squadra;
import model.Stagione;

public class ParserJson extends APICall  {

	Squadra s;
	Stagione sg;
	Competizione comp;

public ParserJson() {
	
	
}


public ArrayList<Squadra> ParserSquadre () throws JSONException, MalformedURLException, IOException, ParseException {
	
	ArrayList<Squadra> squadraList=new ArrayList<>();
	writefile("https://api.football-data.org/v2/competitions/2019/standings");
			JSONObject competizione =new JSONObject (readfile());
			JSONArray standings = competizione.getJSONArray("standings");
			JSONObject competizione2=standings.getJSONObject(0);
			JSONArray Teams = competizione2.getJSONArray("table");
			for(int i=0;i<Teams.length();i++) {
			JSONObject squadra1=Teams.getJSONObject(i);
			JSONObject dati=squadra1.getJSONObject("team");
			s=new Squadra((int)squadra1.get("position"),(String)dati.get("name"),(int)squadra1.get("won"),(int)squadra1.get("lost"),(int)squadra1.get("goalsFor"),(int)squadra1.get("goalsAgainst"),(int)squadra1.get("goalDifference"));
			squadraList.add(s);
			}
			return squadraList;
			}


public ArrayList<Stagione> ParserStagioni () throws JSONException, MalformedURLException, IOException, ParseException {
	
	ArrayList<Stagione> StagioneList=new ArrayList<>();
	writefile("https://api.football-data.org/v2/competitions/2019");

			JSONObject Stagioneobj =new JSONObject (readfile());
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
			}
		}
			return StagioneList;
}

public Competizione ParserCompetizioni () throws JSONException, MalformedURLException, IOException, ParseException {
	writefile("https://api.football-data.org/v2/competitions/2019");
			JSONObject competizioneobj =new JSONObject (readfile());
			JSONObject area=competizioneobj.getJSONObject("area");
			comp=new Competizione ((String)area.get("name"),(String)competizioneobj.get("name"),(int)competizioneobj.get("id"),ParserStagioni(),ParserSquadre());
			return comp;
			}







}
