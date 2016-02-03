package it.progetto.Model;

import java.util.Vector;

import it.progetto.DAO.OrdineDAO;

public class Ordine {

	  private int idOrdine;
      private int codProgetto;
	  private float SpesaOrdine;
	  private int CodiceMagazzino;
	  private int DipendenteDiRiferimento;
	  private Vector<String[]> ListaProdotti;
	  
	public Ordine(int id){
		idOrdine=id;
	}

	public Ordine(int id,int progetto, float spesa, int codmagazzino, int cod_dipendente, Vector<String[]> lista){
		idOrdine=id;
		CodiceMagazzino=codmagazzino;
		DipendenteDiRiferimento=cod_dipendente;
		codProgetto=progetto;
		SpesaOrdine=spesa;
		ListaProdotti=lista;
	}
	
	public Ordine(int progetto, float spesa, int codmagazzino, int cod_dipendente){
		CodiceMagazzino=codmagazzino;
		DipendenteDiRiferimento=cod_dipendente;
		codProgetto=progetto;
		SpesaOrdine=spesa;
	}

	  
	 public Ordine() {
		// TODO Auto-generated constructor stub
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
			
		public int getProgettoDiRiferimento() {
			return codProgetto;
		}
		public void setProgettoDiRiferimento(int progettoDiRiferimento) {
			codProgetto = progettoDiRiferimento;
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
		
		public boolean SalvaOrdine(int codmagazzino, int coddipendente, int progetto,float spesa){
			return OrdineDAO.getInstance().SalvaOrdine(codmagazzino, coddipendente, progetto,spesa);
		}
		
		public boolean EvadiOrdine(int id){
			return OrdineDAO.getInstance().ModificaEvadi(id);
		}
		
		public Vector<String[]> fornisciListaprod(int id_ordine){
			return OrdineDAO.getInstance().fornisciListaProdOrdinati(id_ordine);
		}
		
		public int recuperoOrdineDaSalvare(){
			return OrdineDAO.getInstance().recuperoidOrdineDaSalvare();
		}

	
}
