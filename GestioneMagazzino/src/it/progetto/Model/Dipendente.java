package it.progetto.Model;

import java.util.Vector;

import it.progetto.DAO.DipendenteDAO;

public class Dipendente extends UtenteRegistrato {

	Float Spesa;
	
	public Dipendente() {
		super();
	}

	public Dipendente(int id, String nome, String cognome, String password,String username, Float spesa) {
		super(id,nome, cognome, username, password);
		Spesa = spesa;
	}
	
	public Dipendente(String username, String password) {
		// TODO Auto-generated constructor stub
		super(username,password);
	}
	
	public Dipendente(int id) {
		// TODO Auto-generated constructor stub
		super(id);
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
	
	public Vector<String> progettiDipendente(int id_dip){
		return DipendenteDAO.getInstance().fornisciProgettiDelDipendente(id_dip);
	}

	public void aggiornaSpesa(float spesa) {
		// TODO Auto-generated method stub
		DipendenteDAO.getInstance().aggiornaSpesa(getId(),spesa);
	}
	
}
