package it.progetto.Model;

import it.progetto.DAO.DipendenteDAO;

public class Dipendente extends UtenteRegistrato {

	Float Spesa;
	
	public Dipendente() {
		super();
	}

	public Dipendente(String nome, String cognome, String password,String username, Float spesa) {
		super(nome, cognome, username, password);
		Spesa = spesa;
	}
	
	public Dipendente(String username, String password) {
		// TODO Auto-generated constructor stub
		super(username,password);
	}

	public Float getSpesa() {
		return Spesa;
	}

	public void setSpesa(Float spesa) {
		Spesa = spesa;
	}
	
	public boolean isDipendente(){
		return DipendenteDAO.getInstance().DipendenteExists(this);	
	}
	
	public Object RecuperaInfo(){
		return DipendenteDAO.getInstance().PrelevaInfo(this);
	}
	
}
