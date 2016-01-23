package it.progetto.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Carrello {

private static Carrello instance;
private static ArrayList<HashMap<Prodotto,Integer>> ListaProdottiAcquisto;
	
	public static Carrello getInstance()
	{
		if(instance==null)
		{
			instance = new Carrello();
			ListaProdottiAcquisto= new ArrayList<HashMap<Prodotto,Integer>>();
		}
		return instance;		
	}
	
	public void aggiungiProdottoACarrello(ArrayList<String> a,int quantità)
    {
		Prodotto ordinato=new Prodotto(Integer.parseInt(a.get(0)), a.get(1), a.get(2),a.get(3),Float.parseFloat(a.get(8)),Integer.parseInt(a.get(4)),Integer.parseInt(a.get(5)),a.get(6),a.get(7));
		HashMap<Prodotto, Integer> prodotto_ord= new HashMap<Prodotto,Integer>();
		prodotto_ord.put(ordinato, quantità);
		for(int i=0;i<ListaProdottiAcquisto.size();i++){
			if(prodotto_ord.keySet().equals(ListaProdottiAcquisto.get(i).keySet())){
				ListaProdottiAcquisto.remove(i);
				ListaProdottiAcquisto.add(prodotto_ord);
				break;}}
		ListaProdottiAcquisto.add(prodotto_ord);
    }
}
