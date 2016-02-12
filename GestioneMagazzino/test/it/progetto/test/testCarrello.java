package it.progetto.test;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.progetto.Model.Carrello;



public class testCarrello {
	
	//FIXTURE
	//Id,Nome,Categoria,Descrizione,Disponibilità,MaxOrdinabile,Fornitore,Produttore,Prezzo
	ArrayList<String> prodotto1=new ArrayList<String>();
	ArrayList<String> prodotto2=new ArrayList<String>();
	ArrayList<String> prodotto3=new ArrayList<String>();
	int qnt_ordinata1;
	int qnt_ordinata2;
	int qnt_ordinata3;
	
	@Before
	public void setUp() throws Exception {
		prodotto1.add("1");
		prodotto1.add("Chiavetta USB");
		prodotto1.add("Pc");
		prodotto1.add("8GB Nera");
		prodotto1.add("2");
		prodotto1.add("2");
		prodotto1.add("trs@gmail.it");
		prodotto1.add("sandisk");
		prodotto1.add("10.99");
		qnt_ordinata1=2;
		qnt_ordinata2=1;
		prodotto2.add("2");
		prodotto2.add("Toner");
		prodotto2.add("Stampante");
		prodotto2.add("Per stampante laser B/N");
		prodotto2.add("2");
		prodotto2.add("1");
		prodotto2.add("trs@gmail.it");
		prodotto2.add("samsung");
		prodotto2.add("40.99");
		qnt_ordinata3=1;
		prodotto3.add("3");
		prodotto3.add("Risma di carta");
		prodotto3.add("Cancelleria");
		prodotto3.add("200 fogli a4");
		prodotto3.add("2");
		prodotto3.add("2");
		prodotto3.add("qpo@hotmail.it");
		prodotto3.add("pigna");
		prodotto3.add("3.99");
	}
	
	@After
	public void tearDown() throws Exception {
		Carrello.getInstance().pulisciCarrello();
	}

	@Test
	public void test1() {
		//stesso prodotto ma qnt differente
		Carrello.getInstance().aggiungiProdottoACarrello(prodotto1, qnt_ordinata1);
		Carrello.getInstance().aggiungiProdottoACarrello(prodotto1, qnt_ordinata2);
		assertSame(1, Carrello.getInstance().getListaProdottiAcquisto().size());
	}
	
	@Test
	public void test2() {
		//due prodotti differenti e magazzino differente
		Carrello.getInstance().aggiungiProdottoACarrello(prodotto1, qnt_ordinata1);
		Carrello.getInstance().aggiungiProdottoACarrello(prodotto2, qnt_ordinata3);
		assertSame(1, Carrello.getInstance().getListaProdottiAcquisto().size());
	}
	
	@Test
	public void test3() {
		//due prodotti differenti e stesso magazzino 
		Carrello.getInstance().aggiungiProdottoACarrello(prodotto1, qnt_ordinata1);
		Carrello.getInstance().aggiungiProdottoACarrello(prodotto3, qnt_ordinata3);
		assertSame(2, Carrello.getInstance().getListaProdottiAcquisto().size());
	}
	
	@Test
	public void test4() {
		//rimozione prodotto da lista
		Carrello.getInstance().aggiungiProdottoACarrello(prodotto1, qnt_ordinata1);
		Carrello.getInstance().aggiungiProdottoACarrello(prodotto3, qnt_ordinata3);
		Carrello.getInstance().rimuoviProdotto(prodotto1);
		assertSame(1, Carrello.getInstance().getListaProdottiAcquisto().size());
	}

}
