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
			u.setId(Integer.parseInt(info[0]));
			u.setNome(info[1]);
			u.setCognome(info[2]);
			u.setSpesa(Float.parseFloat(info[7]));
			return u;}
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
	
	public Vector<String> fornisciProgettiDelDipendente(int id_dip) {
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("SELECT * FROM progetto INNER JOIN lavorasu ON CodDipendente=\""+ id_dip +"\" WHERE CodProgetto=idprogetto;");
		if(result.size()!=0){
			Vector<String> ListaProgettiDelDipendente= new Vector<String>();
			for (int i=0; i< result.size(); i++) {
				String[] progetto = result.get(i);
				ListaProgettiDelDipendente.add(progetto[1]);
			}
			return ListaProgettiDelDipendente;}
		else{
		return null;}
	} 

}
