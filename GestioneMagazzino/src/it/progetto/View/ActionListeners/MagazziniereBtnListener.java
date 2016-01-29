package it.progetto.View.ActionListeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import it.progetto.Business.ProdottoBusiness;
import it.progetto.View.MagazziniereView;

public class MagazziniereBtnListener implements ActionListener{
	
	private MagazziniereView finestramag;
	
	public MagazziniereBtnListener(MagazziniereView finestra) {
		// TODO Auto-generated constructor stub
		super();
		this.finestramag=finestra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("ORDINI_PENDENTI".equals(e.getActionCommand())){
			BorderLayout layout=(BorderLayout) finestramag.getContentPane().getLayout();
			finestramag.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
			finestramag.getContentPane().add(finestramag.getCatalogo_ordini(),BorderLayout.CENTER);
			finestramag.getContentPane().remove(layout.getLayoutComponent(BorderLayout.EAST));
			finestramag.getContentPane().add(finestramag.getpulsantieraordini(),BorderLayout.EAST);
			finestramag.repaint();
			finestramag.revalidate();
		}
		else if("RIFORNIMENTO".equals(e.getActionCommand())){
			BorderLayout layout=(BorderLayout) finestramag.getContentPane().getLayout();
			finestramag.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
			finestramag.getContentPane().add(finestramag.getCatalogorif(),BorderLayout.CENTER);
			finestramag.getContentPane().remove(layout.getLayoutComponent(BorderLayout.EAST));
			finestramag.getContentPane().add(finestramag.getpulsantierarif(),BorderLayout.EAST);
			finestramag.repaint();
			finestramag.revalidate();
			
		}
		else if("MOSTRA_ORDINE".equals(e.getActionCommand())){
			
		}
		else if("RIFORNISCI".equals(e.getActionCommand())){
			JTable tabella=(JTable) finestramag.findDescendentByName(finestramag, "catalogo_rifornimento");
			int riga=tabella.getSelectedRow();
			try{
				JPanel pannello= new JPanel();
				pannello.setLayout(new BoxLayout(pannello, BoxLayout.Y_AXIS));
				JLabel text= new JLabel("Inserire la quantità di cui rifornirsi:");
				Vector<Integer> disponibilità = new Vector<Integer>();
				for(int i=1;i<11;i++){disponibilità.add(i);}
				JComboBox<Integer> scelta=new JComboBox<>(disponibilità);
				pannello.add(text);
				pannello.add(scelta);
				int result= JOptionPane.showOptionDialog(null, pannello, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(result==0){
					int qnt_ordinata=(int)scelta.getSelectedItem();
					int n_col=tabella.getColumnCount();
					ArrayList<String> prodotto= new ArrayList<String>();
					for(int i=0;i<n_col;i++){prodotto.add((String) tabella.getValueAt(riga, i));}
					ProdottoBusiness.getInstance().Rifornimento(prodotto, qnt_ordinata);
					tabella.setValueAt(qnt_ordinata,riga,4);
				}
			}
			catch(ArrayIndexOutOfBoundsException q){JOptionPane.showMessageDialog(finestramag, "Selezionare una riga.");}
		}
	}

}
