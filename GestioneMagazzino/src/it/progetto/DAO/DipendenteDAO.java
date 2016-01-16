package it.progetto.DAO;

import java.util.Vector;

import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.Dipendente;
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
	
	public boolean DipendenteExists(Dipendente u){
		String username = u.getUsername();
		String password = u.getPassword();
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from UtenteRegistrato INNER JOIN Dipendente ON Dipendente.idDipendente=UtenteRegistrato.idUtenteRegistrato where username=\""+ username +"\"and password=\""+password+"\"");
		if(result.size()!=0){
			return true;}
		else{
		return false;
			}
	}
	
	public Object PrelevaInfo(Dipendente u){
		String username = u.getUsername();
		String password = u.getPassword();
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from UtenteRegistrato INNER JOIN Dipendente ON Dipendente.idDipendente=UtenteRegistrato.idUtenteRegistrato where username=\""+ username +"\"and password=\""+password+"\"");
		if(result.size()!=0){
			String[] info= result.get(0);
			Dipendente dip= new Dipendente(info[1],info[2],info[3],info[4],Float.parseFloat(info[7]));
			return dip;}
		else{
		return null;
			}
	}
	
	public int SedeDipendente(Dipendente u){
		String username = u.getUsername();
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select CodMagazzino from UtenteRegistrato INNER JOIN Dipendente ON Dipendente.idDipendente=UtenteRegistrato.idUtenteRegistrato where UtenteRegistrato.username=\""+ username +"\"");
		String[] riga=result.get(0);
		int sede=Integer.parseInt(riga[0]);
		return sede;
	}

}
