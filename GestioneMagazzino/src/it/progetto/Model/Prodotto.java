package it.progetto.Model;

public class Prodotto {

	private String Nome;
	private String Categoria;
	private String Descrizione;
	private float Prezzo;
	private int Disponibilità;
	private int NumeroMaxOrdinabile;
	private String Fornitore;
	private String Produttore;
	
	public String getNome() {
		return Nome;
	}
	public String getCategoria() {
		return Categoria;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public float getPrezzo() {
		return Prezzo;
	}
	public int getDisponibilità() {
		return Disponibilità;
	}
	public int getNumeroMaxOrdinabile() {
		return NumeroMaxOrdinabile;
	}
	public String getFornitore() {
		return Fornitore;
	}
	public String getProduttore() {
		return Produttore;
	}
	
}
