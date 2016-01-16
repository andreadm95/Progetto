package it.progetto.Business;

import it.progetto.Model.Magazziniere;

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
	
	public Object RecuperoInfo(String username,String password){
		Magazziniere m= new Magazziniere(username,password);
		return m.RecuperaInfo();
	}
}
