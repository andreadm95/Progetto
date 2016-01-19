package it.progetto.Model;

public class Prodotto {

	private int idProdotto;
	private String Nome;
	private String Categoria;
	private String Descrizione;
	private float Prezzo;
	private int Disponibilit�;
	private int NumeroMaxOrdinabile;
	private String Fornitore;
	private String Produttore;
	
	public Prodotto(int id,String nome, String categoria, String descrizione, float prezzo, int disponibilit�,
			int numeroMaxOrdinabile, String fornitore, String produttore) {
		super();
		idProdotto=id;
		Nome = nome;
		Categoria = categoria;
		Descrizione = descrizione;
		Prezzo = prezzo;
		Disponibilit� = disponibilit�;
		NumeroMaxOrdinabile = numeroMaxOrdinabile;
		Fornitore = fornitore;
		Produttore = produttore;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public float getPrezzo() {
		return Prezzo;
	}
	public void setPrezzo(float prezzo) {
		Prezzo = prezzo;
	}
	public int getDisponibilit�() {
		return Disponibilit�;
	}
	public void setDisponibilit�(int disponibilit�) {
		Disponibilit� = disponibilit�;
	}
	public int getNumeroMaxOrdinabile() {
		return NumeroMaxOrdinabile;
	}
	public void setNumeroMaxOrdinabile(int numeroMaxOrdinabile) {
		NumeroMaxOrdinabile = numeroMaxOrdinabile;
	}
	public String getFornitore() {
		return Fornitore;
	}
	public void setFornitore(String fornitore) {
		Fornitore = fornitore;
	}
	public String getProduttore() {
		return Produttore;
	}
	public void setProduttore(String produttore) {
		Produttore = produttore;
	}
	public int getIdProdotto() {
		return idProdotto;
	}
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
	

}
