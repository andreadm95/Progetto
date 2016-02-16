package it.progetto.Model;

import java.util.Vector;

import it.progetto.DAO.CapoProgettoDAO;

public class CapoProgetto extends UtenteRegistrato {
	
	public CapoProgetto() {
		super();
	}
	
	public CapoProgetto(String username, String password) {
		super(username,password);
	}

	public CapoProgetto(int id, String nome, String cognome, String password, String username) {
		super(id,nome, cognome, username,password);
	}
	
	public boolean isCapoProgetto(){
		return CapoProgettoDAO.getInstance().CapoProgettoExists(this);	
	}
	
	public Object RecuperaInfo(){
		return CapoProgettoDAO.getInstance().PrelevaInfo(this);
	}
	
	public Vector<String[]> OrdinaSpeseProgetto(){
		return CapoProgettoDAO.getInstance().OrdinaSpeseProgetto(getId());
	}
	
	public Vector<String[]> OrdinaSpeseDipendente(){
		return CapoProgettoDAO.getInstance().OrdinaSpeseDipendente(getId());
	}
}
