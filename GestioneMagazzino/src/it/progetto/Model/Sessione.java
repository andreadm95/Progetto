package it.progetto.Model;

import java.util.HashMap;

import it.progetto.Business.CapoProgettoBusiness;
import it.progetto.Business.DipendenteBusiness;
import it.progetto.Business.MagazziniereBusiness;
import it.progetto.Business.UtenteRegistratoBusiness;

public class Sessione {

	private static Sessione instance;
	public HashMap<String, Object> session = new HashMap<String, Object>();
	
	public static synchronized Sessione getInstance() {
		if(instance == null)
			instance = new Sessione();
		return instance;
	}
	
	public void Autenticazione(String username, String password){
		boolean UtenteEsiste= UtenteRegistratoBusiness.getInstance().verificaLogin(username,password);
		if (UtenteEsiste){
			if(DipendenteBusiness.getInstance().isDipendente(username, password)){DipendenteBusiness.getInstance().RecuperoInfo(username,password);}
			else if(MagazziniereBusiness.getInstance().isMagazziniere(username, password)){MagazziniereBusiness.getInstance().RecuperoInfo(username, password);}
			else {CapoProgettoBusiness.getInstance().RecuperoInfo(username, password);}
		}
	}
}