package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controleur.Technicien;
import modele.modele;

public class VueTech extends JPanel implements ActionListener 
{
	
	private JComboBox cbxTechnicien = new JComboBox();
	private JButton btOk = new JButton("OK");
	
	private JTextArea areaTech = new JTextArea();

	public VueTech()
	{
		this.setBounds(20, 70, 660, 380);
		this.setLayout(null);
		this.setBackground(Color.magenta);
		
		this.cbxTechnicien.setBounds(50, 50, 200, 20);
		this.add(cbxTechnicien);
		this.btOk.setBounds(300, 50, 80, 20);
		this.add(btOk);
		this.areaTech.setBounds(50, 80, 360, 150);
		this.add(this.areaTech);
		this.remplircbx();
		this.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void remplircbx() {
        ArrayList<Technicien> lestechniciens = modele.selectAllTechniciens();
        for (Technicien untech : lestechniciens) {
            this.cbxTechnicien.addItem(untech.getIdTech()+ " - " + untech.getNom() + " - " + untech.getPrenom());
        }
    }
}
