package it.progetto.Model;

import java.util.Vector;

import javax.swing.JTable;

import it.progetto.Business.DipendenteBusiness;
import it.progetto.Business.OrdineBusiness;
import it.progetto.Business.ProdottoBusiness;
import it.progetto.Business.ProgettoBusiness;

public class Sistema {
	
	private static Sistema instance;
	
	public static Sistema getInstance() {
		   if(instance == null){
			   instance = new Sistema();
			   }
		   return instance;
	}
	
	public void GeneraPdf(JTable dati){
		try{
			dati.print(JTable.PrintMode.FIT_WIDTH);
		}
		catch(java.awt.print.PrinterException e){
			System.err.format("Impossibile stampare %s%n", e.getMessage());
		}
	}
	
	public boolean SalvaOrdine(String progetto,String costo,int codmagazzino,int cod_dip,Vector<String[]> listaprodotti){
		int idprogetto=ProgettoBusiness.getInstance().Recuperoid(progetto);
		float spesa=Float.parseFloat(costo);
		//Se ordina da magazzino lontano ci aggiunge il costo di spedizione
		if(Integer.parseInt(listaprodotti.get(0)[0])!=cod_dip){spesa+=3.99;}
		if(OrdineBusiness.getInstance().salvaOrdine(idprogetto,spesa, codmagazzino, cod_dip)){
			int codordine=OrdineBusiness.getInstance().recuperaidOrdinedaSalvare();
			for(int i=0;i<listaprodotti.size();i++){
				String[] prodotto=listaprodotti.get(i);
				ProdottoBusiness.getInstance().salvaProdotto(prodotto, codordine);
			}
			if(ProgettoBusiness.getInstance().aggiornaSpesa(idprogetto, spesa)){
				if(DipendenteBusiness.getInstance().aggiornaSpesa(cod_dip,spesa)){
					return true;
				}
				else return false;
			}
			else{return false;}
		}
		else{return false;}
	}
}
