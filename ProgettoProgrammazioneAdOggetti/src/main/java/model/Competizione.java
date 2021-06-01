package model;

import java.util.HashSet;

public class Competizione {
	private String id;
	private String nomePaese;
	private String nome;
	private HashSet<Squadra> squadraList= new HashSet<>();
	private HashSet<Stagione> stagioneList= new HashSet<>();
	
	public Competizione (String nomePaese , String nome,String id,HashSet<Stagione> stagioneList,HashSet<Squadra> squadraList) {
		this.nomePaese = nomePaese ;
		this.nome = nome;
		this.id=id;
		this.squadraList=squadraList;
		this.stagioneList=stagioneList;
		
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public HashSet<Squadra> getSquadralist() {
		return squadraList;
	}

	public void setSquadralist(HashSet<Squadra> squadraList) {
		this.squadraList = squadraList;
	}

	public HashSet<Stagione> getStagionelist() {
		return stagioneList;
	}

	public void setStagionelist(HashSet<Stagione> stagioneList) {
		this.stagioneList = stagioneList;
	}
	
	
	
	
	
}
