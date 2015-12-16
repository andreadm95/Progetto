package it.progetto.Model;

public class Sistema {
	
	private static Sistema instance;
	
	public static Sistema getInstance() {
		   if(instance == null){
			   instance = new Sistema();
			   }
		   return instance;
	}
}
