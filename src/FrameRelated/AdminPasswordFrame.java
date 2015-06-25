package FrameRelated;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;
import ClassRelated.Admin;
import ClassRelated.FileReadWrite;
import ClassRelated.IssueMedia;
import ClassRelated.Login;
import ClassRelated.Customer;
import ClassRelated.SetAdminPassword;
import EnumRelated.MsgBox;
import FrameRelated.AdminLoginFrame;

public class AdminPasswordFrame extends JFrame implements ActionListener{
	

  private JButton ok,clear;
  private JLabel lmsg,lid,lpass,a,b;
  private JTextField tid;
  private JPasswordField tpass;
  private String adminid,adminpassword;
  //Admin r;

	//ArrayList<Login> list1;
	ArrayList<Admin> list;


   public AdminPasswordFrame() throws Exception
     {
	super("ADMINISTRATOR LOGIN");
	//list1=new ArrayList<Login>();
	
	//SetAdminPassword ref=new SetAdminPassword();
	list=new ArrayList<Admin>();
	
	
	
	try
	{
	   list=FileReadWrite.readingFromAdminDB();
	}
	catch(Exception e)
	{
	 
		
	}
	
	
	setSize(450,200);
	setLocation(300,300);
	setResizable(false);
	
	ok=new JButton("OK");
	clear=new JButton("clear");
	
	
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
	
	setLayout(new GridLayout(6,2));
	
	add(lmsg);add(new JLabel(""));
	add(lid);add(tid);
	add(a);add(new JLabel(" "));
	add(lpass);add(tpass);
	add(b);add(new JLabel(" "));
	add(ok);add(clear);

	
	
	setVisible(true);
	
	
	ok.addActionListener(this);
	clear.addActionListener(this);
	
	
}



public void actionPerformed(ActionEvent ae)
{
 if(ae.getSource()==ok)
 {      
	 
	    String id=tid.getText();
		String pass=tpass.getText();
		
		
		try {
			list=FileReadWrite.readingFromAdminDB();
		} catch (Exception e1) {
			
			//e1.printStackTrace();
		}
		
		for(Admin r : list)
		{
	    
		adminid=r.getAdminid();
		adminpassword=r.getAdminpassword();
		
		}
		

		try
		{
			if(id.equals("")&&pass.equals(""))
				MsgBox.signal(enumMsgBox.ENTERREQUIREDFIELDS);//enum used
			else
			{

		     
			if( id.equals(adminid) && pass.equals(adminpassword))
			  {
			    MsgBox.signal(enumMsgBox.LOGINSUCCESSFULL);//enum used
				new AdminLoginFrame();
				setVisible(false);
			  }
		
			  else
			  {
				MsgBox.signal(enumMsgBox.INVALIDLOGIN);//enum used
			  }
			}
		 }
		catch(Exception e)
		{
			System.out.println("Error : "+e);
		}
		
 }	
 
		
		  
		
		  else if(ae.getSource()==clear)
		  {
			  tid.setText("");
			  tpass.setText("");
			  
		  }
		
		 
}


}

