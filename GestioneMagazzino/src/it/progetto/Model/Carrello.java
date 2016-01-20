package it.progetto.Model;

import java.util.ArrayList;
import java.util.Map;

public class Carrello {

private static Carrello instance;
private ArrayList<Map<Prodotto,Integer>> ListaProdottiAcquisto;
	
	public static Carrello getInstance()
	{
		if(instance==null)
		{
			instance = new Carrello();
		}
		return instance;		
	}
	
	public void aggiungiProdottoACarrello(ArrayList<String> a,int quantità)
    {
		Prodotto ordinato=new Prodotto(Integer.parseInt(a.get(0)), a.get(1), a.get(2),a.get(3),Float.parseFloat(a.get(8)),Integer.parseInt(a.get(4)),Integer.parseInt(a.get(5)),a.get(6),a.get(7));
		Map<Prodotto,Integer> prodotto_ord = null;
		prodotto_ord.put(ordinato, quantità);
    	ListaProdottiAcquisto.add(prodotto_ord);
    }
}
