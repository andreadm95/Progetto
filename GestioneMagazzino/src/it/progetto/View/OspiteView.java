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

import it.progetto.Model.Magazzino;
import it.progetto.View.ActionListeners.BtnListener;

public class OspiteView extends JFrame {

	public OspiteView(){
		super("Catalogo");
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
		Vector<String[]> lista=Magazzino.getInstance().getListaProdottiTot();
		for(int i=0;i<lista.size();i++){
		model.addRow(lista.get(i));}
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
