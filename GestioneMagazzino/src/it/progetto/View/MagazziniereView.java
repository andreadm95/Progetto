package it.progetto.View;

import javax.swing.JFrame;

import it.progetto.Model.Magazziniere;

public class MagazziniereView extends JFrame{
	
	public MagazziniereView(Magazziniere p){
		super("Effettua un operazione");
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		}

}
