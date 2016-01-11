package it.progetto.Model;

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
		UtenteRegistrato p=new UtenteRegistrato(username, password);
		boolean UtenteEsiste= UtenteRegistratoBusiness.getInstance().verificaLogin(p);
		if (UtenteEsiste){
			if(DipendenteDAO.getInstance().isDipendente(p)){return DipendenteDAO.getInstance().RecuperaInfo(p);}
			else if(MagazziniereDAO.getInstance().isMagazziniere(p)){return MagazziniereDAO.getInstance().RecuperaInfo(p);}
			else {return CapoProgettoDAO.getInstance().RecuperaInfo(p);}
		}
		else {return -1;}
	}
}
