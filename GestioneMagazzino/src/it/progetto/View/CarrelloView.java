package it.progetto.View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.progetto.Model.Dipendente;
import it.progetto.Model.Sessione;

public class CarrelloView extends JFrame {
	
	public CarrelloView(){
		super("Carrello Acquisti");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Dipendente dip=(Dipendente) Sessione.getInstance().session.get("utente_corrente");
		JLabel text= new JLabel("Accesso effettuato come: "+dip.getNome()+" "+dip.getCognome()+".");
		c.add(text, BorderLayout.NORTH);
		Vector<String[]> head= new Vector<String[]>();
		String[] columnNames = {"Id","Nome", "Categoria", "Descrizione","Disponibilità","MaxOrdinabile","Fornitore","Produttore","Prezzo"};
		head.addElement(columnNames);
		DefaultTableModel model= new DefaultTableModel() {};
		final JTable lista_acquisto= new JTable(model);
	}

}
