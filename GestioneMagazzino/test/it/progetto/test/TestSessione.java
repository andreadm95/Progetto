package it.progetto.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.progetto.Model.CapoProgetto;
import it.progetto.Model.Dipendente;
import it.progetto.Model.Magazziniere;
import it.progetto.Model.Sessione;

public class TestSessione {
	
	//FIXTURE
	String usernameDIP;
	String passwordDIP;
	String usernameMAG;
	String passwordMAG;
	String usernameCAP;
	String passwordCAP;
	
	@Before
	public void setUp() throws Exception {
		usernameDIP="mario.rossi";
		passwordDIP="abc";
		usernameMAG="luca.russo";
		passwordMAG="opq";
		usernameCAP="luigi.bianco";
		passwordCAP="ghi300";
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	
	@Test
	public void testDip() {
		//Accesso come dipendente
		Sessione.getInstance().Autenticazione(usernameDIP, passwordDIP);
		assertTrue(Sessione.getInstance().session.get("utente_corrente") instanceof Dipendente);
	}
	
	@Test
	public void testMag() {
		//Accesso come magazziniere
		Sessione.getInstance().Autenticazione(usernameMAG, passwordMAG);
		assertTrue(Sessione.getInstance().session.get("utente_corrente") instanceof Magazziniere);
	}
	

	@Test
	public void testCapo() {
		//Accesso come capoprogetto
		Sessione.getInstance().Autenticazione(usernameCAP, passwordCAP);
		assertTrue(Sessione.getInstance().session.get("utente_corrente") instanceof CapoProgetto);
	}

	@Test
	public void testCredenzialiErrate() {
		//Credenziali errate
		Sessione.getInstance().Autenticazione("prova.errore", "quarantadue");
		assertSame(null, Sessione.getInstance().session.get("utente_corrente"));
	}

}
