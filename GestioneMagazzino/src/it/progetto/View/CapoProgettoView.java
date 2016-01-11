package it.progetto.View;

import javax.swing.JFrame;

import it.progetto.Model.CapoProgetto;

public class CapoProgettoView extends JFrame {
	
	public CapoProgettoView(CapoProgetto p){
		super("Riordina spese");
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
