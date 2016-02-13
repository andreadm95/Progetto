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
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select distinct Ordine.idOrdine,Progetto.Nome,Ordine.Evaso,UtenteRegistrato.Nome,UtenteRegistrato.Cognome from utenteregistrato,Ordine,progetto where Evaso=false and codDipendente=idutenteregistrato and codProgetto=idProgetto and CodMagazzino=\""+idmag+"\"");
		if(result.size()!=0){
			for(int i=0;i<result.size();i++){
				result.get(i)[2]="Non Evaso";
			}
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
		Vector<String[]> result=DbConnection.getInstance().eseguiQuery("select Prodotto.idProdotto,Prodotto.Nome,Prodotto.Categoria,Prodotto.Descrizione,Prodotto.Fornitore,Prodotto.Produttore,Prodotto.Prezzo,CompostoDa.Quantit‡Ordinata from prodotto INNER JOIN compostoda ON CodProdotto=idprodotto where CodOrdine=\""+id_ordine+"\"");
		return result;	
	}
	
	public int recuperoidOrdineDaSalvare(){
		Vector<String[]> recuperocodordine= DbConnection.getInstance().eseguiQuery("SELECT Max(idOrdine) FROM Ordine");
		int codordine= Integer.parseInt(recuperocodordine.get(0)[0]);
		return codordine;
	}
	
}
