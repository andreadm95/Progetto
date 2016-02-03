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

import it.progetto.Model.Carrello;
import it.progetto.View.CarrelloView;
import it.progetto.View.DipendenteView;
import it.progetto.View.LoginView;

public class DipendenteBtnListener implements ActionListener{
	
	private DipendenteView finestradip;
	
	public DipendenteBtnListener(DipendenteView finestra) {
		// TODO Auto-generated constructor stub
		super();
		this.finestradip=finestra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if("LONTANO".equals(e.getActionCommand())){
			BorderLayout layout=(BorderLayout) finestradip.getContentPane().getLayout();
			finestradip.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
			finestradip.getContentPane().add(finestradip.getCatlontano(),BorderLayout.CENTER);
			finestradip.getContentPane().remove(layout.getLayoutComponent(BorderLayout.EAST));
			finestradip.getContentPane().add(finestradip.getpulsantiera2(),BorderLayout.EAST);
			finestradip.repaint();
			finestradip.revalidate();
		}
		else if("CATPRINCIPALE".equals(e.getActionCommand())){
			BorderLayout layout=(BorderLayout) finestradip.getContentPane().getLayout();
			finestradip.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
			finestradip.getContentPane().add(finestradip.getCatvicino(),BorderLayout.CENTER);			
			finestradip.getContentPane().remove(layout.getLayoutComponent(BorderLayout.EAST));
			finestradip.getContentPane().add(finestradip.getpulsantiera1(),BorderLayout.EAST);
			finestradip.repaint();
			finestradip.revalidate();
			
		}
		else if("AGGIUNGI1".equals(e.getActionCommand())){
			JTable tabella=(JTable) finestradip.findDescendentByName(finestradip, "catalogo_vicino");
			int riga=tabella.getSelectedRow();
				try{
					int disponibile= Integer.parseInt((String)tabella.getValueAt(riga, 4));
					int max_ordinabile=Integer.parseInt((String)tabella.getValueAt(riga, 5));
					if(disponibile>0){
						JPanel pannello= new JPanel(new FlowLayout());
						JLabel text= new JLabel("Selezionare la quantità:");
						pannello.add(text);
						Vector<Integer> disponibilità = new Vector<Integer>();
						int n_col=tabella.getColumnCount();
						ArrayList<String> prodotto= new ArrayList<String>();
						for(int i=0;i<n_col;i++){prodotto.add((String) tabella.getValueAt(riga, i));}
						if(disponibile<=max_ordinabile){
							for(int j=1;j<=disponibile;j++){
								disponibilità.addElement(j);
								}
							JComboBox<Integer> scelta=new JComboBox<>(disponibilità);
							pannello.add(scelta);
							//ritorna 0 se premo ok, altrimenti -1
							int result= JOptionPane.showOptionDialog(null, pannello, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
							if(result==0){int qnt_ordinata=(int)scelta.getSelectedItem();
								boolean aggiunto=Carrello.getInstance().aggiungiProdottoACarrello(prodotto,qnt_ordinata);
								if(aggiunto==false){JOptionPane.showMessageDialog(finestradip, "Impossibile aggiungere il prodotto;Scegliere prodotti dello stesso catalogo.");}
							}
						}
						else{
							for(int j=1;j<=max_ordinabile;j++){
								disponibilità.addElement(j);
								}
							JComboBox<Integer> scelta=new JComboBox<>(disponibilità);
							pannello.add(scelta);
							//ritorna 0 se premo ok, altrimenti -1
							int result= JOptionPane.showOptionDialog(null, pannello, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
							if(result==0){int qnt_ordinata=(int)scelta.getSelectedItem();
								boolean aggiunto=Carrello.getInstance().aggiungiProdottoACarrello(prodotto,qnt_ordinata);
								if(aggiunto==false){JOptionPane.showMessageDialog(finestradip, "Impossibile aggiungere il prodotto;Scegliere prodotti dello stesso catalogo.");}
							}
						}	
					}
					else{JOptionPane.showMessageDialog(finestradip, "Prodotto non disponibile.");}
				}
				catch(ArrayIndexOutOfBoundsException q){JOptionPane.showMessageDialog(finestradip, "Selezionare una riga.");}	
		}
		else if("AGGIUNGI2".equals(e.getActionCommand())){
			JTable tabella=(JTable) finestradip.findDescendentByName(finestradip, "catalogo_lontano");
			int riga=tabella.getSelectedRow();
			try{
				int disponibile= Integer.parseInt((String)tabella.getValueAt(riga, 4));
				int max_ordinabile=Integer.parseInt((String)tabella.getValueAt(riga, 5));
				if(disponibile>0){
					JPanel pannello= new JPanel(new FlowLayout());
					JLabel text= new JLabel("Selezionare la quantità:");
					pannello.add(text);
					Vector<Integer> disponibilità = new Vector<Integer>();
					int n_col=tabella.getColumnCount();
					ArrayList<String> prodotto= new ArrayList<String>();
					for(int i=0;i<n_col;i++){prodotto.add((String) tabella.getValueAt(riga, i));}
					if(disponibile<=max_ordinabile){
						for(int j=1;j<=disponibile;j++){
							disponibilità.addElement(j);
							}
						JComboBox<Integer> scelta=new JComboBox<>(disponibilità);
						pannello.add(scelta);
						//ritorna 0 se premo ok, altrimenti -1
						int result= JOptionPane.showOptionDialog(null, pannello, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						if(result==0){int qnt_ordinata=(int)scelta.getSelectedItem();
							boolean aggiunto=Carrello.getInstance().aggiungiProdottoACarrello(prodotto,qnt_ordinata);
							if(aggiunto==false){JOptionPane.showMessageDialog(finestradip, "Impossibile aggiungere il prodotto;Scegliere prodotti dello stesso catalogo.");}
						}
					}
					else{
						for(int j=1;j<=max_ordinabile;j++){
							disponibilità.addElement(j);
							}
						JComboBox<Integer> scelta=new JComboBox<>(disponibilità);
						pannello.add(scelta);
						//ritorna 0 se premo ok, altrimenti -1
						int result= JOptionPane.showOptionDialog(null, pannello, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
						if(result==0){int qnt_ordinata=(int)scelta.getSelectedItem();
							boolean aggiunto=Carrello.getInstance().aggiungiProdottoACarrello(prodotto,qnt_ordinata);
							if(aggiunto==false){JOptionPane.showMessageDialog(finestradip, "Impossibile aggiungere il prodotto;Scegliere prodotti dello stesso catalogo.");}
						}
					}	
				}
				else{JOptionPane.showMessageDialog(finestradip, "Prodotto non disponibile.");}
			}
			catch(ArrayIndexOutOfBoundsException q){JOptionPane.showMessageDialog(finestradip, "Selezionare una riga.");}
		}
		else if("APRICARRELLO".equals(e.getActionCommand())){
			new CarrelloView();
		}
}
}