package it.progetto.DAO;

import java.util.ArrayList;
import java.util.Vector;

import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.Ordine;
import it.progetto.Model.Prodotto;

public class OrdineDAO {

private static OrdineDAO instance;
	
	public static OrdineDAO getInstance()
	{
		if(instance==null)
		{	
			instance = new OrdineDAO();
		}
		return instance;
	}

	public ArrayList<Ordine> fornisciOrdiniPendenti() {
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Ordine where Ordine.Evaso=false");
		if(result.size()!=0){
			ArrayList<Ordine> ListaOrdiniPendenti= new ArrayList<Ordine>();
			for (int i = 0; i< result.size(); i++ ){
		         String[] ordine = result.get(i);
			ListaOrdiniPendenti.add(new Ordine(Integer.parseInt(ordine[1]),Integer.parseInt(ordine[2]),Integer.parseInt(ordine[3]),Integer.parseInt(ordine[4]))); 
			}
			return ListaOrdiniPendenti;}
		else{
		return null;}
	}

	public boolean ModificaEvadi(int id) {
		boolean result= DbConnection.getInstance().eseguiAggiornamento("UPDATE Ordine SET Ordine.Evaso=true WHERE Ordine.idOrdine="+id);
		return result;
	}

}
