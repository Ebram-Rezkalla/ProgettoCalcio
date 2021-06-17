package service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import exception.BodyException;
import exception.NotFound;
import model.Competizione;
import model.Squadra;
import model.Stagione;

public class ParserJson extends APICall  {

	Squadra s;
	Stagione sg;
	Competizione comp;
	
	// questa classe ha il compito di effetuare il parsing dal file json e trasformali in java object con l'aiuto delle classi model

public ParserJson() {
	
}

// chiama il metodo readfile ed effetua il parsing restituendo un ArrayList di tipo squadre

public ArrayList<Squadra> ParserSquadre (String codice,int tipo)   {
	
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
				}
			return squadraList;
			}

//chiama il metodo readfile ed effetua il parsing restituendo un ArrayList di tipo stagione
public ArrayList<Stagione> ParserStagioni (String codice)   {
	
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
				
			}
			return StagioneList;
		}
			
//chiama i metodi readfile,ParserSquadre,ParserStagioni ed effetua il parsing restituendo oggetto competizione in cui sono present le squadre e le stagioni
public Competizione ParserCompetizioni (String codice)   {
	int n= GetNumber (codice);
		JSONArray stagionitot;
		
			try {
				stagionitot = new JSONArray(readfile("datistagioni.json"));
			
			
			JSONObject competizioneobj;
			competizioneobj = stagionitot.getJSONObject(n);
			JSONObject area;
			area = competizioneobj.getJSONObject("area");
			comp=new Competizione ((String)area.get("name"),(String)competizioneobj.get("name"),(int)competizioneobj.get("id"),ParserStagioni(codice),ParserSquadre(codice,0));
			} catch (JSONException e) {

			}
			return comp;
			}

 // Questo metodo prende una stringa che e' il codice e ristitusce un numero che verra dopo utilizzato in altri metodi 
 // verra' lanciata l'eccezione BodyException quando l'utente scrive il body in modo errato
 //verra' lanciata l'eccezione NotFound quando l'utente non inserisce l'id oppure id nullo

 public int GetNumber (String codice){
	 if(codice==null)
		 throw new BodyException("Errore, Puoi Usare Solo id1 e id2 Come Key.");
	 if (codice.isEmpty())
		 throw new NotFound("ID Non Inserito, Si Prega di Inserire Un ID");
	 if (codice.equals("2019"))
		 return 0;
	 
	 if (codice.equals("2015"))
		 return 1;
	 
	 if (codice.equals("2002"))
		 return 2;
	 else throw new NotFound("ID Non Corretto, Si Prega di Usare le ID Disponibili(2002,2015,2019).");

 }

}
