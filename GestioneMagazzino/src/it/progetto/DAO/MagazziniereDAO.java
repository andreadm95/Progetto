package it.progetto.DAO;

import java.util.Vector;

import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.Magazziniere;

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
	
	public boolean MagazziniereExists(Magazziniere u){
		String username = u.getUsername();
		String password = u.getPassword();
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from UtenteRegistrato INNER JOIN Magazziniere ON Magazziniere.idMagazziniere=UtenteRegistrato.idUtenteRegistrato where username=\""+ username +"\"and password=\""+password+"\"");
		if(result.size()!=0){
			return true;}
		else{
		return false;
			}
	}
	
	public Object PrelevaInfo(Magazziniere u){
		String username = u.getUsername();
		String password = u.getPassword();
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from UtenteRegistrato INNER JOIN Magazziniere ON Magazziniere.idMagazziniere=UtenteRegistrato.idUtenteRegistrato where username=\""+ username +"\"and password=\""+password+"\"");
		if(result.size()!=0){
			String[] info= result.get(0);
			u.setId(Integer.parseInt(info[0]));
			u.setNome(info[1]);
			u.setCognome(info[2]);
			u.setMagazzinoAppartenenza(Integer.parseInt(info[6]));
			return u;}
		else{
		return null;
			}
	}
}
