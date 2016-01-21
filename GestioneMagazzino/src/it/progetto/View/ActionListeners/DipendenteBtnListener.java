package it.progetto.View.ActionListeners;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import it.progetto.View.DipendenteView;

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
				if(disponibile>0){
					JPanel pannello= new JPanel(new FlowLayout());
					Vector<Integer> quantita = new Vector<Integer>();
					for(int j=1;j<=disponibile;j++){
						quantita.addElement(j);
						}
					JComboBox scelta=new JComboBox<>(quantita);
					pannello.add(scelta);
					pannello.setVisible(true);
					pannello.setSize(100,100);
					}
				else{JOptionPane.showMessageDialog(finestradip, "Prodotto non disponibile.");}
				}
			catch(Exception q){JOptionPane.showMessageDialog(finestradip, "Selezionare una riga.");}
			
		}
		else if("AGGIUNGI2".equals(e.getActionCommand())){
		}
		else if("APRICARRELLO".equals(e.getActionCommand())){
			
		}

}
}