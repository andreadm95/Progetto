package it.progetto.Business;

import it.progetto.Model.Magazziniere;
import it.progetto.Model.Sessione;

public class MagazziniereBusiness {

private static MagazziniereBusiness instance;
	
	//SINGLETON
	public static MagazziniereBusiness getInstance()
	{
		if(instance == null)
			instance = new MagazziniereBusiness();
		return instance;
	}
	
	public boolean isMagazziniere(String username,String password){
		Magazziniere u= new Magazziniere(username,password);
		return u.isMagazziniere();
	}
	
	public void RecuperoInfo(String username,String password){
		Magazziniere m= new Magazziniere(username,password);
		Sessione.getInstance().session.put("utente_corrente", m.RecuperaInfo());
	}
}
