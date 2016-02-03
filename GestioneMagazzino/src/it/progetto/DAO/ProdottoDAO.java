package it.progetto.DAO;

import it.progetto.DbConnection.DbConnection;
import java.util.Vector;

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
	
	public boolean Rifornisci(int idprodotto, int quantit‡darifornire){
		boolean result= DbConnection.getInstance().eseguiAggiornamento("UPDATE Prodotto SET Prodotto.Disponibilit‡=\""+quantit‡darifornire+"\" WHERE Prodotto.idProdotto=\""+idprodotto+"\"");
		return result;
	}

	public int verificaMag(int idProdotto) {
		// TODO Auto-generated method stub
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("SELECT * FROM Appartiene WHERE CodProdotto=\""+idProdotto+"\"");
		int mag_appartenenza= Integer.parseInt(result.get(0)[1]);
		return mag_appartenenza;
	}
	
	public void SalvaProdottoOrdinato(int codprodotto,int codordine, int quantit‡ordinata){
		boolean inserisciprodotti= DbConnection.getInstance().eseguiAggiornamento("INSERT INTO CompostoDa(CodProdotto,CodOrdine,Quantit‡Ordinata) VALUES("+codprodotto+","+codordine+","+quantit‡ordinata+"\"");
		boolean riduciqnt=DbConnection.getInstance().eseguiAggiornamento("UPDATE Prodotto SET Prodotto.Disponibilit‡=Prodotto.Disponibilit‡-1 where Prodotto.IdProdotto=\""+codprodotto+"\"");
	}
}
