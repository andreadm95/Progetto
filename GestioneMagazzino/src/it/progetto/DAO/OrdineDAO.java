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

	public Vector<String[]> fornisciOrdiniPendenti(int idmag) {
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select * from Ordine where Evaso=false and CodMagazzino=\""+idmag+"\"");
		if(result.size()!=0){
			return result;}
		else{
		return null;}
	}

	public boolean ModificaEvadi(int id) {
		boolean result= DbConnection.getInstance().eseguiAggiornamento("UPDATE Ordine SET Ordine.Evaso=true WHERE Ordine.idOrdine="+id);
		return result;
	}
	public boolean SalvaProdottoOrdinato(int codprodotto,int codordine, int quantit‡ordinata){
		boolean result= DbConnection.getInstance().eseguiAggiornamento("INSERT INTO CompostoDa(CodProdotto,CodOrdine,Quantit‡Ordinata) VALUES("+codprodotto+codordine+quantit‡ordinata);
		return result;
	}
	public boolean SalvaOrdine(ArrayList<Prodotto> prodottiordinati, int codmagazzino, int coddipendente, int codprogetto){
		boolean result= DbConnection.getInstance().eseguiAggiornamento("INSERT INTO Ordine(idOrdine,CodMagazzino,CodDipendente,CodProgetto,Evaso) VALUES(null,"+codmagazzino+coddipendente+codprogetto+"false)");
		Vector<String[]> recuperocodordine= DbConnection.getInstance().eseguiQuery("SELECT idOrdine FROM Ordine WHERE Max(idOrdine)");
		int codordine= Integer.parseInt(recuperocodordine.get(0).toString());
		for(int i=0;i<prodottiordinati.size();i++){
			int codprodotto=prodottiordinati.get(i).getIdProdotto();
			boolean risultato= SalvaProdottoOrdinato(codprodotto,codordine,5);
		}
		return result;
	}
	
}
