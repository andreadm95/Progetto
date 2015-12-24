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
	
	public  ArrayList<Prodotto> fornisciCatalogoVicino(int sede)
	{
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Prodotto, Appartiene where Appartiene.CodMagazzino="+sede+" and Prodotto.idprodotto=Appartiene.codprodotto");
		ArrayList<Prodotto> Catalogo= new ArrayList<Prodotto>();
		for (int i = 0; i< result.size(); i++ ){
	         String[] prodotto = result.get(i); //inserisce in array di stringhe il risultato della query
		Catalogo.add(new Prodotto(prodotto[1], prodotto[2], prodotto[3], Float.parseFloat(prodotto[8]), Integer.parseInt(prodotto[4]),
 				Integer.parseInt(prodotto[5]), prodotto[6], prodotto[7])); //aggiunge al catalogo i prodotti uno ad uno
		}
		return Catalogo;
	}

}
