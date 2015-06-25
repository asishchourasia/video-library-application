package FrameRelated;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ClassRelated.DeleteCustomerDetails;
import ClassRelated.ViewMemberDetails;
import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;

public class ViewMemberFrame extends JFrame implements ActionListener 
{
	 private JButton btnok,btnclr;
	 private JLabel lblmsg,lbluserid;
	 private JTextField txtuserid;
	 
	
	
	public ViewMemberFrame()
	{
		super("CustomerDisplay");
		
		
		btnok=new JButton("Ok");
		btnok.addActionListener(this);
		btnclr=new JButton("Clear");
		btnclr.addActionListener(this);
		
		
		
		Font f1=new Font("TIMES NEW ROMAN",Font.PLAIN,18);
		lblmsg=new JLabel("View Member");
		lblmsg.setFont(f1);
		lblmsg.setForeground(Color.blue);
		lbluserid =new JLabel("Enter ID");
		lbluserid.setFont(f1);
		lbluserid.setForeground(Color.BLACK);
		
		
		txtuserid=new JTextField(20);
		
		
		
		
		setLayout(new GridLayout(3,2));
		
		add(lblmsg);
		add(new JLabel(""));
		add(lbluserid);
		add(txtuserid);
		
		add(btnok);
		add(btnclr);
	
		setVisible(true);
		setSize(400,130);
		setLocation(200,300);
		setResizable(false);
		
		
		
	}



	public void actionPerformed(ActionEvent ae)
	{
	  if(ae.getSource()==btnok)
	  {
		  
		        
		        
				if(txtuserid.getText().equals("") )
				{
					//JOptionPane.showMessageDialog(this,"Please Enter ID...");
					MsgBox.signal(enumMsgBox.PLEASEENTERID);//enum used
				}
				
				
				else
					{
					int id=Integer.parseInt(txtuserid.getText().trim());
					new ViewMemberDetails(id);
					}
				setVisible(true);
				}
		  
	  else if(ae.getSource()==btnclr)
	  {
		  txtuserid.setText("");
		  txtuserid.setText("");
		  
	  }
	
}
}
