package it.progetto.View.ActionListeners;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.progetto.Model.Carrello;
import it.progetto.Model.Dipendente;
import it.progetto.Model.Sessione;
import it.progetto.Model.Sistema;
import it.progetto.View.CarrelloView;
import it.progetto.View.DipendenteView;

public class CarrelloBtnListener implements ActionListener{
	
	private CarrelloView finestra;
	
	public CarrelloBtnListener(CarrelloView finestra) {
		// TODO Auto-generated constructor stub
		this.finestra=finestra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("MODIFICA".equals(e.getActionCommand())){
			JTable tabella=(JTable) finestra.trovaComponentePerNome(finestra, "lista_prodotti");
			int riga=tabella.getSelectedRow();
			try{
				int disponibile= Integer.parseInt((String)tabella.getValueAt(riga, 4));
				int max_ordinabile=Integer.parseInt((String)tabella.getValueAt(riga, 5));
				Vector<Integer> disponibilit� = new Vector<Integer>();
				int n_col=tabella.getColumnCount();
				ArrayList<String> prodotto= new ArrayList<String>();
				for(int i=0;i<n_col;i++){prodotto.add((String) tabella.getValueAt(riga, i));}
				if(disponibile<=max_ordinabile){
					for(int j=1;j<=disponibile;j++){
						disponibilit�.addElement(j);
						}}
				else{
					for(int j=1;j<=max_ordinabile;j++){
						disponibilit�.addElement(j);
						}}
				JPanel pannello= new JPanel(new FlowLayout());
				JLabel text= new JLabel("Selezionare la quantit�:");
				pannello.add(text);
				JComboBox<Integer> scelta=new JComboBox<>(disponibilit�);
				pannello.add(scelta);
				//ritorna 0 se premo ok, altrimenti -1
				int result= JOptionPane.showOptionDialog(null, pannello, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(result==0){
					int qnt_ordinata=(int)scelta.getSelectedItem();
					Carrello.getInstance().aggiungiProdottoACarrello(prodotto,qnt_ordinata);
					tabella.setValueAt(Integer.toString((int) scelta.getSelectedItem()), riga , 9);
					JLabel spesa= (JLabel) finestra.trovaComponentePerNome(finestra, "Spesa");
					spesa.setText("La spesa totale �:"+Carrello.getInstance().calcoloSpesaTotale());}
			}
			catch(ArrayIndexOutOfBoundsException q){JOptionPane.showMessageDialog(finestra, "Selezionare una riga.");}
		}
		else if("RIMUOVI".equals(e.getActionCommand())){
			JTable tabella=(JTable) finestra.trovaComponentePerNome(finestra, "lista_prodotti");
			int riga=tabella.getSelectedRow();
			try{
			int n_col=tabella.getColumnCount();
			ArrayList<String> prodotto= new ArrayList<String>();
			for(int i=0;i<n_col;i++){prodotto.add((String) tabella.getValueAt(riga, i));}
			Carrello.getInstance().rimuoviProdotto(prodotto);
			DefaultTableModel model= (DefaultTableModel) tabella.getModel();
			model.removeRow(riga);
			tabella.setModel(model);
			JLabel spesa= (JLabel) finestra.trovaComponentePerNome(finestra, "Spesa");
			spesa.setText("La spesa totale �:"+Carrello.getInstance().calcoloSpesaTotale());}
			catch(ArrayIndexOutOfBoundsException q){JOptionPane.showMessageDialog(finestra, "Selezionare una riga.");}
		}
		else if("CONFERMA".equals(e.getActionCommand())){
			JTable tabella=(JTable) finestra.trovaComponentePerNome(finestra, "lista_prodotti");
			if(tabella.getRowCount()==0){JOptionPane.showMessageDialog(finestra, "Attenzione!Carrello vuoto.");}
			else{
				Dipendente dip=(Dipendente) Sessione.getInstance().session.get("utente_corrente");
				Vector<String> progetti= new Vector<String>(dip.progettiDipendente());
				JComboBox<String> scelta_progetto= new JComboBox<>(progetti);
				JPanel pannello= new JPanel(new FlowLayout());
				JLabel text= new JLabel("Selezionare il progetto su cui scaricare la spesa:");
				pannello.add(text);
				pannello.add(scelta_progetto);
				int result= JOptionPane.showOptionDialog(null, pannello, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(result==0){
					String progetto_scelto= (String) scelta_progetto.getSelectedItem();
					if(Sistema.getInstance().SalvaOrdine(progetto_scelto, Carrello.getInstance().calcoloSpesaTotale(), Carrello.getInstance().getCodMagazzino(), dip.getId(), Carrello.getInstance().getListaProdottiAcquisto())){
					JTable dati=(JTable) finestra.trovaComponentePerNome(finestra, "lista_prodotti");
					try{
						dati.print(JTable.PrintMode.FIT_WIDTH);
					}
					catch(java.awt.print.PrinterException q){
						System.err.format("Impossibile stampare %s%n", q.getMessage());
					}
					JOptionPane.showMessageDialog(finestra, "Ordine salvato correttamente");
					Carrello.getInstance().pulisciCarrello();
					finestra.setVisible(false);
					new DipendenteView();
					}
					else{JOptionPane.showMessageDialog(finestra, "Impossibile salvare l'ordine.");}
				}
			}	
		}
		else if("INDIETRO".equals(e.getActionCommand())){
			finestra.setVisible(false);
			new DipendenteView();
		}
	}
}