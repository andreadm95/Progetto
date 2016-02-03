package it.progetto.Business;

import it.progetto.Model.Dipendente;
import it.progetto.Model.Sessione;

public class DipendenteBusiness {
	
private static DipendenteBusiness instance;
	
	public static DipendenteBusiness getInstance() {
		   if(instance == null){
			   instance = new DipendenteBusiness();
			   }
		   return instance;
	}
	
	public boolean isDipendente(String username,String password){
		Dipendente u= new Dipendente(username,password);
		return u.isDipendente();
	}
	
	public void RecuperoInfo(String username,String password){
		Dipendente d= new Dipendente(username,password);
		Sessione.getInstance().session.put("utente_corrente", d.RecuperaInfo());
	}

	public void aggiornaSpesa(int id, float spesa) {
		// TODO Auto-generated method stub
		Dipendente d=new Dipendente(id);
		d.aggiornaSpesa(spesa);
	}

}
