package it.progetto.View.ActionListeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	}

}
