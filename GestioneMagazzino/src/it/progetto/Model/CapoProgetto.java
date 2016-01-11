package it.progetto.Model;

import java.util.ArrayList;

public class CapoProgetto extends UtenteRegistrato {

	private ArrayList<Progetto> ListaProgettiACarico;
	
	public CapoProgetto() {
		super();
	}

	public CapoProgetto(String nome, String cognome, String password, String username) {
		super(nome, cognome, username,password);
	}
	
	public CapoProgetto(String nome, String cognome, String password, String username, ArrayList<Progetto> listaProgettiACarico) {
		super(nome, cognome, username, password);
		ListaProgettiACarico = listaProgettiACarico;
	}

	public ArrayList<Progetto> getListaProgettiACarico() {
		return ListaProgettiACarico;
	}

	public void setListaProgettiACarico(ArrayList<Progetto> listaProgettiACarico) {
		ListaProgettiACarico = listaProgettiACarico;
	}
}
