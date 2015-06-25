package FrameRelated;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import javax.swing.*;

import ClassRelated.FileReadWrite;
import ClassRelated.Login;
import ClassRelated.Customer;
import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;



public class MemberPasswordFrame extends JFrame implements ActionListener {
	 private JButton ok,clear;
	 private JLabel lmsg,lid,lpass,a,b;
	 private JTextField tid;
	 private JPasswordField tpass;
	 ArrayList<Customer> customerlist;
	 ArrayList<Login> loginlist;
	 
	 Customer regcustomer;
	
	
	public MemberPasswordFrame()
	{
		super("MEMBER LOGIN");
		
		customerlist=new ArrayList<Customer>();
		loginlist=new ArrayList<Login>();
		
		
		setSize(450,200);
		setLocation(300,300);
		setResizable(false);
		
		ok=new JButton("ok");
		ok.addActionListener(this);
		
		clear=new JButton("clear");
		clear.addActionListener(this);
		
		Font f=new Font("TIMES NEW ROMAN",Font.PLAIN,18);
		lmsg=new JLabel("Enter Login Details");
		lmsg.setFont(f);
	    lmsg.setForeground(Color.blue);
	    
		Font f1=new Font("TIMES NEW ROMAN",Font.PLAIN,18);
		lid =new JLabel("USER ID");
		lid.setFont(f1);
		lid.setForeground(Color.BLACK);
		a=new JLabel(" ");
		lpass=new JLabel("PASSWORD");
		lpass.setFont(f1);
		lpass.setForeground(Color.BLACK);
		b=new JLabel(" ");
		tid=new JTextField(20);
		tpass=new JPasswordField(20);
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(6,2));
		
		c.add(lmsg);
		c.add(new JLabel(""));
		c.add(lid);
		c.add(tid);
		c.add(a);
		c.add(new JLabel(" "));
		c.add(lpass);
		c.add(tpass);
		c.add(b);
		c.add(new JLabel(" "));
		c.add(ok);
		c.add(clear);
	
		
		
		setVisible(true);
		
		
	}
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
	  if(ae.getSource()==ok)
	  {
		getPasswordOperation(); 
		  refreshAll();
	  }
	  
	
	
	
	  
	
	  else if(ae.getSource()==clear)
	  {
		  refreshAll();
	  }
}



	private void refreshAll() {
		  tid.setText("");
		  tpass.setText("");
	
		
	}



	public void getPasswordOperation() 
	{
		
		  if(tid.getText().equals("")||tpass.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter All The Required Fields...");
			}
	else
	{
		int id=Integer.parseInt(tid.getText().trim());
		String pass=tpass.getText();
		try
		{
			try
			{
				loginlist=FileReadWrite.readingFromRegilogin();
			}
			catch(Exception e)
			{
				loginlist=new ArrayList<Login>();
			}
			
			Login r=new Login(id,pass);
			
			loginlist.add(r);
			FileReadWrite.writingToRegilogin(loginlist);
			
			
			
			
		}
		
		catch(Exception e)
		{
					//System.out.println("Error : "+e);
		}
				
		int f=0;
		
			try
			{
				
				customerlist=FileReadWrite.readingFromCustomerDB();
				for(Customer r : customerlist)
				{
					if(r.getUserid()==id && r.getPassword().equals(pass))
						{
						 
						 regcustomer=r;
						 f=1; 
						  
						   
						   break;
						}
						
					
				}
			}
				
			catch(Exception e)
			{
				
			}
				
		if(f==1)
			{
				try
				{
					
					JOptionPane.showMessageDialog(this, "Login Successfull....");
					new MemberLoginFrame();
						
				}
				catch(Exception e)
				{
						e.printStackTrace();
				}
					setVisible(false);
			
			}			

		 
			
		
		else
			{
				JOptionPane.showMessageDialog(this,"Invalid Login Details...");
			}
}
	}
}




