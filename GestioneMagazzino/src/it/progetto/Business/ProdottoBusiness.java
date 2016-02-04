package it.progetto.Business;

import java.util.ArrayList;

import it.progetto.Model.Prodotto;

public class ProdottoBusiness {
	
private static ProdottoBusiness instance;
	
	public static ProdottoBusiness getInstance() {
		   if(instance == null){
			   instance = new ProdottoBusiness();
			   }
		   return instance;
	}

	public void Rifornimento(ArrayList<String> a, int qnt){
		Prodotto DaRifornire=new Prodotto(Integer.parseInt(a.get(0)),a.get(1),a.get(2),a.get(3),Float.parseFloat(a.get(8)),Integer.parseInt(a.get(4)),Integer.parseInt(a.get(5)),a.get(6),a.get(7));
		DaRifornire.Rifornisci(qnt);
	}
	
	public int verificaMagazzino(Prodotto a){
		return a.verificaAppartenenza();
	}
	
	public void salvaProdotto(String[] prod_ordinato, int codordine){
		Prodotto a=new Prodotto(Integer.parseInt(prod_ordinato[0]),prod_ordinato[1],prod_ordinato[2],prod_ordinato[3],Float.parseFloat(prod_ordinato[8]),Integer.parseInt(prod_ordinato[4]),Integer.parseInt(prod_ordinato[5]),prod_ordinato[6],prod_ordinato[7]);
		int qnt=Integer.parseInt(prod_ordinato[9]);
		a.salvaProdOrdinato(codordine, qnt);	
	}
}
