package it.progetto.Model;

import it.progetto.DAO.ProgettoDAO;

public class Progetto {

	private int id;
	private String Nome;
	private float SpesaTotale;
	
	public Progetto(int idprog, String nome, float spesatotale){
		id=idprog;
		Nome = nome;
		SpesaTotale = spesatotale;
	}
	
	public Progetto(int id){
		this.id=id;
	}
	
	public Progetto(String nome){
		Nome = nome;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int recuperoid(String nomeprogetto){
		return ProgettoDAO.getInstance().recuperaid(nomeprogetto);
	}

	public void aggiornaSpesa(float spesa) {
		// TODO Auto-generated method stub
		ProgettoDAO.getInstance().aggiornaSpesaProgetto(getId(), spesa);
	}
}
