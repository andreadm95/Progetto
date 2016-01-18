package it.progetto.View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.progetto.Model.Dipendente;
import it.progetto.Model.Magazzino;
import it.progetto.View.ActionListeners.BtnListener;

public class DipendenteView extends JFrame {
	
	public DipendenteView(Dipendente p){
		super("Effettua un ordine");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Vector<String[]> head= new Vector<String[]>();
		String[] columnNames = {"Id","Nome", "Categoria", "Descrizione","Disponibilità","MaxOrdinabile","Fornitore","Produttore","Prezzo"};
		head.addElement(columnNames);
		DefaultTableModel model = new DefaultTableModel() {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model.setColumnIdentifiers(columnNames);
		Vector<String[]> lista= Magazzino.getInstance().getListaProdottiVicini(p.getId());
		for(int i=0; i<lista.size();i++){
			model.addRow(lista.get(i));}
		final JTable catalogovicino= new JTable(model);
		JScrollPane s=new JScrollPane(catalogovicino);
		c.add(s, BorderLayout.CENTER);
		JLabel text= new JLabel("Accesso effettuato come: "+p.getNome()+" "+p.getCognome()+".");
		c.add(text, BorderLayout.NORTH);
		JButton catlontano=new JButton("Altro Catalogo");
		catlontano.setActionCommand("LONTANO");
		catlontano.addActionListener(new BtnListener(this));
		JButton aggiungi=new JButton("Aggiungi al Carrello");
		aggiungi.setActionCommand("AGGIUNGI");
		aggiungi.addActionListener(new BtnListener(this));
		JButton apricarrello=new JButton("Vai al Carrello");
		apricarrello.setActionCommand("APRICARRELLO");
		apricarrello.addActionListener(new BtnListener(this));
		JPanel bottoni= new JPanel();
		bottoni.setLayout(new BoxLayout(bottoni, BoxLayout.Y_AXIS));
		bottoni.add(catlontano);
		bottoni.add(aggiungi);
		bottoni.add(apricarrello);
		c.add(bottoni, BorderLayout.EAST);
		
		
		
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
