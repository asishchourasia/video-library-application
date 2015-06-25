package FrameRelated;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class StartFrame1 extends JFrame implements ActionListener
{
	private JMenuBar menubar;
	private JMenu menuadmin,menucustomer,menucontact,menuruls,menuabtus;
	private JMenuItem adminlogin,adminexit,cuslogin,cusexit;
	
	public StartFrame1()
	{
		setLayout(new FlowLayout());
		menubar= new JMenuBar();
		menuadmin= new JMenu("Administrator");
		menucustomer= new JMenu("Customer");
		menucontact= new JMenu("Contact Us");
		menuruls= new JMenu("Rules And Regulation");
		menuabtus= new JMenu("About Us");
		
		
		adminlogin=new JMenuItem("Login");
		adminexit=new JMenuItem("Exit");
		cuslogin=new JMenuItem("Login");
		cusexit=new JMenuItem("Exit");
		
		
		menuadmin.add(adminlogin);
		menuadmin.add(adminexit);
		menucustomer.add(cuslogin);
		menucustomer.add(cusexit);
		
		menubar.add(menuadmin);
		menubar.add(menucustomer);
		menubar.add(menucontact);
		menubar.add(menuruls);
		menubar.add(menuabtus);
		
		add(menubar);
		
		
		add(menubar,BorderLayout.NORTH);
		setSize(1360, 720);
		setTitle("WELCOME TO VIDEO LIBRARY");
		
		setJMenuBar(menubar);
		setVisible(true);
		
		
		adminlogin.addActionListener(this);
		adminexit.addActionListener(this);
		cuslogin.addActionListener(this);
		cusexit.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==adminlogin)
		{
			new AdminPasswordFrame();
			
		}
		
		if(event.getSource()==adminexit)
		{
			System.exit(0);
		}
		 if(event.getSource()==cuslogin)
		{
			new MemberPasswordFrame();
		}
		 if(event.getSource()==cusexit)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new StartFrame1();

	}

}
