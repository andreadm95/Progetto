package it.progetto.View;

import javax.swing.JFrame;

import it.progetto.Model.Dipendente;

public class DipendenteView extends JFrame {
	
	public DipendenteView(Dipendente p){
		super("Effettua un ordine");
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
