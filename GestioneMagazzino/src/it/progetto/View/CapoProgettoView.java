package it.progetto.View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import it.progetto.Model.CapoProgetto;
import it.progetto.Model.Sessione;
import it.progetto.View.ActionListeners.CapoProgettoBtnListener;

public class CapoProgettoView extends JFrame {
	
	private JPanel catalogo_per_dip= new JPanel();
	private JPanel catalogo_per_prog=new JPanel();
	private JPanel pulsantiera=new JPanel();
	
	public JPanel getRapporto_per_dip() {
		return catalogo_per_dip;
	}

	public JPanel getRapporto_per_prog() {
		return catalogo_per_prog;
	}

	public CapoProgettoView(){
		super("Riordina spese");
		Container c= getContentPane();
		c.setLayout(new BorderLayout());
		CapoProgetto cap=(CapoProgetto) Sessione.getInstance().session.get("utente_corrente");
		JLabel text1= new JLabel("Accesso effettuato come: "+cap.getNome()+" "+cap.getCognome()+".Organizza rapporto per:");
		JPanel nord= new JPanel();
		CapoProgettoBtnListener listener= new CapoProgettoBtnListener(this);
		JButton organizza_dip= new JButton("Dipendente");
		organizza_dip.setActionCommand("ORGANIZZA_PER_DIP");
		organizza_dip.addActionListener(listener);
		JButton organizza_prog=new JButton("Progetto");
		organizza_prog.setActionCommand("ORGANIZZA_PER_PROG");
		organizza_prog.addActionListener(listener);
		nord.setLayout(new FlowLayout());
		nord.add(text1);
		nord.add(organizza_dip);
		nord.add(organizza_prog);
		c.add(nord, BorderLayout.NORTH);
		//table organizzato per dipendente
		Vector<String[]> head_dip= new Vector<String[]>();
		String[] columnNames_dip = {"IdDipendente","CodMagazzino","Spesa","CodProgetto"};
		head_dip.addElement(columnNames_dip);
		DefaultTableModel model_per_dip= new DefaultTableModel() {
			
			public Class getColumnClass(int index) {
				return String.class;
			}
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model_per_dip.setColumnIdentifiers(columnNames_dip);
		Vector<String[]> rapporto_per_dip= cap.OrdinaSpeseDipendente(cap.getId());
		for(int i=0;i<rapporto_per_dip.size();i++){
			model_per_dip.addRow(rapporto_per_dip.get(i));
		}
		final JTable cat_per_dip=new JTable(model_per_dip);
		JScrollPane s1= new JScrollPane(cat_per_dip);
		catalogo_per_dip.setLayout(new GridLayout(1,1));
		catalogo_per_dip.add(s1);	
		//table organizzato per progetto 
		Vector<String[]> head_prog= new Vector<String[]>();
		String[] columnNames_prog = {"IdProgetto","Nome","SpesaTotale"};
		head_prog.addElement(columnNames_prog);
		DefaultTableModel model_per_prog= new DefaultTableModel() {
			
			public Class getColumnClass(int index) {
				return String.class;
			}
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model_per_prog.setColumnIdentifiers(columnNames_prog);
		Vector<String[]> rapporto_per_prog= cap.OrdinaSpeseProgetto(cap.getId());
		for(int i=0;i<rapporto_per_prog.size()-1;i++){
			model_per_prog.addRow(rapporto_per_prog.get(i));
		}
		final JTable cat_per_prog=new JTable(model_per_prog);
		JScrollPane s2= new JScrollPane(cat_per_prog);
		catalogo_per_prog.setLayout(new GridLayout(1,1));
		catalogo_per_prog.add(s2);	
		//
		JButton Stampa_Rapp=new JButton("Stampa Rapporto");
		Stampa_Rapp.setActionCommand("STAMPA_DISTINTA");
		Stampa_Rapp.addActionListener(listener);
		pulsantiera.add(Stampa_Rapp);
		c.add(pulsantiera, BorderLayout.EAST);
		JPanel sostitutivo=new JPanel();
		c.add(sostitutivo, BorderLayout.CENTER);
		
		
		
		
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
