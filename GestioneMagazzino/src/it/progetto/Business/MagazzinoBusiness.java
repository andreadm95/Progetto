package it.progetto.Business;

import java.util.Vector;

import it.progetto.Model.Magazzino;

public class MagazzinoBusiness {
	
private static MagazzinoBusiness instance;
	
	public static MagazzinoBusiness getInstance() {
		   if(instance == null){
			   instance = new MagazzinoBusiness();
			   }
		   return instance;
	}
	
	public Vector<String[]> getListaProdottiTot(){
		Magazzino mag=new Magazzino();
		return mag.getListaProdottiTot();
	}
	 
	public Vector<String[]> getListaProdottiVicini(int sede) {
		Magazzino mag=new Magazzino(sede);
		return mag.getListaProdottiVicini();
	}
	
	public Vector<String[]> getListaProdottiLontano(int sede) {
		Magazzino mag=new Magazzino(sede);
		return mag.getListaProdottiLontano();
	}

	public Vector<String[]> getListaOrdiniPendenti(int codmag) {
		Magazzino mag=new Magazzino(codmag);
		return mag.getListaOrdiniPendenti();
	}

}
