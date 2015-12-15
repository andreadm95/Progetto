package it.progetto.Model;

import java.util.ArrayList;

public class CapoProgetto extends UtenteRegistrato {

	private ArrayList<Progetto> ListaProgettiACarico;

	public ArrayList<Progetto> getListaProgettiACarico() {
		return ListaProgettiACarico;
	}

	public void setListaProgettiACarico(ArrayList<Progetto> listaProgettiACarico) {
		ListaProgettiACarico = listaProgettiACarico;
	}

	
}
