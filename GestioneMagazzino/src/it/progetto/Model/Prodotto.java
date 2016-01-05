package it.progetto.Model;

public class Prodotto {

	private int idProdotto;
	private String Nome;
	private String Categoria;
	private String Descrizione;
	private float Prezzo;
	private int Disponibilità;
	private int NumeroMaxOrdinabile;
	private String Fornitore;
	private String Produttore;
	
	public Prodotto(String nome, String categoria, String descrizione, float prezzo, int disponibilità,
			int numeroMaxOrdinabile, String fornitore, String produttore) {
		super();
		Nome = nome;
		Categoria = categoria;
		Descrizione = descrizione;
		Prezzo = prezzo;
		Disponibilità = disponibilità;
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
	public int getDisponibilità() {
		return Disponibilità;
	}
	public void setDisponibilità(int disponibilità) {
		Disponibilità = disponibilità;
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
