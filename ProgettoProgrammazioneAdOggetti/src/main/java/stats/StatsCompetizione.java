package stats;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONException;

import exception.BodyException;
import exception.IdNotFound;
import model.Squadra;
import model.Stagione;
import service.ParserJson;

public class StatsCompetizione {
	protected ParserJson parserjson = new ParserJson();
	
   ArrayList<Stagione> sta=new ArrayList<Stagione>();

   protected ArrayList<Squadra> sq=new ArrayList<Squadra>();

   int ndato;
	int m=0;
	String id;
	String tipo;
	int n;
	String pu;
	public StatsCompetizione(String id,String tipo,int n,String pu) throws MalformedURLException, JSONException, IOException, ParseException {
		
		this.id=id;
		this.tipo=tipo;
		this.n=n;
		this.pu=pu;	

	}



	public int NumeroStagioneSalvate() throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound {
		sta = parserjson.ParserStagioni(id);

		int numerosta = sta.size();
		
		return numerosta;
	}
	

	
public int  GetNumberTipo(String tipo) {
		if(tipo==null)
			throw new BodyException("Errore di Scrittura Body, Puoi Usare Solo la Parola(tipo) come Key ");
		if (tipo.equals("Total"))
			 return 0;
		 
		 if (tipo.equals("Home"))
			 return 1;
		 
		 if (tipo.equals("Away"))
			 return 2;
		 else throw new BodyException("Tipo Inserito Non Esistente, Puoi Usare Solamente Total-Home-Away");
		}
	
	public void StatsFilter() {
		ndato=sq.size();
		if (!(n==0)) {
			if(pu.equals("p"))
				ndato=n;
			else m=(sq.size()-n);
		}
		
		
	}
	
	
	public ArrayList<String> SquadraMigliorAttacco () throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound {
		sq = parserjson.ParserSquadre(id,GetNumberTipo(tipo));
		StatsFilter();
	ArrayList<String> attaco= new ArrayList<String>();
	int big=sq.get(m).getGoalsFor();

		for(int i=m+1;i<ndato;i++) {
			if(sq.get(i).getGoalsFor()>big)
			big=sq.get(i).getGoalsFor();
		}
		for(int i=m;i<ndato;i++) {
			if (sq.get(i).getGoalsFor()==big)
				attaco.add(sq.get(i).getNomesquadra());
				}
		return attaco;
}
	public ArrayList<String> SquadraMigliorDifesa () throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound {
		sq = parserjson.ParserSquadre(id,GetNumberTipo(tipo));
		StatsFilter();

		ArrayList<String> difesa= new ArrayList<String>();
		int small=sq.get(m).getGoalsAgainst();
			for(int i=m+1;i<ndato;i++) {
				if(sq.get(i).getGoalsAgainst()<small)
				small=sq.get(i).getGoalsAgainst();	
			}
			for(int i=m;i<ndato;i++) {
				if (sq.get(i).getGoalsAgainst()==small)
					difesa.add(sq.get(i).getNomesquadra());
					}
			return difesa;
	}
	
	public ArrayList<String> SquadraMigliorDifferenza () throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound {
		sq = parserjson.ParserSquadre(id,GetNumberTipo(tipo));
		StatsFilter();

		ArrayList<String> differenza= new ArrayList<String>();
		int big=sq.get(m).getGoalDifferenza();
			for(int i=m+1;i<ndato;i++) {
				if(sq.get(i).getGoalDifferenza()>big)
				big=sq.get(i).getGoalDifferenza();	
			}
			for(int i=m;i<ndato;i++) {
				if (sq.get(i).getGoalDifferenza()==big)
					differenza.add(sq.get(i).getNomesquadra());
					}
			return differenza;
		
	}
	
	
	public ArrayList<String> SquadraMaggiorVincite () throws MalformedURLException, JSONException, IOException, ParseException, IdNotFound {
		sq = parserjson.ParserSquadre(id,GetNumberTipo(tipo));
		StatsFilter();

		ArrayList<String> vincite= new ArrayList<String>();
		int big=sq.get(m).getVincite();
			for(int i=m+1;i<ndato;i++) {
				if(sq.get(i).getVincite()>big)
				big=sq.get(i).getVincite();	
			}
			for(int i=m;i<ndato;i++) {
				if (sq.get(i).getVincite()==big)
					vincite.add(sq.get(i).getNomesquadra());
					}
			return vincite;
		
	}
	
	public ArrayList<String> SquadraMaggiorPerdite () throws  MalformedURLException, JSONException, IOException, ParseException, IdNotFound {
		sq = parserjson.ParserSquadre(id,GetNumberTipo(tipo));
		StatsFilter();

		ArrayList<String> perdite= new ArrayList<String>();
		int big=sq.get(m).getPerdite();
			for(int i=m+1;i<ndato;i++) {
				if(sq.get(i).getPerdite()>big)
				big=sq.get(i).getPerdite();	
			}
			for(int i=m;i<ndato;i++) {
				if (sq.get(i).getPerdite()==big)
					perdite.add(sq.get(i).getNomesquadra());
					}
			return perdite;
	}
	}

