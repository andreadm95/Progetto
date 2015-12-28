package it.progetto.Model;

public class Carrello {

private static Carrello instance;
	
	public static Carrello getInstance()
	{
		if(instance==null)
		{
			instance = new Carrello();
		}
		return instance;		
	}
}
