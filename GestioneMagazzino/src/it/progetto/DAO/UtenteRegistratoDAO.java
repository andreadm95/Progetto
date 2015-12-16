package it.progetto.DAO;

import java.util.Vector;

import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.UtenteRegistrato;

public class UtenteRegistratoDAO {

private static UtenteRegistratoDAO instance;
	
	public static UtenteRegistratoDAO getInstance()
	{
		if(instance==null)
		{	
			instance = new UtenteRegistratoDAO();
		}
		return instance;
	}

	public boolean userExists(UtenteRegistrato u) {
		String username = u.getUsername();
		String password = u.getPassword();
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from UtenteRegistrato where username=\""+ username +"\" and password=\""+password+"\"");
		if(result.size()!=0){
			return true;
							}
		else{
		return false;
			}
}

}
