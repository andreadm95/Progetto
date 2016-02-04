package it.progetto.Model;

import java.util.Vector;

import it.progetto.DAO.MagazzinoDAO;
import it.progetto.DAO.OrdineDAO;

public class Magazzino {
	
private int idMagazzino;

	public Magazzino(){}
	
	public Magazzino(int id){
		idMagazzino=id;
	}
	
	public Vector<String[]> getListaProdottiTot(){
		return MagazzinoDAO.getInstance().fornisciCatalogo();
	}
	 
	public Vector<String[]> getListaProdottiVicini() {
		return MagazzinoDAO.getInstance().FornisciCatalogoVicino(getIdMagazzino());
	}
	
	public Vector<String[]> getListaProdottiLontano() {
		return MagazzinoDAO.getInstance().FornisciCatalogoLontano(getIdMagazzino());
	}

	public Vector<String[]> getListaOrdiniPendenti() {
		return OrdineDAO.getInstance().fornisciOrdiniPendenti(getIdMagazzino());
	}

	public int getIdMagazzino() {
		return idMagazzino;
	}

	public void setIdMagazzino(int idMagazzino) {
		this.idMagazzino = idMagazzino;
	}
}
