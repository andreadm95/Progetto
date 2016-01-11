package it.progetto.Business;

import it.progetto.Model.UtenteRegistrato;

public class UtenteRegistratoBusiness {

private static UtenteRegistratoBusiness instance;
	
	//SINGLETON
	public static UtenteRegistratoBusiness getInstance()
	{
		if(instance == null)
			instance = new UtenteRegistratoBusiness();
		return instance;
	}
	
	public boolean verificaLogin(UtenteRegistrato p)
	{
		return p.login();
	}
	

}
