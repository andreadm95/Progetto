package it.progetto.View.ActionListeners;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.progetto.Model.CapoProgetto;
import it.progetto.Model.Dipendente;
import it.progetto.Model.Magazziniere;
import it.progetto.Model.Sessione;
import it.progetto.Model.Sistema;
import it.progetto.View.CapoProgettoView;
import it.progetto.View.DipendenteView;
import it.progetto.View.LoginView;
import it.progetto.View.MagazziniereView;
import it.progetto.View.OspiteView;

public class BtnListener implements ActionListener{
	
	private LoginView finestralogin;
	private DipendenteView finestrautente;
	private OspiteView finestraospite;
	
	public BtnListener(LoginView finestra) {
		super();
		this.finestralogin = finestra;
	}
	
	public BtnListener(DipendenteView finestra) {
		// TODO Auto-generated constructor stub
		super();
		this.finestrautente=finestra;
	}
	
	public BtnListener(OspiteView ospiteView) {
		// TODO Auto-generated constructor stub
		this.finestraospite=ospiteView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//I LISTENER VANNO SEPARATI IN BASE AL TIPO DI AZIONE CHE EFFETTUANO!!!
		if("REGISTRATO".equals(e.getActionCommand())){
			String username = finestralogin.username.getText();
			String password = finestralogin.password.getText();
			Sistema.getInstance().Autenticazione(username, password);
			if(Sessione.getInstance().session.get("utente_corrente") instanceof Dipendente){
				finestralogin.setVisible(false);
				new DipendenteView();}
			else if(Sessione.getInstance().session.get("utente_corrente") instanceof Magazziniere){
				finestralogin.setVisible(false);
				new MagazziniereView();}
			else if(Sessione.getInstance().session.get("utente_corrente") instanceof CapoProgetto){
				finestralogin.setVisible(false);
				new CapoProgettoView();}
			else{
				JOptionPane.showMessageDialog(null, "Credenziali errate");
				}
		}
		else if("OSPITE".equals(e.getActionCommand())){
			finestralogin.setVisible(false);
			new OspiteView();
		}
		else if("ACCESSO".equals(e.getActionCommand())){
			finestraospite.setVisible(false);
			new LoginView();
		}
		else if("LONTANO".equals(e.getActionCommand())){
		BorderLayout l=(BorderLayout) finestrautente.getContentPane().getLayout();
		finestrautente.getContentPane().remove(l.getLayoutComponent(BorderLayout.CENTER));
		finestrautente.getContentPane().add(finestrautente.getCatlontano(),BorderLayout.CENTER);
		finestrautente.repaint();
		finestrautente.revalidate();
		}
		else if("AGGIUNGI".equals(e.getActionCommand())){
			
		}
		else if("CARRELLO".equals(e.getActionCommand())){
			
		}

}
}