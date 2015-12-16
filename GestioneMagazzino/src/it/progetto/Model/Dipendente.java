package it.progetto.Model;

import it.progetto.DAO.DipendenteDAO;

public class Dipendente extends UtenteRegistrato {

	private String Progettodiappartenenza;
	
	public Dipendente() {
		super();
	}

	public Dipendente(String nome, String cognome, String password,String username, String progettodiappartenenza) {
		super(nome, cognome, username, password);
		Progettodiappartenenza = progettodiappartenenza;
	}

	public String getProgettodiappartenenza() {
		return Progettodiappartenenza;
	}

	public void setProgettodiappartenenza(String progettodiappartenenza) {
		Progettodiappartenenza = progettodiappartenenza;
	}
	
	public boolean isDipendente(UtenteRegistrato u){
	return DipendenteDAO.getInstance().userExists(this);	
	}

//	public boolean login()
//	{
//		return DipendenteDAO.getInstance().userExists(this);
//	}
	
}
