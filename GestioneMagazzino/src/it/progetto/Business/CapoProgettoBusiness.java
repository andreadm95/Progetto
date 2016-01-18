package it.progetto.Business;

import it.progetto.Model.CapoProgetto;
import it.progetto.Model.Sessione;

public class CapoProgettoBusiness {
	
private static CapoProgettoBusiness instance;
	
	public static CapoProgettoBusiness getInstance() {
		   if(instance == null){
			   instance = new CapoProgettoBusiness();
			   }
		   return instance;
	}

	public boolean isCapoProgetto(String username,String password){
		CapoProgetto u= new CapoProgetto(username,password);
		return u.isCapoProgetto();
	}
	
	public void RecuperoInfo(String username,String password){
		CapoProgetto c= new CapoProgetto(username,password);
		Sessione.getInstance().session.put("utente_corrente", c.RecuperaInfo());
	}
}
