package it.progetto.View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import it.progetto.Model.Carrello;
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
		String[] columnNames = {"Nome","Descrizione","Disponibilità","MaxOrdinabile","Prezzo","QntOrdinata"};
		head.addElement(columnNames);
		DefaultTableModel model= new DefaultTableModel() {
			
			public Class getColumnClass(int index) {
				return String.class;
				}
		    @Override
		    public boolean isCellEditable(int row, int column) {
		    	return false;
			    }
			};
		model.setColumnIdentifiers(columnNames);
		Vector<String[]> lista=Carrello.getInstance().getListaProdottiAcquisto();
		for(int i=0;i<lista.size();i++){
			model.addRow(lista.get(i));
		}
		final JTable lista_acquisto= new JTable(model);
		lista_acquisto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane s1=new JScrollPane(lista_acquisto);
		c.add(s1, BorderLayout.CENTER);
		
		setSize(800,800);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}

}
