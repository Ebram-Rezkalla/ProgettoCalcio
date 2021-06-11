package filters;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;

import com.sun.el.parser.ParseException;

import stats.StatsGenerali;

public class FilterGenerali {
	String id1;
	String id2;
	StatsGenerali statsgenerali;
	
	public FilterGenerali(String id1,String id2)  {
		this.id1=id1;
		this.id2=id2;
		this.statsgenerali=new StatsGenerali(id1,id2,"null");
	}
	
	
	
public int MassimoSquadreFilter()   {
			
			int massimo=statsgenerali.MassimoNumeroSquadre(true);
			return  massimo;
		}



public int MinimoSquadreFilter()  {
	
	int minimo=statsgenerali.MinimoNumeroSquadre(true);
	return  minimo;
	}


public double MedioSquadreFilter()  {
	
	double media=statsgenerali.MedioNumeroSquadre(true);
	return media;
	}

public int MediaDurataFilterMesi() {
	
	int mediadurata=statsgenerali.MediaDurataSgMesi(true);
	return mediadurata;
	}

public int MediaDurataFilterGiorni()  {
	
	int mediadurata=statsgenerali.MediaDurataSggiorni(true);
	return mediadurata;
	}

public double MediaStagioniFilter()  {
	
	double mediastagioni=statsgenerali.MediaStagioniSalvate(true);
	return mediastagioni;
	
	
	
}


}
