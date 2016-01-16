package it.progetto.Business;

import it.progetto.Model.Dipendente;

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
	
	public Object RecuperoInfo(String username,String password){
		Dipendente d= new Dipendente(username,password);
		return d.RecuperaInfo();
	}

}
