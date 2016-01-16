package it.progetto.Model;

import java.util.ArrayList;
import java.util.Vector;

import it.progetto.DAO.MagazzinoDAO;
import it.progetto.DAO.OrdineDAO;

public class Magazzino {

private static Magazzino instance;
	
	public static Magazzino getInstance() {
		   if(instance == null){
			   instance = new Magazzino();
			   }
		   return instance;
	}
	 
	public Vector<String[]> getListaProdottiVicini(int sede) {
		return MagazzinoDAO.getInstance().FornisciCatalogoVicino(sede);
	}
	
	public Vector<String[]> getListaProdottiLontano(int sede) {
		return MagazzinoDAO.getInstance().FornisciCatalogoLontano(sede);
	}

	public ArrayList<Ordine> getListaOrdiniPendenti() {
		return OrdineDAO.getInstance().fornisciOrdiniPendenti();
	}
}
