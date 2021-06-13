package filters;




import stats.StatsGenerali;

public class FilterGenerali {
	private String id1;
	private String id2;
	 StatsGenerali statsgenerali;
	/* Costruttore FilterGenerali che prende :
	 * id1 per la prima competizione 
	 * id2 per la seconda competizione
	 * crea oggetto della classe StatsGenerali
	 */
	

	public FilterGenerali(String id1,String id2)  {
		this.id1=id1;
		this.id2=id2;
		this.statsgenerali=new StatsGenerali(id1,id2,"null");
	}
	
	
	 // metodo che restitusce il massimo numero di squadre filtrate chiamando il metodo MassimoNumeroSquadre

public int MassimoSquadreFilter()   {
			
			int massimo=statsgenerali.MassimoNumeroSquadre(true);
			return  massimo;
		}

// metodo che restitusce il minimo numero di squadre filtrate chiamando il metodo MinimoNumeroSquadre


public int MinimoSquadreFilter()  {
	
	int minimo=statsgenerali.MinimoNumeroSquadre(true);
	return  minimo;
	}

//metodo che restitusce il medio numero di squadre filtrate chiamando il metodo MedioNumeroSquadre


public double MedioSquadreFilter()  {
	
	double media=statsgenerali.MedioNumeroSquadre(true);
	return media;
	}
//metodo che restitusce la durata in mesi delle stagioni filtrate chiamando il metodo MediaDurataSgMesi

public int MediaDurataFilterMesi() {	
	int mediadurata=statsgenerali.MediaDurataSgMesi(true);
	return mediadurata;
	}

//metodo che restitusce il resto della durata in gioni  delle stagioni filtrate chiamando il metodo MediaDurataSggiorni

public int MediaDurataFilterGiorni()  {	
	int mediadurata=statsgenerali.MediaDurataSggiorni(true);
	return mediadurata;
	}
//metodo che restitusce il medio numero delle stagioni filtrate chiamando il metodo MediaStagioniSalvate

public double MediaStagioniFilter()  {	
	double mediastagioni=statsgenerali.MediaStagioniSalvate(true);
	return mediastagioni;	
	
}


}
