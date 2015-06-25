package ClassRelated;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RulesAndRegulations extends JFrame
{

	public RulesAndRegulations(String title)
	{
		super(title);
		setLayout(new BorderLayout());
		ImageIcon ic=new ImageIcon("rules.jpg");
		JLabel imglbl=new JLabel(ic);
		add(imglbl,BorderLayout.CENTER);
		
		setSize(1200, 750);
	  //setLocation(200, 200);
		
		setVisible(true);
		
		
	}
	
}
