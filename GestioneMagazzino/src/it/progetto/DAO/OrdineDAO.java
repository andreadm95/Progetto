package it.progetto.DAO;

import java.util.Vector;

import it.progetto.DbConnection.DbConnection;

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
		boolean result= DbConnection.getInstance().eseguiAggiornamento("UPDATE Ordine SET Ordine.Evaso=true WHERE Ordine.idOrdine=\""+id+"\"");
		return result;
	}
	
	public boolean SalvaOrdine(int codmagazzino, int coddipendente, int codprogetto,float spesa){
		//creo lo spazio per salvare l'ordine nel db
		boolean result= DbConnection.getInstance().eseguiAggiornamento("INSERT INTO Ordine(idOrdine,CodMagazzino,CodDipendente,CodProgetto,Evaso) VALUES(null,"+codmagazzino+","+coddipendente+","+codprogetto+","+"false)");
		return result;
	}

	public Vector<String[]> fornisciListaProdOrdinati(int id_ordine) {
		// TODO Auto-generated method stub
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select Prodotto.*,CompostoDa.Quantit‡Ordinata from prodotto INNER JOIN compostoda ON CodProdotto=idprodotto where CodOrdine=\""+id_ordine+"\"");
		return result;	
	}
	
	public int recuperoidOrdineDaSalvare(){
		Vector<String[]> recuperocodordine= DbConnection.getInstance().eseguiQuery("SELECT Max(idOrdine) FROM Ordine");
		int codordine= Integer.parseInt(recuperocodordine.get(0)[0]);
		return codordine;
	}
	
}
