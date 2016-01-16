package it.progetto.DAO;

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
			CapoProgetto mag= new CapoProgetto(info[1],info[2],info[3],info[4]);
			return mag;}
		else{
		return null;
			}
	}
	
	public boolean PiùDiDueProgetti(int idCapo){
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("SELECT * FROM progetto WHERE CodCapoProgetto=\""+idCapo+"\"");
		if(result.size()<2){
			return false;
		}
		else{return true;}
	}
	
	public Vector<String[]> OrdinaSpeseProgetto(int idCapo){
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("SELECT * FROM progetto WHERE CodCapoProgetto=\""+idCapo+"\" ORDER BY idProgetto");
		if(result.size()!=0){
			return result;}
		else{
		return null;
			}
		
	}
	
	public Vector<String[]> OrdinaSpeseDipendente(int idCapo){
		Vector<String[]> ricercaprogetti=DbConnection.getInstance().eseguiQuery("SELECT * FROM progetto WHERE CodCapoProgetto=\""+idCapo+"\"");
		if(ricercaprogetti.size()!=0){
			Vector<String[]> result= new Vector<String[]>();
			for(int i=0;i<ricercaprogetti.size();i++){
				Vector<String[]> ricercadip=DbConnection.getInstance().eseguiQuery("SELECT Dipendente.* FROM Dipendente,lavorasu WHERE CodProgetto=\""+ricercaprogetti.get(i)[0]+"\"");
				for(int j=0; j<ricercadip.size();j++){
				result.addElement(ricercadip.get(j));}
				}
			return result;
			}
		else{
		return null;
			}
	}
}
