package it.progetto.Model;

import java.util.ArrayList;
import java.util.Vector;

import it.progetto.DAO.OrdineDAO;

public class Ordine {

	  private int idOrdine;
      private String ProgettoDiRiferimento;
	  private float SpesaOrdine;
	  private int CodiceMagazzino;
	  private int DipendenteDiRiferimento;
	  private Vector<String[]> ListaProdotti;
	  
	public Ordine(int id){
		idOrdine=id;
	}

	public Ordine(int id,String progetto, float spesa, int codmagazzino, int cod_dipendente, Vector<String[]> lista){
		idOrdine=id;
		CodiceMagazzino=codmagazzino;
		DipendenteDiRiferimento=cod_dipendente;
		ProgettoDiRiferimento=progetto;
		SpesaOrdine=spesa;
		ListaProdotti=lista;
	}
	
	public Ordine(String progetto, float spesa, int codmagazzino, int cod_dipendente, Vector<String[]> lista){
		CodiceMagazzino=codmagazzino;
		DipendenteDiRiferimento=cod_dipendente;
		ProgettoDiRiferimento=progetto;
		SpesaOrdine=spesa;
		ListaProdotti=lista;
	}

	  
	 public int getIdOrdine() {
			return idOrdine;
		}

		public void setIdOrdine(int idOrdine) {
			this.idOrdine = idOrdine;
		}

		public int getDipendenteDiRiferimento() {
			return DipendenteDiRiferimento;
		}

		public void setDipendenteDiRiferimento(int dipendenteDiRiferimento) {
			DipendenteDiRiferimento = dipendenteDiRiferimento;
		}
			
		public String getProgettoDiRiferimento() {
			return ProgettoDiRiferimento;
		}
		public void setProgettoDiRiferimento(String progettoDiRiferimento) {
			ProgettoDiRiferimento = progettoDiRiferimento;
		}
		public float getSpesaOrdine() {
			return SpesaOrdine;
		}
		public void setSpesaOrdine(float spesaOrdine) {
			SpesaOrdine = spesaOrdine;
		}
		public int getCodiceMagazzino() {
			return CodiceMagazzino;
		}
		public void setCodiceMagazzino(int CodMagazzino) {
			CodiceMagazzino = CodMagazzino;
		}
		public Vector<String[]> getListaProdotti() {
			return ListaProdotti;
		}

		public void setListaProdotti(Vector<String[]> listaProdotti) {
			ListaProdotti = listaProdotti;
		}
		
		public boolean SalvaOrdine(Vector<String[]> prodottiordinati, int codmagazzino, int coddipendente, String progetto,float spesa){
			return OrdineDAO.getInstance().SalvaOrdine(prodottiordinati, codmagazzino, coddipendente, progetto,spesa);
		}
		
		public boolean EvadiOrdine(int id){
			return OrdineDAO.getInstance().ModificaEvadi(id);
		}
		
		public Vector<String[]> fornisciListaprod(int id_ordine){
			return OrdineDAO.getInstance().fornisciListaProdOrdinati(id_ordine);
		}

	
}
