package FrameRelated;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MemberLoginFrame extends JFrame implements ActionListener
{
	private JMenuBar menubar;
	private JMenu menucustomer;
	private JMenuItem searchmedia, viewaccount,changepassword;
	public MemberLoginFrame()
	{
		setLayout(new FlowLayout());
		menubar= new JMenuBar();
		
		menucustomer= new JMenu("Customer Applications");
		searchmedia= new JMenuItem("Search Media");
		viewaccount= new JMenuItem("View Account");
		changepassword= new JMenuItem("Change your password");
		menucustomer.add(searchmedia);
		menucustomer.add(viewaccount);
		menucustomer.add(changepassword);
		menubar.add(menucustomer);
		
		
		add(menubar);
		searchmedia.addActionListener(this);
		viewaccount.addActionListener(this);
		changepassword.addActionListener(this);
		
		ImageIcon ic=new ImageIcon("videolibrary.jpg");
		JLabel imglbl=new JLabel(ic);
		add(imglbl,BorderLayout.CENTER);
		add(menubar,BorderLayout.NORTH);
		setSize(1200, 720);
		setTitle("MEMBER WINDOW");
				
		setJMenuBar(menubar);
		setVisible(true);
		
		
		
	}
	 public void actionPerformed(ActionEvent ae)
	    {

		 if(ae.getSource()==changepassword)
			 new ChangeMemberPasswordFrame();
		
		 if(ae.getSource()==searchmedia)
				new MediaSearchFrame();	
		 
		 if(ae.getSource()==viewaccount)
			new ViewMemberFrame();
	    }
    
	

}
