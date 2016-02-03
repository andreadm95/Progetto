package it.progetto.View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.progetto.Business.OrdineBusiness;
import it.progetto.Model.Magazziniere;
import it.progetto.Model.Sessione;

public class ListaOrdineView extends JFrame {

	
	public ListaOrdineView(int id_ordine){
		super("Lista Ordine N°"+id_ordine);
		Container c= getContentPane();
		c.setLayout(new BorderLayout());
		Magazziniere mag=(Magazziniere) Sessione.getInstance().session.get("utente_corrente");
		JLabel text= new JLabel("Accesso effettuato come: "+mag.getNome()+" "+mag.getCognome()+".");
		c.add(text, BorderLayout.NORTH);
		Vector<String[]> head= new Vector<String[]>();
		String[] columnNames = {"Id","Nome", "Categoria", "Descrizione","Disponibilità","MaxOrdinabile","Fornitore","Produttore","Prezzo","QntOrdinata"};
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
		Vector<String[]> lista=OrdineBusiness.getInstance().recuperoListaProdotti(id_ordine);
		for(int i=0;i<lista.size();i++){
			model.addRow(lista.get(i));
		}
		 JTable lista_ordine= new JTable(model);
		 JScrollPane s1=new JScrollPane(lista_ordine);
		 c.add(s1, BorderLayout.CENTER);
		 
		 setSize(800,800);
		 setDefaultCloseOperation(HIDE_ON_CLOSE);
		 setVisible(true);
	}
}
