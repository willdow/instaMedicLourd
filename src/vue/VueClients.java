package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Client;
import modele.modele;

public class VueClients extends JPanel implements ActionListener {
	
	private JTable tableClients;
	private JPanel panelEdition = new JPanel();
	private JButton btAjouter = new JButton("Ajoueter");
	private JButton btSupprimer = new JButton("Supprimer");
	
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtIdClient = new JTextField();
	
	
	
	public VueClients()
	{
		this.setBounds(20, 70, 660, 400);
		this.setLayout(null);
		this.setBackground(Color.red);
		
		//Construction de la Jtable
		String entete[] = {"Id Client", "Nom Client", "Prénom Client", "Adresse"};


		this.tableClients = new JTable(this.recupererLesClients(), entete){
		   public boolean isCellEditable(int row, int column){
		        return false;
		   }
		};
		this.tableClients.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent m) 
			{
					int ligne = tableClients.getSelectedRow();
					txtIdClient.setText(tableClients.getValueAt(ligne, 0).toString());
					txtNom.setText(tableClients.getValueAt(ligne, 1).toString());
					txtPrenom.setText(tableClients.getValueAt(ligne, 2).toString());
					txtAdresse.setText(tableClients.getValueAt(ligne, 3).toString());
			}
				
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//Affichage de la JTable dans une ScrollTable
		JScrollPane uneScroll = new JScrollPane(this.tableClients);
		uneScroll.setBounds(20, 20, 600, 250);
		uneScroll.setBackground(Color.black);
		this.add(uneScroll);
		this.tableClients.setEnabled(true);
		
		//construction du panel d'édition d'un client
		this.panelEdition.setBounds(20, 290, 600, 60);
		this.panelEdition.setLayout(new GridLayout(2, 4));
		this.panelEdition.add(new JLabel("ID Client : "));
		this.panelEdition.add(txtIdClient);
		this.panelEdition.add(new JLabel("Nom : "));
		this.panelEdition.add(txtNom);
		this.panelEdition.add(new JLabel("Prénom : "));
		this.panelEdition.add(txtPrenom);
		this.panelEdition.add(new JLabel("Adresse : "));
		this.panelEdition.add(txtAdresse);
		this.add(this.panelEdition);
		this.btAjouter.setBounds(100, 370, 100, 20);
		this.add(btAjouter);
		
		this.btSupprimer.setBounds(220, 370, 100, 20);
		this.add(btSupprimer);
		
		this.txtIdClient.setEditable(false);
		
		//rendre les boutons cliquables
		this.btAjouter.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		

		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAjouter)
		{
			Client unClient = new Client (txtNom.getText(), txtPrenom.getText(),txtAdresse.getText());
			modele.insertclient(unClient);
			JOptionPane.showMessageDialog(this, "Insertion réussie");
			txtNom.setText("");
			txtPrenom.setText("");
			txtAdresse.setText("");
		}
		
	}
	//recuperer les données sous formes d'une matrice
	private Object[][] recupererLesClients ()
	{
		ArrayList<Client> lesClients = modele.selectAllClients();
		Object[][] donnees = new Object[lesClients.size()][Client.getNbChampClients()];
		int i = 0;
		for (Client unClient : lesClients)
		{
			donnees[i][0] = unClient.getIdclient();
			donnees[i][1] = unClient.getNom();
			donnees[i][2] = unClient.getPrenom();
			donnees[i][3] = unClient.getAdresse();
			i++;
		}
	return donnees;
	}
}
