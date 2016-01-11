package it.progetto.View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.progetto.View.ActionListeners.BtnListener;

public class OspiteView extends JFrame {

	public OspiteView(Vector<String[]> dati){
		super("Catalogo");
		final OspiteView finestra=this;
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Vector<String[]> head= new Vector<String[]>();
		String[] columnNames = {"Id","Nome", "Categoria", "Descrizione","Disponibilità","Numero Ordinabile","Fornitore","Produttore","Prezzo"};
		head.addElement(columnNames);
		DefaultTableModel model = new DefaultTableModel() {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model.setColumnIdentifiers(columnNames);
		for(int i=0;i<dati.size();i++){
		model.addRow(dati.get(i));}
		final JTable catalogo= new JTable(model);
		JScrollPane p=new JScrollPane(catalogo);
		c.add(p, BorderLayout.CENTER);
		JPanel spaziatura=new JPanel();
		c.add(spaziatura, BorderLayout.NORTH);
		JPanel bottoni= new JPanel();
		bottoni.setLayout(new FlowLayout());
		JButton Loginbtn=new JButton("Effettua il Login");
		Loginbtn.setActionCommand("ACCESSO");
		Loginbtn.addActionListener(new BtnListener(this));
		bottoni.add(Loginbtn);
		c.add(bottoni, BorderLayout.EAST);
		
		
		
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
