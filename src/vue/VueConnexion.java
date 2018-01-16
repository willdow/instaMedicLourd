package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Main;
import modele.modele;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{

	private static final long serialVersionUID = 1L;
	private JPanel unPanel = new JPanel();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btSeConnecter = new JButton("Se Connecter");
	private JTextField txtLogin = new JTextField();
	private JPasswordField pwdMdp = new JPasswordField();
	
	public VueConnexion()
	{
		this.setTitle("Connexion à mon logiciel Intervention");
		this.setBounds(200,200,500,350);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.cyan);
		
		
		//Construction du panel
		this.unPanel.setBounds(50, 150, 400, 150);
		this.unPanel.setBackground(Color.yellow);
		this.unPanel.setLayout(new GridLayout(3,2));
		this.unPanel.add(new JLabel("Login :"));
		this.unPanel.add(this.txtLogin);
		this.unPanel.add(new JLabel("MDP :"));
		this.unPanel.add(this.pwdMdp);
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btSeConnecter);
		
		this.unPanel.setVisible(true);
		this.add(this.unPanel);
		
		//mettre un logo
		ImageIcon logo = new ImageIcon("src/images/logo.png");
		JLabel lbLogo = new JLabel(logo);
		lbLogo.setBounds(50, 20, 400, 100);
		this.add(lbLogo);
		
		//Changer icone application
		ImageIcon logopetit = new ImageIcon("src/images/logopetit.png");
		this.setIconImage(logopetit.getImage());

		
		//Rendre les boutons cliquables
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		//Rendre la touche entrée écoutable
		this.txtLogin.addKeyListener(this);
		this.pwdMdp.addKeyListener(this);
		
		
		this.setVisible(true);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Annuler" :
			this.txtLogin.setText("");
			this.pwdMdp.setText("");
			break;
			
		case "Se Connecter":
			traitement();
			break;
		}
	}
	
	public void traitement ()
	{
		String login = this.txtLogin.getText();
		String mdp = new String(this.pwdMdp.getPassword());
		if (login.equals("") || mdp.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Veuillez remplir les identifiants", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		String droits = modele.verifConnexion(login, mdp);
		if (droits.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Erreur d'identifiants", 
			"Erreur", JOptionPane.ERROR_MESSAGE);
			this.txtLogin.setText("");
			this.pwdMdp.setText("");
		}
		else
		{
//			JOptionPane.showMessageDialog(this,  "Bienvenue !",
//			"Connexion réussie", JOptionPane.INFORMATION_MESSAGE);
			
			//Appel de la jframe générale
			Main.rendreVisible(false);
			new VueGenerale(droits);
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyChar() == KeyEvent.VK_ENTER)
		{
			traitement();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
