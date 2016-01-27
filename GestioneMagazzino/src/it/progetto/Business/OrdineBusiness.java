package it.progetto.Business;

import java.util.Vector;

import it.progetto.Model.Ordine;

public class OrdineBusiness {
	
	private static OrdineBusiness instance;
	
	public static OrdineBusiness getInstance()
	{
		if(instance == null)
			instance = new OrdineBusiness();
		return instance;
	}
	
	public boolean salvaOrdine(String progetto,float spesa,int codmagazzino,int cod_dip,Vector<String[]> lista_prodotti){
		Ordine q= new Ordine(progetto,spesa,codmagazzino,cod_dip,lista_prodotti);
		return q.SalvaOrdine(lista_prodotti, codmagazzino, cod_dip, progetto,spesa);
	}
}
