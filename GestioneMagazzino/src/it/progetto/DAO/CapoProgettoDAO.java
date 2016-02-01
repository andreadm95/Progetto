package it.progetto.DAO;

import java.util.ArrayList;
import java.util.Vector;

import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.CapoProgetto;
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
	
	public boolean CapoProgettoExists(CapoProgetto u){
		String username = u.getUsername();
		String password = u.getPassword();
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from UtenteRegistrato INNER JOIN CapoProgetto ON CapoProgetto.idCapoProgetto=UtenteRegistrato.idUtenteRegistrato where username=\""+ username +"\"and password=\""+password+"\"");
		if(result.size()!=0){
			return true;}
		else{
		return false;
			}
	}
	
	public Object PrelevaInfo(CapoProgetto u) {
		String username = u.getUsername();
		String password = u.getPassword();
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from UtenteRegistrato INNER JOIN CapoProgetto ON CapoProgetto.idCapoProgetto=UtenteRegistrato.idUtenteRegistrato where username=\""+ username +"\"and password=\""+password+"\"");
		if(result.size()!=0){
			String[] info= result.get(0);
			u.setId(Integer.parseInt(info[0]));
			u.setNome(info[1]);
			u.setCognome(info[2]);
			return u;}
		else{
		return null;
			}
	}
	
//	public boolean PiùDiDueProgetti(int idCapo){
//		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("SELECT * FROM progetto WHERE CodCapoProgetto=\""+idCapo+"\"");
//		if(result.size()<2){
//			return false;
//		}
//		else{return true;}
//	}
	
	public Vector<String[]> OrdinaSpeseProgetto(int idCapo){
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("SELECT * FROM progetto WHERE CodCapoProgetto=\""+idCapo+"\" ORDER BY idProgetto");
		if(result.size()!=0){
			return result;}
		else{
		return null;
			}
		
	}
	
	public Vector<String[]> OrdinaSpeseDipendente(int idCapo){
		Vector<String[]> ricercaperdip=DbConnection.getInstance().eseguiQuery("SELECT distinct Dipendente.* FROM dipendente,lavorasu,progetto WHERE CodCapoProgetto=\""+idCapo+"\" and CodProgetto=IdProgetto and idDipendente=codDipendente");
			return ricercaperdip;
			}
}
