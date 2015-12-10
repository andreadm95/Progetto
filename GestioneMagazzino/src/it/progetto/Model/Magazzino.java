package it.progetto.Model;

import java.util.ArrayList;

public class Magazzino {

	 private ArrayList<Prodotto> ListaProdotti;
	 private ArrayList<Ordine> ListaOrdiniPendenti;
	 private int CodiceMagazzino;
	 
	public ArrayList<Prodotto> getListaProdotti() {
		return ListaProdotti;
	}
	public ArrayList<Ordine> getListaOrdiniPendenti() {
		return ListaOrdiniPendenti;
	}
	public int getCodiceMagazzino() {
		return CodiceMagazzino;
	}
	
}
