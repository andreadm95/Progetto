package it.progetto.View.ActionListeners;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import it.progetto.Model.Carrello;
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
			int n_col=tabella.getColumnCount();
			ArrayList<String> prodotto=new ArrayList<String>();
			try{
				tabella.getValueAt(riga, 0);
				for(int i=0;i<n_col;i++){
					prodotto.add((String) tabella.getValueAt(riga, i));
				}
				JPanel finestraquantità=new JPanel(new FlowLayout());
				QntBtnListener listener=new QntBtnListener(finestraquantità);
				int disponibile= Integer.parseInt(prodotto.get(5));
				if(disponibile>0){
					for(int j=1;j<=disponibile;j++){
						JButton a= new JButton(""+j);
						a.addActionListener(listener);
						finestraquantità.add(a);}
						JOptionPane.showOptionDialog(finestradip, finestraquantità,"Selezionare la quantità:", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
						//JOptionPane.showMessageDialog(finestradip, finestraquantità);
						//Carrello.getInstance().aggiungiProdottoACarrello(prodotto, quantità);
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