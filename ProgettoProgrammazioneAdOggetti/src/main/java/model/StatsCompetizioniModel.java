package model;

import java.util.ArrayList;

public class StatsCompetizioniModel {
	
	int Numero_Stagione_Salvate;
	ArrayList<String> Squadra_Miglior_Attacco;
	ArrayList<String> Squadra_Miglior_Difesa;
	ArrayList<String> Squadra_Miglior_Differenza;
	ArrayList<String> Squadra_Maggior_Vincite ;
	ArrayList<String> Squadra_Maggior_Perdite;
	
	/* Costruttore StatsCompetizioniModel che prende :
	 * 1) il numero delle stagagione salvate 
	 * 2) nome delle squadre con il miglior attacco 
	 * 3) nome delle squadre con la miglior difesa  
	 * 4) nome delle squadre con la miglior differenza goal 
	 * 5) nome delle squadre con le maggior vincite 
	 * 6)  nome delle squadre con le maggior perdite
	 */
	public StatsCompetizioniModel(int numero_Stagione_Salvate, ArrayList<String> squadra_Miglior_Attacco,
			ArrayList<String> squadra_Miglior_Difesa, ArrayList<String> squadra_Miglior_Differenza,
			ArrayList<String> squadra_Maggior_Vincite, ArrayList<String> squadra_Maggior_Perdite) {
		super();
		Numero_Stagione_Salvate = numero_Stagione_Salvate;
		Squadra_Miglior_Attacco = squadra_Miglior_Attacco;
		Squadra_Miglior_Difesa = squadra_Miglior_Difesa;
		Squadra_Miglior_Differenza = squadra_Miglior_Differenza;
		Squadra_Maggior_Vincite = squadra_Maggior_Vincite;
		Squadra_Maggior_Perdite = squadra_Maggior_Perdite;
	}
	
	// getters e setters per la classe StatsCompetizioniModel
	public int getNumero_Stagione_Salvate() {
		return Numero_Stagione_Salvate;
	}
	public void setNumero_Stagione_Salvate(int numero_Stagione_Salvate) {
		Numero_Stagione_Salvate = numero_Stagione_Salvate;
	}
	public ArrayList<String> getSquadra_Miglior_Attacco() {
		return Squadra_Miglior_Attacco;
	}
	public void setSquadra_Miglior_Attacco(ArrayList<String> squadra_Miglior_Attacco) {
		Squadra_Miglior_Attacco = squadra_Miglior_Attacco;
	}
	public ArrayList<String> getSquadra_Miglior_Difesa() {
		return Squadra_Miglior_Difesa;
	}
	public void setSquadra_Miglior_Difesa(ArrayList<String> squadra_Miglior_Difesa) {
		Squadra_Miglior_Difesa = squadra_Miglior_Difesa;
	}
	public ArrayList<String> getSquadra_Miglior_Differenza() {
		return Squadra_Miglior_Differenza;
	}
	public void setSquadra_Miglior_Differenza(ArrayList<String> squadra_Miglior_Differenza) {
		Squadra_Miglior_Differenza = squadra_Miglior_Differenza;
	}
	public ArrayList<String> getSquadra_Maggior_Vincite() {
		return Squadra_Maggior_Vincite;
	}
	public void setSquadra_Maggior_Vincite(ArrayList<String> squadra_Maggior_Vincite) {
		Squadra_Maggior_Vincite = squadra_Maggior_Vincite;
	}
	public ArrayList<String> getSquadra_Maggior_Perdite() {
		return Squadra_Maggior_Perdite;
	}
	public void setSquadra_Maggior_Perdite(ArrayList<String> squadra_Maggior_Perdite) {
		Squadra_Maggior_Perdite = squadra_Maggior_Perdite;
	}
	
}
