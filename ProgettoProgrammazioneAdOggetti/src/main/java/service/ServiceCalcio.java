package service;

import java.util.ArrayList;


import exception.NotFound;
import filters.FilterCompetizione;
import filters.FilterGenerali;
import model.Competizione;
import model.Competizioni;
import model.Stagione;
import model.StatsCompetizioniModel;
import model.StatsGeneraliModel;
import stats.StatsCompetizione;
import stats.StatsGenerali;

public class ServiceCalcio {
	
	private ParserJson servicecomp=new ParserJson();
	private StatsGenerali statsgenerali;
	private StatsGeneraliModel statsgeneralimodel;
	private StatsGeneraliModel filtergeneralimodel;
	//private ArrayList<Competizioni> out=new ArrayList<Competizioni>();
	private ArrayList<Stagione> staglist=new ArrayList<Stagione>();
	 
	public ServiceCalcio () {
			
		
	}
	
	
	public ArrayList<Competizioni>getall() {
		
		ArrayList<Competizioni> out=new ArrayList<Competizioni>();

		out.add(getcompetizione("2019"));
		out.add(getcompetizione("2015"));
		out.add(getcompetizione("2002"));
		
		
		return out;
		}

		
	public Competizioni getcompetizione(String code)  {
		Competizione compi=servicecomp.ParserCompetizioni(code);
		int id=compi.getId();
		String nomepaese=compi.getNomepaese();
		String nome=compi.getNome();
	staglist=compi.getStagionelist();
	Stagione stag=staglist.get(0);
	String datainizio=stag.getDataInizio();
	String datafine=stag.getDataFine();
	String vincitore=stag.getVincitore();
	Competizioni competizioni= new Competizioni(id,nomepaese,nome,datainizio,datafine,vincitore);
	
	
	return competizioni;

		
		
	}
		
		public Competizione getSpecificComp (String code)    {
			
			Competizione compi=servicecomp.ParserCompetizioni(code);
			
		
			return compi;
			
			
			
		}
		
		
		
		
		public  StatsGeneraliModel GetStats(){
			
			
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
		
		public StatsGeneraliModel GetFiltri(FilterGenerali filter)  {
			
			int massimo=filter.MassimoSquadreFilter();
			int minimo=filter.MinimoSquadreFilter();
			double media=filter.MedioSquadreFilter();
			int mediamesi=filter.MediaDurataFilterMesi();
			int mediagiorni=filter.MediaDurataFilterGiorni();
			double mediasg=filter.MediaStagioniFilter();
			filtergeneralimodel= new StatsGeneraliModel(massimo,minimo,media,mediamesi,mediagiorni,mediasg);
			
					
			return  filtergeneralimodel;
			
		}
		
		public StatsCompetizioniModel  GetStatsComp(String id)  {
			
			StatsCompetizione statscompetizione=new StatsCompetizione(id,"Total",0,"p");
			int numerostagionesalvate= statscompetizione.NumeroStagioneSalvate();
			ArrayList<String> migliorattaco= statscompetizione.SquadraMigliorAttacco();
			ArrayList<String> migliordifesa= statscompetizione.SquadraMigliorDifesa();
			ArrayList<String> migliordifferenza =statscompetizione.SquadraMigliorDifferenza();
			ArrayList<String> maggiorvincite =statscompetizione.SquadraMaggiorVincite() ;
			ArrayList<String> maggiorperdite =statscompetizione.SquadraMaggiorPerdite();
			
			StatsCompetizioniModel statscompetizionimodel = new StatsCompetizioniModel(numerostagionesalvate,migliorattaco,migliordifesa,migliordifferenza,maggiorvincite,maggiorperdite);
			
			return statscompetizionimodel;	
		}

		public StatsCompetizioniModel  GetFiltriComp(FilterCompetizione filtercompetizioni) throws NotFound {
			
			//StatsCompetizione statscompetizione=new StatsCompetizione(id,"Total",0,"p");
			ArrayList<String> migliorattaco= filtercompetizioni.SquadraMigliorAttacoFilter();
			ArrayList<String> migliordifesa= filtercompetizioni.SquadraMigliorDifesaFilter();
			ArrayList<String> migliordifferenza =filtercompetizioni.SquadraMigliorDifferenzaFilter();
			ArrayList<String> maggiorvincite =filtercompetizioni.SquadraMaggiorVinciteFilter() ;
			ArrayList<String> maggiorperdite =filtercompetizioni.SquadraMaggiorPerditeFilter();
			int numerostagionesalvate= filtercompetizioni.NumeroStagioneSalvate();

			StatsCompetizioniModel statscompetizionimodel = new StatsCompetizioniModel(numerostagionesalvate,migliorattaco,migliordifesa,migliordifferenza,maggiorvincite,maggiorperdite);
			
			return statscompetizionimodel;	
		}
	}

	
	
		
		
		
	
	
	
	
	

