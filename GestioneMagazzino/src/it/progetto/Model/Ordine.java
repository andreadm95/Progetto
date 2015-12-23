package it.progetto.Model;

import java.util.ArrayList;

public class Ordine {

	  private int idOrdine;
	  private ArrayList<Prodotto> ListaProdottiAcquisto;
      private int ProgettoDiRiferimento;
	  private float SpesaOrdine;
	  private int CodiceMagazzino;
	  private int DipendenteDiRiferimento;
	  
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
	public ArrayList<Prodotto> getListaProdottiAcquisto() {
		return ListaProdottiAcquisto;
	}
	public void setListaProdottiAcquisto(ArrayList<Prodotto> listaProdottiAcquisto) {
		ListaProdottiAcquisto = listaProdottiAcquisto;
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
	public void setCodiceMagazzino(int codmagazzino) {
		CodiceMagazzino = codmagazzino;
	}

	public int getDipendenteDiRiferimento() {
		return DipendenteDiRiferimento;
	}

	public void setDipendenteDiRiferimento(int dipendenteDiRiferimento) {
		DipendenteDiRiferimento = dipendenteDiRiferimento;
	}
	
	

	
}
