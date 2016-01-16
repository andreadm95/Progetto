package it.progetto.Model;

import java.util.ArrayList;

import it.progetto.DAO.CapoProgettoDAO;

public class CapoProgetto extends UtenteRegistrato {

	private ArrayList<Progetto> ListaProgettiACarico;
	
	public CapoProgetto() {
		super();
	}
	
	public CapoProgetto(String username, String password) {
		super(username,password);
	}

	public CapoProgetto(int id, String nome, String cognome, String password, String username) {
		super(id,nome, cognome, username,password);
	}
	
	public CapoProgetto(int id, String nome, String cognome, String password, String username, ArrayList<Progetto> listaProgettiACarico) {
		super(id,nome, cognome, username, password);
		ListaProgettiACarico = listaProgettiACarico;
	}

	public ArrayList<Progetto> getListaProgettiACarico() {
		return ListaProgettiACarico;
	}

	public void setListaProgettiACarico(ArrayList<Progetto> listaProgettiACarico) {
		ListaProgettiACarico = listaProgettiACarico;
	}
	
	public boolean isCapoProgetto(){
		return CapoProgettoDAO.getInstance().CapoProgettoExists(this);	
	}
	
	public Object RecuperaInfo(){
		return CapoProgettoDAO.getInstance().PrelevaInfo(this);
	}
}
