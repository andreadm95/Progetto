package it.progetto.DAO;

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
		boolean result=DbConnection.getInstance().eseguiAggiornamento("UPDATE Progetto SET Progetto.SpesaTotate=Progetto.SpesaTotale+"+spesa+"WHERE Progetto.idProgetto="+idprogetto);
		return result;
	}
	
	
	
	
	
	
}
