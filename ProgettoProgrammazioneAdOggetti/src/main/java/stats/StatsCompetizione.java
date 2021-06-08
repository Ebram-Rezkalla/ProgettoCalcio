package stats;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;

import model.Squadra;
import model.Stagione;
import service.ParserJson;

public class StatsCompetizione {
	ParserJson parserjson = new ParserJson();
	
   ArrayList<Stagione> sta=new ArrayList<Stagione>();

   ArrayList<Squadra> sq=new ArrayList<Squadra>();

	
	
	public StatsCompetizione() {
		
	}



	public int NumeroStagioneSalvate(String id) throws MalformedURLException, JSONException, IOException, ParseException {
		sta = parserjson.ParserStagioni(id);

		int numerosta = sta.size();
		
		return numerosta;
	}
	
	public ArrayList<String> SquadraMigliorAttacco (String id,int tipo) throws MalformedURLException, JSONException, IOException, ParseException {
	sq = parserjson.ParserSquadre(id,tipo);
	ArrayList<String> attaco= new ArrayList<String>();
	int big=sq.get(0).getGoalsFor();
		for(int i=1;i<sq.size();i++) {
			if(sq.get(i).getGoalsFor()>big)
			big=sq.get(i).getGoalsFor();	
		}
		for(int i=0;i<sq.size();i++) {
			if (sq.get(i).getGoalsFor()==big)
				attaco.add(sq.get(i).getNomesquadra());
				}
		return attaco;
}
	public ArrayList<String> SquadraMigliorDifesa (String id,int tipo) throws MalformedURLException, JSONException, IOException, ParseException {
		sq = parserjson.ParserSquadre(id,tipo);
		ArrayList<String> difesa= new ArrayList<String>();
		int small=sq.get(0).getGoalsAgainst();
			for(int i=1;i<sq.size();i++) {
				if(sq.get(i).getGoalsAgainst()<small)
				small=sq.get(i).getGoalsAgainst();	
			}
			for(int i=0;i<sq.size();i++) {
				if (sq.get(i).getGoalsAgainst()==small)
					difesa.add(sq.get(i).getNomesquadra());
					}
			return difesa;
	}
	
	public ArrayList<String> SquadraMigliorDifferenza (String id,int tipo) throws MalformedURLException, JSONException, IOException, ParseException {
		sq = parserjson.ParserSquadre(id,tipo);
		ArrayList<String> differenza= new ArrayList<String>();
		int big=sq.get(0).getGoalDifferenza();
			for(int i=1;i<sq.size();i++) {
				if(sq.get(i).getGoalDifferenza()>big)
				big=sq.get(i).getGoalDifferenza();	
			}
			for(int i=0;i<sq.size();i++) {
				if (sq.get(i).getGoalDifferenza()==big)
					differenza.add(sq.get(i).getNomesquadra());
					}
			return differenza;
		
	}
	
	
	public ArrayList<String> SquadraMaggiorVincite (String id,int tipo) throws MalformedURLException, JSONException, IOException, ParseException {
		sq = parserjson.ParserSquadre(id,tipo);
		ArrayList<String> vincite= new ArrayList<String>();
		int big=sq.get(0).getVincite();
			for(int i=1;i<sq.size();i++) {
				if(sq.get(i).getVincite()>big)
				big=sq.get(i).getVincite();	
			}
			for(int i=0;i<sq.size();i++) {
				if (sq.get(i).getVincite()==big)
					vincite.add(sq.get(i).getNomesquadra());
					}
			return vincite;
		
	}
	
	public ArrayList<String> SquadraMaggiorPerdite (String id,int tipo) throws MalformedURLException, JSONException, IOException, ParseException {
		sq = parserjson.ParserSquadre(id,tipo);
		ArrayList<String> perdite= new ArrayList<String>();
		int big=sq.get(0).getPerdite();
			for(int i=1;i<sq.size();i++) {
				if(sq.get(i).getPerdite()>big)
				big=sq.get(i).getPerdite();	
			}
			for(int i=0;i<sq.size();i++) {
				if (sq.get(i).getPerdite()==big)
					perdite.add(sq.get(i).getNomesquadra());
					}
			return perdite;
	}
	}

