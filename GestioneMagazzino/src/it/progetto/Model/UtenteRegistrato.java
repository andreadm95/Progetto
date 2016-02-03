package it.progetto.Model;

import it.progetto.DAO.UtenteRegistratoDAO;

public class UtenteRegistrato {

	  private int Id;
	  private String Nome;
	  private String Cognome;
	  private String Username;
	  private String Password;
	    
	public UtenteRegistrato() {
		super();
	}
	
	public UtenteRegistrato(String username, String password) {
		super();
		Username = username;
		Password = password;
	}
	
	public UtenteRegistrato(int id, String nome, String cognome, String username, String password) {
		super();
		setId(id);
		Nome = nome;
		Cognome = cognome;
		Username = username;
		Password = password;
	}
	
	public UtenteRegistrato(int id) {
		// TODO Auto-generated constructor stub
		Id=id;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public boolean login()
	{
		return UtenteRegistratoDAO.getInstance().userExists(this);
	}
	
	}
