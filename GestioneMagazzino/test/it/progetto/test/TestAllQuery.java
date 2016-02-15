package it.progetto.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.progetto.DbConnection.DbConnection;
import it.progetto.Model.CapoProgetto;
import it.progetto.Model.Dipendente;
import it.progetto.Model.Magazziniere;
import it.progetto.Model.Magazzino;
import it.progetto.Model.UtenteRegistrato;

public class TestAllQuery {
	
	//FIXTURE
	UtenteRegistrato u=new UtenteRegistrato();
	Dipendente dip=new Dipendente();
	Magazziniere mag= new Magazziniere();
	CapoProgetto capo=new CapoProgetto();
	Magazzino deposito= new Magazzino();

	@Before
	public void setUp() throws Exception {
		u.setUsername("mario.rossi");
		u.setPassword("abc");
		dip.setUsername("mario.rossi");
		dip.setPassword("abc");
		mag.setUsername("luca.russo");
		mag.setPassword("opq");
		capo.setUsername("luigi.bianco");
		capo.setPassword("ghi300");
		deposito.setIdMagazzino(1);
	}
	
	@After
	public void tearDown() throws Exception {
	DbConnection.getInstance().disconnetti();	
	}
	
	@Test
	public void testUtenteRegistrato() {
		assertTrue(u.login());
	}

	@Test
	public void testDipendente() {
		assertTrue(dip.isDipendente());
	}
	
	@Test
	public void testDipendente3() {
		assertNotNull(dip.SedeDipendente());
	}
	
	@Test
	public void testMagazziniere() {
		assertTrue(mag.isMagazziniere());
	}
	
	@Test
	public void testCapoProgetto() {
		assertTrue(capo.isCapoProgetto());
	}
	
	@Test
	public void testCapoProgetto2() {
		assertNotNull(capo.OrdinaSpeseDipendente());
	}
	
	@Test
	public void testMagazzino1() {
		assertNotNull(deposito.getListaProdottiTot());
	}
	
	@Test
	public void testMagazzino2() {
		assertNotNull(deposito.getListaProdottiVicini());
	}
	
	@Test
	public void testMagazzino3() {
		assertNotNull(deposito.getListaProdottiLontano());
	}
}
