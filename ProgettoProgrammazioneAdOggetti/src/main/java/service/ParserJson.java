package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Competizione;
import model.Squadra;
import model.Stagione;

public class ParserJson {

	Squadra s;
	Stagione sg;

public ParserJson() {
	
	
}

public String ChiamataAPI(String url) throws MalformedURLException, IOException {
	
	HttpsURLConnection openConnection= (HttpsURLConnection) new URL(url).openConnection();
	openConnection.addRequestProperty("X-Auth-Token", "7c3732db0c284300b743a2f9d193e9e2");
	BufferedReader in=new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
	String dodo= in.readLine();
	if(!dodo.isEmpty());
	return dodo;
	}

public ArrayList<Squadra> ParserSquadre () throws JSONException, MalformedURLException, IOException {
	
	ArrayList<Squadra> squadraList=new ArrayList<>();
			JSONObject competizione =new JSONObject (ChiamataAPI("https://api.football-data.org/v2/competitions/2019/standings"));
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


public ArrayList<Stagione> ParserStagioni () throws JSONException, MalformedURLException, IOException {
	
	ArrayList<Stagione> StagioneList=new ArrayList<>();
			JSONObject Stagioneobj =new JSONObject (ChiamataAPI("https://api.football-data.org/v2/competitions/2019"));
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

/*public Competizione ParserCompetizioni () throws JSONException, MalformedURLException, IOException {
	
			JSONObject competizioneobj =new JSONObject (ChiamataAPI("https://api.football-data.org/v2/competitions/2019"));
			JSONObject area=competizioneobj.getJSONObject("area");
			s=new Squadra((int)squadra1.get("position"),(String)dati.get("name"),(int)squadra1.get("won"),(int)squadra1.get("lost"),(int)squadra1.get("goalsFor"),(int)squadra1.get("goalsAgainst"),(int)squadra1.get("goalDifference"));
			squadraList.add(s);
			
			return squadraList;
			}*/







}
