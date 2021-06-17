package stats;

import java.util.ArrayList;
import exception.BodyException;
import exception.NotFound;
import model.Squadra;
import model.Stagione;
import service.ParserJson;

public class StatsCompetizione {
	protected ParserJson parserjson = new ParserJson();
	protected ArrayList<Squadra> sq=new ArrayList<Squadra>();
	 ArrayList<Stagione> sta=new ArrayList<Stagione>();


	 int ndato;
	 int m=0;
	 String id;
	 String tipo;
	 int n;
	 String pu;

	/* Costruttore StatsCompetizione che prende:
	 * 1) tipo della partita richiesto
	 * 2) id della competizione disedirata
	 * 3) il numero disedirato di squadre 
	 * 4) "pu" prime o ultime squadre in base alla posizione 
	 */

	public StatsCompetizione(String id,String tipo,int n,String pu)  {		
		this.id=id;
		this.tipo=tipo;
		this.n=n;
		this.pu=pu;	

	}

//metodo che restituisce il numero delle stagioni salvate 

	public int NumeroStagioneSalvate()  {
		
		sta = parserjson.ParserStagioni(id);

		int numerosta = sta.size();
		
		return numerosta;
	}
	
/*metodo che restituice il tipo delle partite  e verifica anche la correttezza della scrittura del tipo 
 * nel caso in cui l'utente sbaglia la  scrittura del key "tipo" manda l'eccezione di BodyException
 * nel caso in cui l'utente sbaglia ad inserire il tipo della partita  manda l'eccezione di NotFound
 */
	
public int  GetNumberTipo(String tipo) {
		if(tipo==null)
			throw new BodyException("Errore di Scrittura Body, Puoi Usare Solo la Parola(tipo) come Key ");
		if (tipo.equals("Total"))
			 return 0;
		 
		 if (tipo.equals("Home"))
			 return 1;
		 
		 if (tipo.equals("Away"))
			 return 2;
		 else throw new NotFound("Tipo Inserito Non Corretto,Si Prega di Usare Solamente(Total,Home,Away)");
		}
 
// metodo ausiliaro per la classe filter 
	
	public void StatsFilter() {
		ndato=sq.size();
		if (!(n==0)) {
			if(pu.equals("p"))
				ndato=n;
			else m=(sq.size()-n);
		}	
	}
	
	// metodo che restituisce le squadre che hanno il mioglior attacco 
	
	public ArrayList<String> SquadraMigliorAttacco ()  {
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
	
	// metodo che restituisce le squadre che hanno la  mioglior difesa

	public ArrayList<String> SquadraMigliorDifesa () {
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

	// metodo che restituisce le squadre che hanno la miglior differenza goal
	
	public ArrayList<String> SquadraMigliorDifferenza ()  {
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
	
	// metodo che restituisce le squadre che hanno le maggior vincite
	
	
	public ArrayList<String> SquadraMaggiorVincite ()  {
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
	// metodo che restituisce le squadre che hanno le maggior perdite 
	
	public ArrayList<String> SquadraMaggiorPerdite ()  {
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

