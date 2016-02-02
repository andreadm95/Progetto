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
	
	public void SalvaProdottoOrdinato(int codprodotto,int codordine, int quantit‡ordinata){
		boolean inserisciprodotti= DbConnection.getInstance().eseguiAggiornamento("INSERT INTO CompostoDa(CodProdotto,CodOrdine,Quantit‡Ordinata) VALUES("+codprodotto+"\","+codordine+"\","+quantit‡ordinata+"\"");
		boolean riduciqnt=DbConnection.getInstance().eseguiAggiornamento("UPDATE Prodotto SET Prodotto.Disponibilit‡=Prodotto.Disponibilit‡-1 where Prodotto.IdProdotto=\""+codprodotto+"\"");
	}
	
	public boolean SalvaOrdine(Vector<String[]> prodottiordinati, int codmagazzino, int coddipendente, String progetto,float spesa){
		//recupero id progetto attraverso il nome
		Vector<String[]> recuperoprogetto= DbConnection.getInstance().eseguiQuery("SELECT idProgetto FROM Progetto WHERE nome=\""+progetto+"\"");
		int codprogetto= Integer.parseInt(recuperoprogetto.get(0)[0]);
		//creo lo spazio per salvare l'ordine nel db
		boolean result= DbConnection.getInstance().eseguiAggiornamento("INSERT INTO Ordine(idOrdine,CodMagazzino,CodDipendente,CodProgetto,Evaso) VALUES(null,"+codmagazzino+"\","+coddipendente+"\","+codprogetto+"\","+"false)");
		//recupero l'id generato da mysql
		Vector<String[]> recuperocodordine= DbConnection.getInstance().eseguiQuery("SELECT idOrdine FROM Ordine WHERE Max(idOrdine)");
		int codordine= Integer.parseInt(recuperocodordine.get(0).toString());
		for(int i=0;i<prodottiordinati.size();i++){
			String[] lista_prodotto=prodottiordinati.get(i);
			int codprodotto=Integer.parseInt(lista_prodotto[0]);
			int qnt=Integer.parseInt(lista_prodotto[9]);
			SalvaProdottoOrdinato(codprodotto,codordine,qnt);
		}
		boolean res=DbConnection.getInstance().eseguiAggiornamento("UPDATE Progetto SET Progetto.SpesaTotate=Progetto.SpesaTotale"+spesa+"WHERE Progetto.idProgetto=\""+codprogetto+"\"");
		return result;
	}

	public Vector<String[]> fornisciListaProdOrdinati(int id_ordine) {
		// TODO Auto-generated method stub
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select Prodotto.*,CompostoDa.Quantit‡Ordinata from prodotto INNER JOIN compostoda ON CodProdotto=idprodotto where CodOrdine=\""+id_ordine+"\"");
		return result;	
	}
	
}
