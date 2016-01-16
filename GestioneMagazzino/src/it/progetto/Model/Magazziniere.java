package it.progetto.Model;

import it.progetto.DAO.MagazziniereDAO;

public class Magazziniere extends UtenteRegistrato {

	private int MagazzinoAppartenenza;

	public Magazziniere(){
		super();
	}
	
	public Magazziniere(String username, String password) {
		super(username,password);
	}

	public Magazziniere(int id, String nome, String cognome, String password, String username, int magazzinoAppartenenza) {
		super(id,nome, cognome, username, password);
		MagazzinoAppartenenza = magazzinoAppartenenza;
	}

	public int getMagazzinoAppartenenza() {
		return MagazzinoAppartenenza;
	}

	public void setMagazzinoAppartenenza(int magazzinoAppartenenza) {
		MagazzinoAppartenenza = magazzinoAppartenenza;
	}
	
	public boolean isMagazziniere(){
		return MagazziniereDAO.getInstance().MagazziniereExists(this);	
	}
	
	public Object RecuperaInfo(){
		return MagazziniereDAO.getInstance().PrelevaInfo(this);
	}
}
