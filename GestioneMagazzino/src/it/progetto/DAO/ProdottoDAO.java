package it.progetto.DAO;

import it.progetto.DbConnection.DbConnection;
import java.util.ArrayList;
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
	
	public void RiduciQuantit‡Prodotto(ArrayList<Prodotto> lista, String nome, int sede)
		{
			for(int i=0; i< lista.size();i++)
			{
				boolean result=DbConnection.getInstance().eseguiAggiornamento("update Prodotto,Appartiene set Prodotto.Disponibilit‡=Prodotto.Disponibilit‡-1 where Prodotto.Nome="+lista.get(i).getNome()+"and Appartiene.CodMagazzino="+sede+"and Prodotto.IdProdotto=Appartiene.CodProdotto");
			}
		}
	
	public boolean Rifornisci(int idprodotto, int quantit‡darifornire){
		boolean result= DbConnection.getInstance().eseguiAggiornamento("UPDATE Prodotto SET Prodotto.Disponibilit‡=\""+quantit‡darifornire+"\" WHERE Prodotto.idProdotto=\""+idprodotto+"\"");
		return result;
	}
}
