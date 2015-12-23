package it.progetto.Model;

import java.util.ArrayList;

public class Ordine {

	  private ArrayList<Prodotto> ListaProdottiAcquisto;
      public Progetto ProgettoDiRiferimento;
	  public float SpesaOrdine;
	  public boolean MagazzinoVicino;
	  
    public ArrayList<Prodotto> aggiungiProdottoACarrello(Prodotto a)
    {
    	ListaProdottiAcquisto.add(a);
    	return ListaProdottiAcquisto;
    }
	  
	public ArrayList<Prodotto> getListaProdottiAcquisto() {
		return ListaProdottiAcquisto;
	}
	public void setListaProdottiAcquisto(ArrayList<Prodotto> listaProdottiAcquisto) {
		ListaProdottiAcquisto = listaProdottiAcquisto;
	}
	public Progetto getProgettoDiRiferimento() {
		return ProgettoDiRiferimento;
	}
	public void setProgettoDiRiferimento(Progetto progettoDiRiferimento) {
		ProgettoDiRiferimento = progettoDiRiferimento;
	}
	public float getSpesaOrdine() {
		return SpesaOrdine;
	}
	public void setSpesaOrdine(float spesaOrdine) {
		SpesaOrdine = spesaOrdine;
	}
	public boolean isMagazzinoVicino() {
		return MagazzinoVicino;
	}
	public void setMagazzinoVicino(boolean magazzinoVicino) {
		MagazzinoVicino = magazzinoVicino;
	}
	
	

	
}
