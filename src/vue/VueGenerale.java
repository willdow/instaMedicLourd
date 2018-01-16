package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Main;

public class VueGenerale extends JFrame implements ActionListener 
{
	private JPanel panelMenu = new JPanel();
	private JButton tabButton [] = new JButton[4];
	private String[] tabNoms = {"Clients", "Techniciens", "Interventions", "Quitter"};
	
	private static VueClients uneVueClients = new VueClients();
	private static VueTech uneVueTech = new VueTech();
	private static VueInter uneVueInter = new VueInter();
	
	public VueGenerale(String droits)
	{
		this.setTitle("Gestion des interventions");
		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(200, 200, 720, 500);
		this.getContentPane().setBackground(Color.gray);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panelMenu.setBounds(0, 20, 700, 30);
		this.panelMenu.setLayout(new GridLayout(1,4));
		
		//Construction des boutons dans le panel
		for (int i=0; i<4; i++)
		{
			this.tabButton[i] = new JButton(tabNoms[i]);
			this.panelMenu.add(this.tabButton[i]);
			this.tabButton[i].addActionListener(this);
		}
		
		this.panelMenu.setVisible(true);
		this.add(this.panelMenu);
		
		//Ajout des trois paneaux
		this.add(uneVueClients);
		this.add(uneVueInter);
		this.add(uneVueTech);
		
		this.setVisible(true);
	}
	@Override
    public void actionPerformed(ActionEvent e) 
	{
    		
		if (e.getSource() == this.tabButton[3]) 
    	{
			this.dispose();
			Main.rendreVisible(true);
		} 
		else if (e.getSource() == this.tabButton[0]) 
		{
			uneVueClients.setVisible(true);
			uneVueTech.setVisible(false);
			uneVueInter.setVisible(false);
		} 
		else if (e.getSource() == this.tabButton[1]) 
		{
			uneVueTech.setVisible(true);
			uneVueClients.setVisible(false);
			uneVueInter.setVisible(false);
		} 
		else if (e.getSource() == this.tabButton[2]) 
		{
			uneVueTech.setVisible(false);
			uneVueInter.setVisible(true);
			uneVueClients.setVisible(false);
		}
    }
	
	public void refresh()
	{
		
	}
}
