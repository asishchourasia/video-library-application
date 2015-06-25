package FrameRelated;

import java.awt.Color;
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
import javax.swing.JTextField;

import ClassRelated.Customer;
import ClassRelated.FileReadWrite;

public class ChangeMemberPasswordFrame extends JFrame implements ActionListener {
	
	private JLabel lbloldpass,lblnewpass;
	private JTextField txtoldpass,txtnewpass;
	private JButton btnconfirm,btnclear;
	ArrayList<Customer>list;
	public ChangeMemberPasswordFrame()
	{
		try
		{
		   list=FileReadWrite.readingFromCustomerDB();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"File not found");
			
		}
		lbloldpass=new JLabel("Old Password");
		lblnewpass=new JLabel("New Password");
		txtoldpass=new JTextField(10);
	    txtnewpass=new JTextField(10);
		
		
		btnconfirm=new JButton("Confirm");
		btnclear=new JButton("Clear");
		Font f1=new Font("TIMES NEW ROMAN",Font.BOLD,16); 
		lbloldpass.setFont(f1);
		lbloldpass.setForeground(Color.BLUE);
		lblnewpass.setFont(f1);
		lblnewpass.setForeground(Color.BLUE);
		setLayout(new GridLayout(3,2,8,8));
		
		add(lbloldpass);
		add(txtoldpass);
		add(lblnewpass);
		add(txtnewpass);
		add(btnconfirm);
		add(btnclear);
		setSize(400,200);
		setTitle("CHANGE PASSWORD");
		setVisible(true);
		setResizable(false);
		
		btnconfirm.addActionListener(this);
		btnclear.addActionListener(this);
		
		
		
	}

	Customer r;
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnconfirm)
		{
			
			changePassword();
			refreshAll();

		}
		if(ae.getSource()==btnclear)
		{
			refreshAll();
		}
	}
	private void refreshAll() 
	{
		txtoldpass.setText("");
		txtnewpass.setText("");
	
	}
	private void changePassword() 
	{
		String oldpassword=txtoldpass.getText();
		String newpassword=txtnewpass.getText();
		try
		{
			list=FileReadWrite.readingFromCustomerDB();
			int size=list.size();
			for(int i=0;i<size;i++)
			{
				Customer customer=(Customer) list.get(i);
				String filepassword=customer.getPassword();
			
				if(oldpassword.equals(filepassword))
				   {
					
						String password=newpassword;
						customer.setPassword(newpassword);
						
						FileReadWrite.writingToCustomerDB(list);
						JOptionPane.showMessageDialog(this,"Password Changed successfully !");
						break;
					}

			}	
				
				}
			
		
		catch(Exception e)
		{
			System.out.println("error" +e);
		}
		
		
		
		
		
		
		
	}
}