package model;

import java.util.ArrayList;
import java.util.HashSet;

public class Competizione {
	private int id;
	private String nomePaese;
	private String nome;
	private ArrayList<Squadra> squadraList= new ArrayList<>();
	private ArrayList<Stagione> stagioneList= new ArrayList<>();
	
	/*Costruttore Competizione che prende :
	 * 1) il nome del paese 
	 * 2) il nome della competizione 
	 * 3) le stagioni salvate della competizione 
	 * 4) le squadre partecipanti 
	 * 5) id della competizione 
	 */
	
	public Competizione (String nomePaese , String nome,int id,ArrayList<Stagione> stagioneList,ArrayList<Squadra> squadraList) {
		this.nomePaese = nomePaese ;
		this.nome = nome;
		this.id=id;
		this.squadraList=squadraList;
		this.stagioneList=stagioneList;
		
	// getters e setters per la classe Competizione	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomepaese() {
		return nomePaese;
	}

	public void setNomepaese(String nomePaese) {
		this.nomePaese = nomePaese;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Squadra> getSquadralist() {
		return squadraList;
	}

	public void setSquadralist(ArrayList<Squadra> squadraList) {
		this.squadraList = squadraList;
	}

	public ArrayList<Stagione> getStagionelist() {
		return stagioneList;
	}

	public void setStagionelist(ArrayList<Stagione> stagioneList) {
		this.stagioneList = stagioneList;
	}
	
	
	
	
	
}
