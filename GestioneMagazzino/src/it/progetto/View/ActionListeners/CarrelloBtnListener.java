package it.progetto.View.ActionListeners;

import java.awt.BorderLayout;
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
import it.progetto.View.CarrelloView;

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
			JTable tabella=(JTable) finestra.findDescendentByName(finestra, "lista_prodotti");
			int riga=tabella.getSelectedRow();
			try{
				int disponibile= Integer.parseInt((String)tabella.getValueAt(riga, 4));
				int max_ordinabile=Integer.parseInt((String)tabella.getValueAt(riga, 5));
				JPanel pannello= new JPanel(new FlowLayout());
				JLabel text= new JLabel("Selezionare la quantit�:");
				pannello.add(text);
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
				JComboBox<Integer> scelta=new JComboBox<>(disponibilit�);
				pannello.add(scelta);
				//ritorna 0 se premo ok, altrimenti -1
				int result= JOptionPane.showOptionDialog(null, pannello, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(result==0){int qnt_ordinata=(int)scelta.getSelectedItem();
				Carrello.getInstance().aggiungiProdottoACarrello(prodotto,qnt_ordinata);
				tabella.setValueAt(Integer.toString((int) scelta.getSelectedItem()), riga , 9);
				JLabel spesa= (JLabel) finestra.findDescendentByName(finestra, "Spesa");
				spesa.setText("La spesa totale �:"+Carrello.getInstance().getSpesaTotale());}
			}
			catch(ArrayIndexOutOfBoundsException q){JOptionPane.showMessageDialog(finestra, "Selezionare una riga.");}
		}
		else if("RIMUOVI".equals(e.getActionCommand())){
			JTable tabella=(JTable) finestra.findDescendentByName(finestra, "lista_prodotti");
			int riga=tabella.getSelectedRow();
			int n_col=tabella.getColumnCount();
			ArrayList<String> prodotto= new ArrayList<String>();
			for(int i=0;i<n_col;i++){prodotto.add((String) tabella.getValueAt(riga, i));}
			Carrello.getInstance().rimuoviProdotto(prodotto);
			DefaultTableModel model= (DefaultTableModel) tabella.getModel();
			model.removeRow(riga);
			tabella.setModel(model);

		}
		else if("CONFERMA".equals(e.getActionCommand())){
			
		}
	}

}
