package it.progetto.View.ActionListeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		}
		else if("AGGIUNGI2".equals(e.getActionCommand())){
		}
		else if("APRICARRELLO".equals(e.getActionCommand())){
			
		}

}
}