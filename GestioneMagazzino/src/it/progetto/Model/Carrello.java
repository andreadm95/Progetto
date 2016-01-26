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
	public void aggiungiProdottoACarrello(ArrayList<String> a,int quantit�)
    {
		Prodotto ordinato=new Prodotto(Integer.parseInt(a.get(0)), a.get(1), a.get(2),a.get(3),Float.parseFloat(a.get(8)),Integer.parseInt(a.get(4)),Integer.parseInt(a.get(5)),a.get(6),a.get(7));
		Set<Prodotto> keySet=ListaProdottiAcquisto.keySet();
		Iterator<Prodotto> it= keySet.iterator();
			while(it.hasNext()){
				Prodotto key= it.next();
				if(ordinato.hashCode()==key.hashCode()){
					ListaProdottiAcquisto.remove(key);
					ListaProdottiAcquisto.put(ordinato, quantit�);
					break;
				}
			}
		ListaProdottiAcquisto.put(ordinato, quantit�);
    }
	
	public Vector<String[]> getListaProdottiAcquisto() {
		Vector<String[]> lista= new Vector<String[]>();
		Set<Prodotto> keySet=ListaProdottiAcquisto.keySet();
		Iterator<Prodotto> it= keySet.iterator();
		while(it.hasNext()){
			Prodotto key= it.next();
			String[] elem= new String[10];
			elem[0]=Integer.toString(key.getIdProdotto());
			elem[1]=key.getNome();
			elem[2]=key.getCategoria();
			elem[3]=key.getDescrizione();
			elem[4]=Integer.toString(key.getDisponibilit�());
			elem[5]=Integer.toString(key.getNumeroMaxOrdinabile());
			elem[6]=key.getFornitore();
			elem[7]=key.getProduttore();
			elem[8]=Float.toString(key.getPrezzo());
			elem[9]=Integer.toString(ListaProdottiAcquisto.get(key));
			lista.addElement(elem);}
		return lista;
		}
	
	public void rimuoviProdotto(ArrayList<String> a)
    {
		Prodotto ordinato=new Prodotto(Integer.parseInt(a.get(0)), a.get(1), a.get(2),a.get(3),Float.parseFloat(a.get(8)),Integer.parseInt(a.get(4)),Integer.parseInt(a.get(5)),a.get(6),a.get(7));
		Set<Prodotto> keySet=ListaProdottiAcquisto.keySet();
		Iterator<Prodotto> it= keySet.iterator();
			while(it.hasNext()){
				Prodotto key= it.next();
				if(ordinato.hashCode()==key.hashCode()){
					ListaProdottiAcquisto.remove(key);
					break;}
				}
	}
	
	public String calcoloSpesaTotale() {
		float SpesaTotale= (float) 0.0;
		Set<Prodotto> keySet=ListaProdottiAcquisto.keySet();
		Iterator<Prodotto> it= keySet.iterator();
		while(it.hasNext()){
			Prodotto key= it.next();
			for(int i=0;i<ListaProdottiAcquisto.get(key);i++){
			SpesaTotale=SpesaTotale+key.getPrezzo();}
		}
		String troncamento= String.format("%.2f", SpesaTotale);
		return troncamento;
	}
}
