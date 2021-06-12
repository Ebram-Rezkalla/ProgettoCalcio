package model;

public class Stagione {
	private String dataInizio;
	private String dataFine;
	private String vincitore;
	
	/* Costruttore Stagione che prende :
	 * 1) data inzio stagione 
	 * 2) data fine stagione 
	 * 3) il vincitore della stagione 
	 */
	
	
	public Stagione (String dataInizio, String dataFine, String vincitore) {
		this.dataInizio=dataInizio;
		this.dataFine=dataFine;
		this.vincitore=vincitore;
		
		// getters e setters pel la classe Stagione

}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getVincitore() {
		return vincitore;
	}

	public void setVincitore(String vincitore) {
		this.vincitore = vincitore;
	}		
	

}
