package it.progetto.View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.progetto.View.ActionListeners.LoginBtnListener;

public class LoginView extends JFrame {

	public JTextField username = new JTextField();
	public JPasswordField password = new JPasswordField();
	
	
	public LoginView(){
		super("Accedi...");
		Container c= this.getContentPane();
		this.setLayout(new BorderLayout());
		JLabel text1= new JLabel("Effettua il login");
		text1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		JPanel ovest= new JPanel();
		ovest.setLayout(new GridLayout(2, 1));
		JLabel text2= new JLabel("Username:        ");
		JLabel text3= new JLabel("Password:        ");
		JPanel centro= new JPanel(); 
		centro.setLayout(new GridLayout(2,1));
		JPanel sud= new JPanel(); 
		sud.setLayout(new FlowLayout());
		JButton login= new JButton("Accedi");
		login.setActionCommand("REGISTRATO");
		login.addActionListener(new LoginBtnListener(this));
		JButton ospite= new JButton("Accedi come Ospite");
		ospite.setActionCommand("OSPITE");
		ospite.addActionListener(new LoginBtnListener(this));
		
		c.add(text1, BorderLayout.NORTH);
		ovest.add(text2);
		ovest.add(text3);
		c.add(ovest, BorderLayout.WEST);
		centro.add(username);
		centro.add(password);
		c.add(centro, BorderLayout.CENTER);
		sud.add(login);
		sud.add(ospite);
		c.add(sud, BorderLayout.SOUTH);
		
	
		this.setSize(400,400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
