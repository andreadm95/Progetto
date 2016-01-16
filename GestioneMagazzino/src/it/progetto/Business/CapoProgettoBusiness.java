package it.progetto.Business;

import it.progetto.Model.CapoProgetto;

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
	
	public Object RecuperoInfo(String username,String password){
		CapoProgetto c= new CapoProgetto(username,password);
		return c.RecuperaInfo();
	}
}
