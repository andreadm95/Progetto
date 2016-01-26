package it.progetto.Model;

public class Progetto {

	private String Nome;
	private float SpesaTotale;
	
	public Progetto(String nome, float spesatotale){
		Nome = nome;
		SpesaTotale = spesatotale;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public float getSpesaTotale() {
		return SpesaTotale;
	}
	public void setSpesaTotale(float spesaTotale) {
		SpesaTotale = spesaTotale;
	}
}
