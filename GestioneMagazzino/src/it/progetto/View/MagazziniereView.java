package it.progetto.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import it.progetto.Business.MagazzinoBusiness;
import it.progetto.Model.Magazziniere;
import it.progetto.Model.Sessione;
import it.progetto.View.ActionListeners.MagazziniereBtnListener;

public class MagazziniereView extends JFrame{
	
	private JPanel catalogo_ordini=new JPanel();
	private JPanel catalogorif=new JPanel();
	private JPanel pulsantieraordini= new JPanel();
	private JPanel pulsantierarif= new JPanel();
	
	public JPanel getCatalogo_ordini() {
		return catalogo_ordini;
	}

	public JPanel getCatalogorif() {
		return catalogorif;
	}

	public JPanel getpulsantieraordini(){
		return pulsantieraordini;
	}
	
	public JPanel getpulsantierarif(){
		return pulsantierarif;
	}
	
	public Component trovaComponentePerNome(Container c, String name) {
		  if (c == null) return null;
		  if (name.equals(c.getName())) return c;
		  for (int i=0; i<c.getComponentCount(); i++) {
		    Component cmp = c.getComponent(i);
		    if (cmp instanceof Container) {
		      cmp = trovaComponentePerNome((Container) cmp, name);
		      if (cmp != null) return cmp;
		    } else if (name.equals(cmp.getName())) return cmp;
		  }
		  return null;
		}
	
	public MagazziniereView(){
		super("Effettua un operazione");
		Container c= getContentPane();
		c.setLayout(new BorderLayout());
		Magazziniere mag=(Magazziniere) Sessione.getInstance().session.get("utente_corrente");
		JLabel text= new JLabel("Accesso effettuato come: "+mag.getNome()+" "+mag.getCognome()+".");
		JPanel nord= new JPanel();
		MagazziniereBtnListener listener= new MagazziniereBtnListener(this);
		JButton mostraordini= new JButton("Mostra Ordini Pendenti");
		mostraordini.setActionCommand("ORDINI_PENDENTI");
		mostraordini.addActionListener(listener);
		JButton opera_rif=new JButton("Rifornisci Magazzino");
		opera_rif.setActionCommand("RIFORNIMENTO");
		opera_rif.addActionListener(listener);
		nord.setLayout(new FlowLayout());
		nord.add(text);
		nord.add(mostraordini);
		nord.add(opera_rif);
		c.add(nord, BorderLayout.NORTH);
		JPanel pannello_centrale=new JPanel();
		c.add(pannello_centrale, BorderLayout.CENTER);
		//organizzo table ordine
		Vector<String[]> head_ordine= new Vector<String[]>();
		String[] columnNames_ordine = {"Id Ordine","Progetto", "Evaso", "Nome Dipendente","Cognome Dipendente"};
		head_ordine.addElement(columnNames_ordine);
		DefaultTableModel model_ordine= new DefaultTableModel() {
			
			public Class getColumnClass(int index) {
				return String.class;
			}
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model_ordine.setColumnIdentifiers(columnNames_ordine);
		Vector<String[]> lista_ordini=new Vector<String[]>();
		lista_ordini= MagazzinoBusiness.getInstance().getListaOrdiniPendenti(mag.getMagazzinoAppartenenza());
		try{
			for(int i=0;i<lista_ordini.size();i++){
				model_ordine.addRow(lista_ordini.get(i));}
			final JTable cat_ordine= new JTable(model_ordine);
			cat_ordine.setName("catalogo_ordini");
			cat_ordine.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JScrollPane s2= new JScrollPane(cat_ordine);
			catalogo_ordini.setLayout(new GridLayout(1,1));
			catalogo_ordini.add(s2);
		}
		catch(NullPointerException q){
			JLabel text2= new JLabel("Non ci sono ordini da evadere.");
			catalogo_ordini.add(text2);}
		//organizzo table rifornimento prodotti
		Vector<String[]> head_rif= new Vector<String[]>();
		String[] columnNames = {"Id","Nome", "Categoria", "Descrizione","DisponibilitÓ","MaxOrdinabile","Fornitore","Produttore","Prezzo"};
		head_rif.addElement(columnNames);
		DefaultTableModel model_rif= new DefaultTableModel() {
			public Class getColumnClass(int index) {
				return String.class;
			}
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model_rif.setColumnIdentifiers(columnNames);
		Vector<String[]> lista= MagazzinoBusiness.getInstance().getListaProdottiVicini(mag.getMagazzinoAppartenenza());
		for(int i=0;i<lista.size();i++){
			model_rif.addRow(lista.get(i));}
		final JTable cat_rif= new JTable(model_rif);
		cat_rif.setName("catalogo_rifornimento");
		cat_rif.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane s1= new JScrollPane(cat_rif);
		catalogorif.setLayout(new GridLayout(1,1));
		catalogorif.add(s1);
		//pulsantiera ordine
		pulsantieraordini.setLayout(new BoxLayout(pulsantieraordini, BoxLayout.Y_AXIS));
		JButton ordine =new JButton("Mostra ordine");
		ordine.setActionCommand("MOSTRA_ORDINE");
		ordine.addActionListener(listener);
		JButton evadi= new JButton("Evadi Ordine");
		evadi.setActionCommand("EVADI_ORDINE");
		evadi.addActionListener(listener);
		pulsantieraordini.add(ordine);
		pulsantieraordini.add(evadi);
		//pulsantiera rifornimento
		JButton rifornimento =new JButton("Rifornisci");
		rifornimento.setActionCommand("RIFORNISCI");
		rifornimento.addActionListener(listener);
		pulsantierarif.add(rifornimento);
		//pannello sostitutivo
		JPanel pannello_EST= new JPanel();
		c.add(pannello_EST, BorderLayout.EAST);
		
		
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		}

}
