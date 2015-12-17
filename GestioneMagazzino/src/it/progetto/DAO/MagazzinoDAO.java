package it.progetto.DAO;

import java.util.Vector;
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
	
	public  fornisciCatalogo()
	{
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Prodotto, appartiene where appartiene.CodMagazzino=1");
		return ; 
	}

}
