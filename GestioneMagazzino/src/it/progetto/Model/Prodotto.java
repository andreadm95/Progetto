package it.progetto.Model;

public class Prodotto {

	private int idProdotto;
	private String Nome;
	private String Categoria;
	private String Descrizione;
	private float Prezzo;
	private int Disponibilitā;
	private int NumeroMaxOrdinabile;
	private String Fornitore;
	private String Produttore;
	
	public Prodotto(int id,String nome, String categoria, String descrizione, float prezzo, int disponibilitā,
			int numeroMaxOrdinabile, String fornitore, String produttore) {
		super();
		idProdotto=id;
		Nome = nome;
		Categoria = categoria;
		Descrizione = descrizione;
		Prezzo = prezzo;
		Disponibilitā = disponibilitā;
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
	public int getDisponibilitā() {
		return Disponibilitā;
	}
	public void setDisponibilitā(int disponibilitā) {
		Disponibilitā = disponibilitā;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Categoria == null) ? 0 : Categoria.hashCode());
		result = prime * result + ((Descrizione == null) ? 0 : Descrizione.hashCode());
		result = prime * result + Disponibilitā;
		result = prime * result + ((Fornitore == null) ? 0 : Fornitore.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + NumeroMaxOrdinabile;
		result = prime * result + Float.floatToIntBits(Prezzo);
		result = prime * result + ((Produttore == null) ? 0 : Produttore.hashCode());
		result = prime * result + idProdotto;
		return result;
	}
}
