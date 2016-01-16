package it.progetto.View.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.progetto.DAO.MagazzinoDAO;
import it.progetto.Model.CapoProgetto;
import it.progetto.Model.Dipendente;
import it.progetto.Model.Magazziniere;
import it.progetto.Model.Sistema;
import it.progetto.View.CapoProgettoView;
import it.progetto.View.DipendenteView;
import it.progetto.View.LoginView;
import it.progetto.View.MagazziniereView;
import it.progetto.View.OspiteView;

public class BtnListener implements ActionListener{
	
	private LoginView finestralogin;
	private JFrame finestrautente;
	
	public BtnListener(LoginView finestra) {
		super();
		this.finestralogin = finestra;
	}
	
	public BtnListener(JFrame finestra) {
		// TODO Auto-generated constructor stub
		super();
		this.finestrautente=finestra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if("REGISTRATO".equals(e.getActionCommand())){
			String username = finestralogin.username.getText();
			String password = finestralogin.password.getText();
			Object ruolo= Sistema.getInstance().Autenticazione(username, password);
				if(ruolo instanceof Dipendente){
					finestralogin.setVisible(false);
					new DipendenteView((Dipendente) ruolo);}
				else if(ruolo instanceof Magazziniere){
					finestralogin.setVisible(false);
					new MagazziniereView((Magazziniere) ruolo);}
				else if(ruolo instanceof CapoProgetto){
					finestralogin.setVisible(false);
					new CapoProgettoView((CapoProgetto) ruolo);}
				else{
					JOptionPane.showMessageDialog(null, "Credenziali errate");
					}
		}
		else if("OSPITE".equals(e.getActionCommand())){
			finestralogin.setVisible(false);
			Vector<String[]> lista=MagazzinoDAO.getInstance().fornisciCatalogo();
			new OspiteView(lista);
		}
		else if("ACCESSO".equals(e.getActionCommand())){
			finestrautente.setVisible(false);
			new LoginView();
		}
		else if("LONTANO".equals(e.getActionCommand())){
			
		}
		else if("AGGIUNGI".equals(e.getActionCommand())){
			
		}
		else if("CARRELLO".equals(e.getActionCommand())){
			
		}

}
}