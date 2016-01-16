package it.progetto.Model;

import it.progetto.Business.CapoProgettoBusiness;
import it.progetto.Business.DipendenteBusiness;
import it.progetto.Business.MagazziniereBusiness;
import it.progetto.Business.UtenteRegistratoBusiness;
import it.progetto.DAO.CapoProgettoDAO;
import it.progetto.DAO.DipendenteDAO;
import it.progetto.DAO.MagazziniereDAO;

public class Sistema {
	
	private static Sistema instance;
	
	public static Sistema getInstance() {
		   if(instance == null){
			   instance = new Sistema();
			   }
		   return instance;
	}
	
	public Object Autenticazione(String username, String password){
		boolean UtenteEsiste= UtenteRegistratoBusiness.getInstance().verificaLogin(username,password);
		if (UtenteEsiste){
			if(DipendenteBusiness.getInstance().isDipendente(username, password)){return DipendenteBusiness.getInstance().RecuperoInfo(username,password);}
			else if(MagazziniereBusiness.getInstance().isMagazziniere(username, password)){return MagazziniereBusiness.getInstance().RecuperoInfo(username, password);}
			else {return CapoProgettoBusiness.getInstance().RecuperoInfo(username, password);}
		}
		else {return null;}
	}
}
