package it.progetto.DAO;

import java.util.Vector;

import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.UtenteRegistrato;

public class MagazziniereDAO {

private static MagazziniereDAO instance;
	
	public static MagazziniereDAO getInstance()
	{
		if(instance==null)
		{	
			instance = new MagazziniereDAO();
		}
		return instance;
	}
	
	public boolean isMagazziniere(UtenteRegistrato u){
		String username = u.getUsername();
		String password = u.getPassword();
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from UtenteRegistrato INNER JOIN Magazziniere ON Magazziniere.idMagazziniere=UtenteRegistrato.idUtenteRegistrato where UtenteRegistrato.username=\""+ username +"\"UtenteRegistrato.password=\""+password+"\"");
		if(result.size()!=0){
			return true;}
		else{
		return false;
			}
	}
}
