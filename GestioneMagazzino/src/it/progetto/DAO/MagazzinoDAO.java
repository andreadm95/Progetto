package it.progetto.DAO;

import java.util.Vector;
import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.Prodotto;
import it.progetto.Model.DipendenteDAO;

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
	
	public  ArrayList<Prodotto> fornisciCatalogoVicino(int sede)
	{
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Prodotto, appartiene where appartiene.CodMagazzino=\""+ sede +"and Prodotto.idprodotto=appartiene.codprodotto");
		return ArrayList<Prodotto>; 
	}

}
