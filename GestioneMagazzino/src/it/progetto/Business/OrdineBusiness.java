package it.progetto.Business;

public class OrdineBusiness {
	
	private static OrdineBusiness instance;
	
	public static OrdineBusiness getInstance()
	{
		if(instance == null)
			instance = new OrdineBusiness();
		return instance;
	}
}
