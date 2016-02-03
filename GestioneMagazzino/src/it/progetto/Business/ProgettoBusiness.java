package it.progetto.Business;

import it.progetto.Model.Progetto;

public class ProgettoBusiness {

	private static ProgettoBusiness instance;
	
	public static ProgettoBusiness getInstance(){
		if(instance == null){
			   instance = new ProgettoBusiness();
			   }
		   return instance;
	}
	
	public int Recuperoid(String progetto){
		Progetto a=new Progetto(progetto);
		return a.recuperoid(progetto);
	}
	
	public void aggiornaSpesa(int idprogetto,float spesa){
		Progetto a=new Progetto(idprogetto);
		a.aggiornaSpesa(spesa);
	}
}
