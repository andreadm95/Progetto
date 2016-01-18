package it.progetto.Model;

import java.util.HashMap;

public class Sessione {

	private static Sessione instance;
	public HashMap<String, Object> session = new HashMap<String, Object>();
	
	public static synchronized Sessione getInstance() {
		if(instance == null)
			instance = new Sessione();
		return instance;
	}
}