package it.progetto.test;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRicercaComponentePerNome {

	//FIXTURE
	JFrame finestra=new JFrame();
	JPanel pan_interno=new JPanel();
	JTable tabella=new JTable();
	
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
	@Before
	public void setUp() throws Exception {
		Container c=finestra.getContentPane();
		tabella.setName("PROVA");
		pan_interno.add(tabella);
		c.add(pan_interno);
	}
	
	@After
	public void tearDown() throws Exception {}
	
	@Test
	public void test() {
		assertNotNull(trovaComponentePerNome(finestra, "PROVA"));
	}

}
