package FrameRelated;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ClassRelated.ContactUs;
import ClassRelated.RulesAndRegulations;

public class StartFrame extends JFrame implements ActionListener
{
	private JMenuBar menubar;
	private JMenu menuadmin,menucustomer,menuabtproject;
	private JMenuItem adminlogin,adminexit,cuslogin,cusexit,rules,contactus,aboutus;
	
	public StartFrame()
	{
		setLayout(new FlowLayout());
		menubar= new JMenuBar();
		menuadmin= new JMenu("Administrator");
		menucustomer= new JMenu("Customer");
		menuabtproject= new JMenu("About System");
		
		
		adminlogin=new JMenuItem("Login");
		adminexit=new JMenuItem("Exit");
		cuslogin=new JMenuItem("Login");
		cusexit=new JMenuItem("Exit");
		rules=new JMenuItem("Rules And Regulations");
		contactus=new JMenuItem("Contact Us");
		aboutus=new JMenuItem("About Us");
		
		
		menuadmin.add(adminlogin);
		menuadmin.add(adminexit);
		menucustomer.add(cuslogin);
		menucustomer.add(cusexit);
		menuabtproject.add(rules);
		menuabtproject.add(contactus);
		menuabtproject.add(aboutus);
		
		menubar.add(menuadmin);
		menubar.add(menucustomer);
		menubar.add(menuabtproject);
		
		
		add(menubar);
		add(menubar,BorderLayout.NORTH);
		
		ImageIcon ic=new ImageIcon("start.jpg");
		JLabel imglbl=new JLabel(ic);
		add(imglbl,BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1360, 720);
		setTitle("WELCOME TO VIDEO LIBRARY");
		setJMenuBar(menubar);
		setVisible(true);
		
		
		adminlogin.addActionListener(this);
		adminexit.addActionListener(this);
		cuslogin.addActionListener(this);
		cusexit.addActionListener(this);
		rules.addActionListener(this);
		contactus.addActionListener(this);
		aboutus.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==adminlogin)
		{
			try {
				new AdminPasswordFrame();
			} catch (Exception e) {
				
			//	e.printStackTrace();
			}
			
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
		 if(event.getSource()==rules)
			{
			 new RulesAndRegulations("RULES AND REGULATIONS");
			}
		 if(event.getSource()==contactus)
			{
			 new ContactUs("CONTACT US");
			}
		 if(event.getSource()==aboutus)
			{
			
			 JOptionPane.showMessageDialog(this,"VIDEO LIBRARY MANAGEMENT SYSTEM PROJECT.....\nSUBMITTED BY--\n1.HARSH KUMAR\n2.ASISH KUMAR CHOURASIA\n3.IMRAN KHAN\n4.ASHISH KUMAR GUPTA\n5.POULOMI SAHA");
			 		 
			 		
			}
	}
	
	public static void main(String[] args) {
		new StartFrame();

	}

}
