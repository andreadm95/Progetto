package it.progetto.View.ActionListeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			finestramag.repaint();
			finestramag.revalidate();
		}
		else if("RIFORNIMENTO".equals(e.getActionCommand())){
			BorderLayout layout=(BorderLayout) finestramag.getContentPane().getLayout();
			finestramag.getContentPane().remove(layout.getLayoutComponent(BorderLayout.CENTER));
			finestramag.getContentPane().add(finestramag.getCatalogorif(),BorderLayout.CENTER);
			finestramag.repaint();
			finestramag.revalidate();
			
		}
		else if("MOSTRA_ORDINE".equals(e.getActionCommand())){
			
		}
		else if("RIFORNISCI".equals(e.getActionCommand())){
			
		}
	}

}
