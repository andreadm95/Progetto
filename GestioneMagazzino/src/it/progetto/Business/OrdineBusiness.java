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
	
	public boolean salvaOrdine(int codprogetto,float spesa,int codmagazzino,int cod_dip){
		Ordine q= new Ordine(codprogetto,spesa,codmagazzino,cod_dip);
		return q.SalvaOrdine();
	}
	
	public Vector<String[]> recuperoListaProdotti(int id_ordine){
		Ordine q= new Ordine(id_ordine);
		return q.fornisciListaprod();
	}
	
	public boolean evadiOrdine(int id_ordine){
		Ordine q= new Ordine(id_ordine);
		return q.EvadiOrdine();
		}
	
	public int recuperaidOrdinedaSalvare(){
		Ordine q=new Ordine();
		return q.recuperoOrdineDaSalvare();
	}
}
