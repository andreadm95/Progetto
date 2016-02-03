package it.progetto.DAO;

import java.util.Vector;

import it.progetto.DbConnection.DbConnection;

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
	
	public boolean aggiornaSpesaProgetto(int idprogetto, float spesa){
		boolean result=DbConnection.getInstance().eseguiAggiornamento("UPDATE Progetto SET Progetto.SpesaTotate=Progetto.SpesaTotale"+spesa+"WHERE Progetto.idProgetto="+idprogetto);
		return result;
	}

	public int recuperaid(String nomeprogetto) {
		// TODO Auto-generated method stub
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("SELECT idProgetto FROM Progetto WHERE Nome=\""+nomeprogetto+"\"");
		int id=Integer.parseInt(result.get(0)[0]);
		return id;
	}
	
	
	
	
	
	
}
