package it.progetto.DAO;

import java.util.ArrayList;
import java.util.Vector;

import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.Progetto;

public class ProgettoDAO {

private static ProgettoDAO instance;

	public static ProgettoDAO getInstance()
	{
		if(instance==null)
		{
			instance = new ProgettoDAO();
		}
		return instance;
	}
	
	public ArrayList<Progetto> fornisciProgettiDelDipendente() {
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Dipendente, LavoraSu where Dipendente.idDipendente=LavoraSu.codDipendente");
		if(result.size()!=0){
			ArrayList<Progetto> ListaProgettiDelDipendente= new ArrayList<Progetto>();
			for (int i=0; i< result.size(); i++) {
				String[] progetto = result.get(i);
				ListaProgettiDelDipendente.add(new Progetto(progetto[1], Float.parseFloat(progetto[2])));
			}
			return ListaProgettiDelDipendente;}
		else{
		return null;}
	}
	
	
	
	
	
	
}
