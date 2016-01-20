package it.progetto.Model;

import it.progetto.DAO.OrdineDAO;

public class Ordine {

	  private int idOrdine;
      private int ProgettoDiRiferimento;
	  private float SpesaOrdine;
	  private int CodiceMagazzino;
	  private int DipendenteDiRiferimento;

	
	public Ordine(int id, int codmagazzino, int cod_dipendente, int codprogetto, float spesa){
		idOrdine=id;
		CodiceMagazzino=codmagazzino;
		DipendenteDiRiferimento=cod_dipendente;
		ProgettoDiRiferimento=codprogetto;
		SpesaOrdine=spesa;
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
			return ProgettoDiRiferimento;
		}
		public void setProgettoDiRiferimento(int progettoDiRiferimento) {
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
		
		public boolean EvadiOrdine(int id){
			return OrdineDAO.getInstance().ModificaEvadi(id);
		}

	
}
