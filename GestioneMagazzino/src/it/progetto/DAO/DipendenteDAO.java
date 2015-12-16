package it.progetto.DAO;

import java.util.Vector;

import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.UtenteRegistrato;

public class DipendenteDAO {

private static DipendenteDAO instance;
	
	public static DipendenteDAO getInstance()
	{
		if(instance==null)
		{	
			instance = new DipendenteDAO();
		}
		return instance;
	}
	
	public boolean isDipendente(UtenteRegistrato u){
		String username = u.getUsername();
		String password = u.getPassword();
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from UtenteRegistrato INNER JOIN Dipendente ON Dipendente.idDipendente=UtenteRegistrato.idUtenteRegistrato where UtenteRegistrato.username=\""+ username +"\"UtenteRegistrato.password=\""+password+"\"");
		if(result.size()!=0){
			return true;}
		else{
		return false;
			}
	}

}
