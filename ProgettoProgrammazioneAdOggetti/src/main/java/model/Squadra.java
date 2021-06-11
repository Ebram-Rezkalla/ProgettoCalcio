package model;

public class Squadra {
	private int posizione;
	private String nomeSquadra;
	private int vincite;
	private int perdite;
	private int goalsFor;
	private int goalsAgainst;
	private int goalDifferenza;
	
	// Costruttore Squadra

	public Squadra(int posizione,String nomesquadra, int vincite,int perdite,int goalsFor,int goalsAgainst,int goalDifferenza) {

	this.posizione=posizione;
	this.nomeSquadra=nomesquadra;
	this.vincite=vincite;
	this.perdite=perdite;
	this.goalsFor=goalsFor;
	this.goalsAgainst=goalsAgainst;
	this.goalDifferenza=goalDifferenza;
	
	// getters e setters pel la classe Squadra
}

	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	public String getNomesquadra() {
		return nomeSquadra;
	}

	public void setNomesquadra(String nomesquadra) {
		this.nomeSquadra = nomesquadra;
	}

	public int getVincite() {
		return vincite;
	}

	public void setVincite(int vincite) {
		this.vincite = vincite;
	}

	public int getPerdite() {
		return perdite;
	}

	public void setPerdite(int perdite) {
		this.perdite = perdite;
	}

	public int getGoalsFor() {
		return goalsFor;
	}

	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public int getGoalDifferenza() {
		return goalDifferenza;
	}

	public void setGoalDifferenza(int goalDifferenza) {
		this.goalDifferenza = goalDifferenza;
	}
	



}