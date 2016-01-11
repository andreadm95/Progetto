package it.progetto.Model;

import java.util.ArrayList;
import java.util.Vector;

import it.progetto.DAO.MagazzinoDAO;
import it.progetto.DAO.OrdineDAO;

public class Magazzino {

	 private Vector<String[]> ListaProdotti;
	 private ArrayList<Ordine> ListaOrdiniPendenti;
	 private int CodiceMagazzino;
	 
	public Vector<String[]> getListaProdotti() {
		return MagazzinoDAO.getInstance().fornisciCatalogoVicino(CodiceMagazzino);
	}
	
	public void setListaProdotti(Vector<String[]> listaProdotti) {
		ListaProdotti = listaProdotti;
	}

	public ArrayList<Ordine> getListaOrdiniPendenti() {
		return OrdineDAO.getInstance().fornisciOrdiniPendenti();
	}
	public void setListaOrdiniPendenti(ArrayList<Ordine> listaOrdiniPendenti) {
		ListaOrdiniPendenti = listaOrdiniPendenti;
	}
	public int getCodiceMagazzino() {
		return CodiceMagazzino;
	}
	public void setCodiceMagazzino(int codiceMagazzino) {
		CodiceMagazzino = codiceMagazzino;
	}
	 
}
