package it.progetto.View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
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
import it.progetto.Model.Sessione;
import it.progetto.View.ActionListeners.BtnListener;

public class DipendenteView extends JFrame {
	
	private JPanel catvicino= new JPanel();
	private JPanel catlontano= new JPanel();
	private JPanel pulsantiera1= new JPanel();
	private JPanel pulsantiera2= new JPanel();

	public JPanel getpulsantiera1(){
		return pulsantiera1;
	}
	
	public JPanel getpulsantiera2(){
		return pulsantiera2;
	}

	public JPanel getCatvicino() {
		return catvicino;
	}

	public JPanel getCatlontano() {
		return catlontano;
	}
	
	public DipendenteView(){
		super("Effettua un ordine");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		Dipendente dip=(Dipendente) Sessione.getInstance().session.get("utente_corrente");
		JLabel text= new JLabel("Accesso effettuato come: "+dip.getNome()+" "+dip.getCognome()+".");
		c.add(text, BorderLayout.NORTH);
		Vector<String[]> head= new Vector<String[]>();
		String[] columnNames = {"Id","Nome", "Categoria", "Descrizione","DisponibilitÓ","MaxOrdinabile","Fornitore","Produttore","Prezzo"};
		head.addElement(columnNames);
		//organizzo catalogo vicino
		DefaultTableModel model1= new DefaultTableModel() {
			
			public Class getColumnClass(int index) {
				return String.class;
			}
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model1.setColumnIdentifiers(columnNames);
		Vector<String[]> lista= Magazzino.getInstance().getListaProdottiVicini(dip.getId());
		for(int i=0; i<lista.size();i++){
			model1.addRow(lista.get(i));}
		final JTable catalogovicino= new JTable(model1);
		JScrollPane s1=new JScrollPane(catalogovicino);
		c.add(s1, BorderLayout.CENTER);
		catvicino.setLayout(new GridLayout(1,1));
		catvicino.add(s1);
		c.add(catvicino, BorderLayout.CENTER);
		//organizzo catalogo lontano
		DefaultTableModel model2= new DefaultTableModel() {
			
			public Class getColumnClass(int index) {
				return String.class;
			}
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model2.setColumnIdentifiers(columnNames);
		Vector<String[]> lista2= Magazzino.getInstance().getListaProdottiLontano(dip.getId());
		for(int j=0; j<lista2.size();j++){
			model2.addRow(lista2.get(j));}
		final JTable catalogolontano= new JTable(model2);
		JScrollPane s2=new JScrollPane(catalogolontano);
		catlontano.setLayout(new GridLayout(1,1));
		catlontano.add(s2);
		//pulsantiera primaria
		JButton altrocat=new JButton("Altro Catalogo");
		altrocat.setActionCommand("LONTANO");
		altrocat.addActionListener(new BtnListener(this));
		JButton aggiungi=new JButton("Aggiungi al Carrello");
		aggiungi.setActionCommand("AGGIUNGI");
		aggiungi.addActionListener(new BtnListener(this));
		JButton apricarrello=new JButton("Vai al Carrello");
		apricarrello.setActionCommand("APRICARRELLO");
		apricarrello.addActionListener(new BtnListener(this));
		pulsantiera1.setLayout(new BoxLayout(pulsantiera1, BoxLayout.Y_AXIS));
		pulsantiera1.add(altrocat);
		pulsantiera1.add(aggiungi);
		pulsantiera1.add(apricarrello);
		c.add(getpulsantiera1(), BorderLayout.EAST);
		//pulsantiera secondaria
		JButton catprincipale= new JButton("Catalogo vicino");
		catprincipale.setActionCommand("CATPRINCIPALE");
		catprincipale.addActionListener(new BtnListener(this));
		JButton aggiungi2=new JButton("Aggiungi al Carrello");
		aggiungi2.setActionCommand("AGGIUNGI");
		aggiungi2.addActionListener(new BtnListener(this));
		JButton apricarrello2=new JButton("Vai al Carrello");
		apricarrello2.setActionCommand("APRICARRELLO");
		apricarrello2.addActionListener(new BtnListener(this));
		pulsantiera2.setLayout(new BoxLayout(pulsantiera2, BoxLayout.Y_AXIS));
		pulsantiera2.add(catprincipale);
		pulsantiera2.add(aggiungi2);
		pulsantiera2.add(apricarrello2);
		
		
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		}
		}
