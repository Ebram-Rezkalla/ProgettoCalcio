package model;

import java.util.ArrayList;
import java.util.HashSet;

public class Competizione {
	private int id;
	private String nomePaese;
	private String nome;
	private ArrayList<Squadra> squadraList= new ArrayList<>();
	private ArrayList<Stagione> stagioneList= new ArrayList<>();
	
	public Competizione (String nomePaese , String nome,int id,ArrayList<Stagione> stagioneList,ArrayList<Squadra> squadraList) {
		this.nomePaese = nomePaese ;
		this.nome = nome;
		this.id=id;
		this.squadraList=squadraList;
		this.stagioneList=stagioneList;
		
		
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
