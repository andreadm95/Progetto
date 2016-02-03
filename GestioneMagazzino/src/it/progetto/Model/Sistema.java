package it.progetto.Model;

import javax.swing.JTable;

import it.progetto.Business.CapoProgettoBusiness;
import it.progetto.Business.DipendenteBusiness;
import it.progetto.Business.MagazziniereBusiness;
import it.progetto.Business.UtenteRegistratoBusiness;

public class Sistema {
	
	private static Sistema instance;
	
	public static Sistema getInstance() {
		   if(instance == null){
			   instance = new Sistema();
			   }
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
	
	public void GeneraPdf(JTable dati){
		try{
			dati.print(JTable.PrintMode.FIT_WIDTH);
		}
		catch(java.awt.print.PrinterException e){
			System.err.format("Impossibile stampare %s%n", e.getMessage());
		}
	}
}
