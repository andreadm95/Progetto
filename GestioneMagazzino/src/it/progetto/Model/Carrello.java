package it.progetto.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Carrello {

private static Carrello instance;
private static HashMap<Prodotto,Integer> ListaProdottiAcquisto;
	
	public static Carrello getInstance()
	{
		if(instance==null)
		{
			instance = new Carrello();
		}
		return instance;		
	}
	//da testare
	public void aggiungiProdottoACarrello(ArrayList<String> a,int quantità)
    {
		Prodotto ordinato=new Prodotto(Integer.parseInt(a.get(0)), a.get(1), a.get(2),a.get(3),Float.parseFloat(a.get(8)),Integer.parseInt(a.get(4)),Integer.parseInt(a.get(5)),a.get(6),a.get(7));
		ListaProdottiAcquisto.put(ordinato, quantità);
    }
	
	public HashMap<Prodotto,Integer> getListaProdottiAcquisto() {
		Vector<String[]> lista= new Vector<String[]>();
		return ListaProdottiAcquisto;
		}
	
	
}
