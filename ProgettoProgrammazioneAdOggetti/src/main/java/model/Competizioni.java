package model;

public class Competizioni {
private int id;
private String Nome_Paese;
private String Nome_Competizione;
private String Data_Inizio;
private String Data_Fine;
private String Vincitore;

 /*Costruttore Competizioni che prende :
 * 1) id della competizione 
 * 2) il nome del paese 
 * 3) il nome della competizione 
 * 4) data inizio della stagione
 * 5) data fine della stagione
 * 6) il vencitore della stagione 
 */
public Competizioni(int id, String nome_Paese, String nome_Competizione, String data_Inizio, String data_Fine,
		String vincitore) {
	this.id = id;
	this.Nome_Paese = nome_Paese;
	this.Nome_Competizione = nome_Competizione;
	this.Data_Inizio = data_Inizio;
	this.Data_Fine = data_Fine;
	this.Vincitore = vincitore;
}

//getters e setters per la classe Competizioni	

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNome_Paese() {
	return Nome_Paese;
}

public void setNome_Paese(String nome_Paese) {
	Nome_Paese = nome_Paese;
}

public String getNome_Competizione() {
	return Nome_Competizione;
}

public void setNome_Competizione(String nome_Competizione) {
	Nome_Competizione = nome_Competizione;
}

public String getData_Inizio() {
	return Data_Inizio;
}

public void setData_Inizio(String data_Inizio) {
	Data_Inizio = data_Inizio;
}

public String getData_Fine() {
	return Data_Fine;
}

public void setData_Fine(String data_Fine) {
	Data_Fine = data_Fine;
}

public String getVincitore() {
	return Vincitore;
}

public void setVincitore(String vincitore) {
	Vincitore = vincitore;
}
	


}
