package it.progetto.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import it.progetto.Model.Carrello;
import it.progetto.Model.Dipendente;
import it.progetto.Model.Sessione;
import it.progetto.View.ActionListeners.CarrelloBtnListener;

public class CarrelloView extends JFrame {

	public Component findDescendentByName(Container cnt, String name) {
		  if (cnt == null) return null;
		  if (name.equals(cnt.getName())) return cnt;
		  for (int i = 0; i < cnt.getComponentCount(); ++i) {
		    Component cmp = cnt.getComponent(i);
		    if (cmp instanceof Container) {
		      cmp = findDescendentByName((Container) cmp, name);
		      if (cmp != null) return cmp;
		    } else if (name.equals(cmp.getName())) return cmp;
		  }
		  return null;
		}
	
	public CarrelloView(){
		super("Carrello Acquisti");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Dipendente dip=(Dipendente) Sessione.getInstance().session.get("utente_corrente");
		JLabel text= new JLabel("Accesso effettuato come: "+dip.getNome()+" "+dip.getCognome()+".");
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
		Vector<String[]> lista=Carrello.getInstance().getListaProdottiAcquisto();
		for(int i=0;i<lista.size();i++){
			model.addRow(lista.get(i));
		}
		 JTable lista_acquisto= new JTable(model);
		lista_acquisto.setName("lista_prodotti");
		lista_acquisto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane s1=new JScrollPane(lista_acquisto);
		c.add(s1, BorderLayout.CENTER);
		//pulsantiera
		JPanel pulsantiera= new JPanel();
		pulsantiera.setLayout(new BoxLayout(pulsantiera, BoxLayout.Y_AXIS));
		CarrelloBtnListener listener= new CarrelloBtnListener(this);
		JButton modifica_qnt= new JButton("Modifica Quantità");
		modifica_qnt.setActionCommand("MODIFICA");
		modifica_qnt.addActionListener(listener);
		JButton rimuovi= new JButton("Rimuovi da Carrello");
		rimuovi.setActionCommand("RIMUOVI");
		rimuovi.addActionListener(listener);
		JButton conferma= new JButton("Conferma Ordine");
		conferma.setActionCommand("CONFERMA");
		conferma.addActionListener(listener);
		pulsantiera.add(modifica_qnt);
		pulsantiera.add(rimuovi);
		pulsantiera.add(conferma);
		c.add(pulsantiera, BorderLayout.EAST);
		
		setSize(800,800);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}

}
