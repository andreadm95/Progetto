package it.progetto.DAO;

import java.util.Vector;

import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.UtenteRegistrato;

public class CapoProgettoDAO {

private static CapoProgettoDAO instance;
	
	public static CapoProgettoDAO getInstance()
	{
		if(instance==null)
		{	
			instance = new CapoProgettoDAO();
		}
		return instance;
	}
	
	public boolean isCapoProgetto(UtenteRegistrato u){
		String username = u.getUsername();
		String password = u.getPassword();
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from UtenteRegistrato INNER JOIN CapoProgetto ON CapoProgetto.idCapoProgetto=UtenteRegistrato.idUtenteRegistrato where UtenteRegistrato.username=\""+ username +"\"UtenteRegistrato.password=\""+password+"\"");
		if(result.size()!=0){
			return true;}
		else{
		return false;
			}
	}
}
