package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class VueInter extends JPanel implements ActionListener {

	public VueInter()
	{
		this.setBounds(20, 70, 660, 400);
		this.setLayout(null);
		this.setBackground(Color.cyan);
		
		this.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
