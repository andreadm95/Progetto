package it.progetto.Model;

import java.util.ArrayList;
import java.util.Map;

import it.progetto.DAO.OrdineDAO;

public class Ordine {

	  private int idOrdine;
	  private ArrayList<Map<Prodotto,Integer>> ListaProdottiAcquisto;
      private int ProgettoDiRiferimento;
	  private float SpesaOrdine;
	  private int CodiceMagazzino;
	  private int DipendenteDiRiferimento;

	public void aggiungiProdottoACarrello(ArrayList<String> a,int quantità)
	    {
			Prodotto ordinato=new Prodotto(Integer.parseInt(a.get(0)), a.get(1), a.get(2),a.get(3),Float.parseFloat(a.get(8)),Integer.parseInt(a.get(4)),Integer.parseInt(a.get(5)),a.get(6),a.get(7));
			Map<Prodotto,Integer> prodotto_ord = null;
			prodotto_ord.put(ordinato, quantità);
	    	ListaProdottiAcquisto.add(prodotto_ord);
	    }
	
	public Ordine(int id, int codmagazzino, int cod_dipendente, int codprogetto){
		idOrdine=id;
		CodiceMagazzino=codmagazzino;
		DipendenteDiRiferimento=cod_dipendente;
		ProgettoDiRiferimento=codprogetto;
	}
	  
	 public int getIdOrdine() {
			return idOrdine;
		}

		public void setIdOrdine(int idOrdine) {
			this.idOrdine = idOrdine;
		}

		public int getDipendenteDiRiferimento() {
			return DipendenteDiRiferimento;
		}

		public void setDipendenteDiRiferimento(int dipendenteDiRiferimento) {
			DipendenteDiRiferimento = dipendenteDiRiferimento;
		}
			
		public int getProgettoDiRiferimento() {
			return ProgettoDiRiferimento;
		}
		public void setProgettoDiRiferimento(int progettoDiRiferimento) {
			ProgettoDiRiferimento = progettoDiRiferimento;
		}
		public float getSpesaOrdine() {
			return SpesaOrdine;
		}
		public void setSpesaOrdine(float spesaOrdine) {
			SpesaOrdine = spesaOrdine;
		}
		public int getCodiceMagazzino() {
			return CodiceMagazzino;
		}
		public void setCodiceMagazzino(int CodMagazzino) {
			CodiceMagazzino = CodMagazzino;
		}
		
		public boolean EvadiOrdine(int id){
			return OrdineDAO.getInstance().ModificaEvadi(id);
		}

	
}
