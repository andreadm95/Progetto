package it.progetto.Model;

import java.util.ArrayList;
import it.progetto.DAO.MagazzinoDAO;
import it.progetto.DAO.OrdineDAO;

public class Magazzino {

	 private ArrayList<Prodotto> ListaProdotti;
	 private ArrayList<Ordine> ListaOrdiniPendenti;
	 private int CodiceMagazzino;
	 
	public ArrayList<Prodotto> getListaProdotti() {
		return MagazzinoDAO.getInstance().fornisciCatalogoVicino(CodiceMagazzino);
	}
	public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {
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
