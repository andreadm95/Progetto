package it.progetto.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;



public class Carrello {

private static Carrello instance;
private static HashMap<Prodotto,Integer> ListaProdottiAcquisto;
	
	public static Carrello getInstance()
	{
		if(instance==null)
		{
			instance = new Carrello();
			ListaProdottiAcquisto= new HashMap<Prodotto,Integer>();
		}
		return instance;		
	}
	//da testare
	public void aggiungiProdottoACarrello(ArrayList<String> a,int quantità)
    {
		Prodotto ordinato=new Prodotto(Integer.parseInt(a.get(0)), a.get(1), a.get(2),a.get(3),Float.parseFloat(a.get(8)),Integer.parseInt(a.get(4)),Integer.parseInt(a.get(5)),a.get(6),a.get(7));
		Set<Prodotto> keySet=ListaProdottiAcquisto.keySet();
		Iterator<Prodotto> it= keySet.iterator();
		if(ListaProdottiAcquisto.isEmpty()){ListaProdottiAcquisto.put(ordinato, quantità);}
		else{
			while(it.hasNext()){
				Prodotto key= it.next();
				if(ordinato.hashCode()==key.hashCode()){
					ListaProdottiAcquisto.remove(key);
					ListaProdottiAcquisto.put(ordinato, quantità);
					break;
				}
			}
		ListaProdottiAcquisto.put(ordinato, quantità);
		}
    }
	
	public Vector<String[]> getListaProdottiAcquisto() {
		Vector<String[]> lista= new Vector<String[]>();
		Set<Prodotto> keySet=ListaProdottiAcquisto.keySet();
		Iterator<Prodotto> it= keySet.iterator();
		while(it.hasNext()){
			Prodotto key= it.next();
			String[] elem= new String[6];
			elem[0]=key.getNome();
			elem[1]=key.getDescrizione();
			elem[2]=Integer.toString(key.getDisponibilità());
			elem[3]=Integer.toString(key.getNumeroMaxOrdinabile());
			elem[4]=Float.toString(key.getPrezzo());
			elem[5]=Integer.toString(ListaProdottiAcquisto.get(key));
			lista.addElement(elem);
		}
		return lista;
		}
	
	
}
