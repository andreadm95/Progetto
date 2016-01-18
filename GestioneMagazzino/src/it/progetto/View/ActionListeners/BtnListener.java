package it.progetto.View.ActionListeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.progetto.View.DipendenteView;


public class BtnListener implements ActionListener{
	
	private DipendenteView finestrautente;
	
	public BtnListener(DipendenteView finestra) {
		// TODO Auto-generated constructor stub
		super();
		this.finestrautente=finestra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if("LONTANO".equals(e.getActionCommand())){
		BorderLayout layout=(BorderLayout) finestrautente.getContentPane().getLayout();
		finestrautente.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
		finestrautente.getContentPane().add(finestrautente.getCatlontano(),BorderLayout.CENTER);
		finestrautente.getContentPane().remove(layout.getLayoutComponent(BorderLayout.EAST));
		finestrautente.getContentPane().add(finestrautente.getpulsantiera2(),BorderLayout.EAST);
		finestrautente.repaint();
		finestrautente.revalidate();
		}
		else if("CATPRINCIPALE".equals(e.getActionCommand())){
		BorderLayout layout=(BorderLayout) finestrautente.getContentPane().getLayout();
		finestrautente.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
		finestrautente.getContentPane().add(finestrautente.getCatvicino(),BorderLayout.CENTER);			
		finestrautente.getContentPane().remove(layout.getLayoutComponent(BorderLayout.EAST));
		finestrautente.getContentPane().add(finestrautente.getpulsantiera1(),BorderLayout.EAST);
		finestrautente.repaint();
		finestrautente.revalidate();
			
		}
		else if("AGGIUNGI".equals(e.getActionCommand())){
		}
		else if("APRICARRELLO".equals(e.getActionCommand())){
			
		}

}
}