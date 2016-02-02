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
}
