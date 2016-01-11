package it.progetto.Model;

public class Magazziniere extends UtenteRegistrato {

	private int MagazzinoAppartenenza;

	public Magazziniere() {
		super();
	}

	public Magazziniere(String nome, String cognome, String password, String username, int magazzinoAppartenenza) {
		super(nome, cognome, username, password);
		MagazzinoAppartenenza = magazzinoAppartenenza;
	}

	public int getMagazzinoAppartenenza() {
		return MagazzinoAppartenenza;
	}

	public void setMagazzinoAppartenenza(int magazzinoAppartenenza) {
		MagazzinoAppartenenza = magazzinoAppartenenza;
	}
}
