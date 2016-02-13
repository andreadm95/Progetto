package it.progetto.View.ActionListeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import it.progetto.View.CapoProgettoView;

public class CapoProgettoBtnListener implements ActionListener{
	
	private CapoProgettoView finestracap;
	
	public CapoProgettoBtnListener(CapoProgettoView finestra) {
		// TODO Auto-generated constructor stub
		super();
		this.finestracap=finestra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("ORGANIZZA_PER_DIP".equals(e.getActionCommand())){
			BorderLayout layout=(BorderLayout) finestracap.getContentPane().getLayout();
			finestracap.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
			finestracap.getContentPane().add(finestracap.getRapporto_per_dip(), BorderLayout.CENTER);
			finestracap.repaint();
			finestracap.revalidate();
		}
		else if("ORGANIZZA_PER_PROG".equals(e.getActionCommand())){
			BorderLayout layout=(BorderLayout) finestracap.getContentPane().getLayout();
			finestracap.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
			finestracap.getContentPane().add(finestracap.getRapporto_per_prog(), BorderLayout.CENTER);
			finestracap.repaint();
			finestracap.revalidate();
		}
		else if("STAMPA_DISTINTA".equals(e.getActionCommand())){
			JTable tabella1=(JTable) finestracap.findDescendentByName(finestracap, "RAPPORTO PER DIPENDENTE");
			JTable tabella2=(JTable)finestracap.findDescendentByName(finestracap, "RAPPORTO PER PROGETTO");
			if(finestracap.getContentPane().isAncestorOf(tabella1)){
				try{
					tabella1.print(JTable.PrintMode.FIT_WIDTH);
				}
				catch(java.awt.print.PrinterException q){
					System.err.format("Impossibile stampare %s%n", q.getMessage());
				}
			}
			else if(finestracap.getContentPane().isAncestorOf(tabella2)){
				try{
					tabella2.print(JTable.PrintMode.FIT_WIDTH);
				}
				catch(java.awt.print.PrinterException q){
					System.err.format("Impossibile stampare %s%n", q.getMessage());
				}
			}
		}
	}

}
