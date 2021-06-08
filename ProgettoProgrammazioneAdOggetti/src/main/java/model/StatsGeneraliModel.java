package model;

public class StatsGeneraliModel {
	 int Massimo_numero_squadre;
	 int Minimo_numero_squadre;
	 double Medio_numero_squadre;
	 int Media_durata_stagione_mesi;
	 int Media_durata_stagione_giorni;
	 double Media_stagioni_salvate;
	public StatsGeneraliModel(int massimo_numero_squadre, int minimo_numero_squadre, double medio_numero_squadre,
			int media_durata_stagione_mesi, int media_durata_stagione_giorni, double media_stagioni_salvate) {
		super();
		Massimo_numero_squadre = massimo_numero_squadre;
		Minimo_numero_squadre = minimo_numero_squadre;
		Medio_numero_squadre = medio_numero_squadre;
		Media_durata_stagione_mesi = media_durata_stagione_mesi;
		Media_durata_stagione_giorni = media_durata_stagione_giorni;
		Media_stagioni_salvate = media_stagioni_salvate;
	}
	public int getMassimo_numero_squadre() {
		return Massimo_numero_squadre;
	}
	public void setMassimo_numero_squadre(int massimo_numero_squadre) {
		Massimo_numero_squadre = massimo_numero_squadre;
	}
	public int getMinimo_numero_squadre() {
		return Minimo_numero_squadre;
	}
	public void setMinimo_numero_squadre(int minimo_numero_squadre) {
		Minimo_numero_squadre = minimo_numero_squadre;
	}
	public double getMedio_numero_squadre() {
		return Medio_numero_squadre;
	}
	public void setMedio_numero_squadre(double medio_numero_squadre) {
		Medio_numero_squadre = medio_numero_squadre;
	}
	public int getMedia_durata_stagione_mesi() {
		return Media_durata_stagione_mesi;
	}
	public void setMedia_durata_stagione_mesi(int media_durata_stagione_mesi) {
		Media_durata_stagione_mesi = media_durata_stagione_mesi;
	}
	public int getMedia_durata_stagione_giorni() {
		return Media_durata_stagione_giorni;
	}
	public void setMedia_durata_stagione_giorni(int media_durata_stagione_giorni) {
		Media_durata_stagione_giorni = media_durata_stagione_giorni;
	}
	public double getMedia_stagioni_salvate() {
		return Media_stagioni_salvate;
	}
	public void setMedia_stagioni_salvate(double media_stagioni_salvate) {
		Media_stagioni_salvate = media_stagioni_salvate;
	}
	 
	
	
	
}

