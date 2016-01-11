package it.progetto.DAO;

import java.util.Vector;
import java.util.ArrayList;
import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.Prodotto;

public class MagazzinoDAO {
	
private static MagazzinoDAO instance;

	public static MagazzinoDAO getInstance()
	{
		if(instance==null)
		{	
			instance = new MagazzinoDAO();
		}
		return instance;
	}
	
	public  Vector<String[]> fornisciCatalogoVicino(int sede)
	{
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Prodotto, Appartiene where Appartiene.CodMagazzino="+sede+" and Prodotto.idprodotto=Appartiene.codprodotto");
		return result;
	}
	
	public  Vector<String[]> fornisciCatalogo()
	{
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Prodotto");
		return result;
	}

}
