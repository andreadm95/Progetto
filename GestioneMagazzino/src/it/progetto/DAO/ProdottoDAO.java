package it.progetto.DAO;

import it.progetto.DbConnection.DbConnection;
import java.util.ArrayList;
import java.util.Vector;

import it.progetto.Model.Prodotto;

public class ProdottoDAO {
	
	private static ProdottoDAO instance;
	
	public static ProdottoDAO getInstance()
	{
		if(instance==null)
		{
			instance = new ProdottoDAO();
		}
		return instance;		
	}
	
	public boolean Rifornisci(int idprodotto, int quantitàdarifornire){
		boolean result= DbConnection.getInstance().eseguiAggiornamento("UPDATE Prodotto SET Prodotto.Disponibilità=\""+quantitàdarifornire+"\" WHERE Prodotto.idProdotto=\""+idprodotto+"\"");
		return result;
	}

	public int verificaMag(int idProdotto) {
		// TODO Auto-generated method stub
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("SELECT * FROM Appartiene WHERE CodProdotto=\""+idProdotto+"\"");
		int mag_appartenenza= Integer.parseInt(result.get(0)[1]);
		return mag_appartenenza;
	}
}
