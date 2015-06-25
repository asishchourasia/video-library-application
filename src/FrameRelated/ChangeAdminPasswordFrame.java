package FrameRelated;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ClassRelated.Admin;
import ClassRelated.Customer;
import ClassRelated.FileReadWrite;

public class ChangeAdminPasswordFrame extends JFrame implements ActionListener
{

	private JLabel lbloldpass,lblnewpass,lbloldid,lblnewid;
	private JTextField txtoldpass,txtnewpass,txtoldid,txtnewid;
	private JButton btnconfirm,btnclear;
	ArrayList<Admin>list;
	private String filepassword,fileid;
	
	public ChangeAdminPasswordFrame()
	{
		try
		{
		   list=FileReadWrite.readingFromAdminDB();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"File not found");
			
		}
		lbloldpass=new JLabel("Enter Old Password");
		lblnewpass=new JLabel("Enter New Password");
		lbloldid=new JLabel("Enter Old ID");
		lblnewid=new JLabel("Enter New ID");
		
		txtoldpass=new JTextField(10);
	    txtnewpass=new JTextField(10);
	    txtoldid=new JTextField(10);
	    txtnewid=new JTextField(10);
		
		
		btnconfirm=new JButton("Confirm");
		btnclear=new JButton("Clear");
		Font f1=new Font("TIMES NEW ROMAN",Font.BOLD,16); 
		lbloldpass.setFont(f1);
		lbloldpass.setForeground(Color.BLUE);
		lblnewpass.setFont(f1);
		lblnewpass.setForeground(Color.BLUE);
		lbloldid.setFont(f1);
		lbloldid.setForeground(Color.BLUE);
		lblnewid.setFont(f1);
		lblnewid.setForeground(Color.BLUE);
		setLayout(new GridLayout(5,2,8,8));
		
		
		add(lbloldid);
		add(txtoldid);
		add(lblnewid);
		add(txtnewid);
		add(lbloldpass);
		add(txtoldpass);
		add(lblnewpass);
		add(txtnewpass);
		add(btnconfirm);
		add(btnclear);
		setSize(400,200);
		setTitle("CHANGE ADMIN ID & PASSWORD");
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
		txtoldid.setText("");
		txtnewid.setText("");
	
	}
	private void changePassword() 
	{
		String oldpassword=txtoldpass.getText();
		String newpassword=txtnewpass.getText();
		String oldid=txtoldid.getText();
		String newid=txtnewid.getText();
		try
		{
			list=FileReadWrite.readingFromAdminDB();
			
			
		
			/*for(int i=0;i<size;i++)
			{*/
			    Admin admin=(Admin) list.get(0);
				filepassword=admin.getAdminpassword();
				fileid=admin.getAdminid();
				System.out.print(filepassword);
				System.out.print(fileid);
				
				if(oldpassword.equals("")||newpassword.equals("")||oldid.equals("")||  newid.equals(""))
					JOptionPane.showMessageDialog(this,"Please Enter All Fields");
				else if(txtoldpass.getText().equals(filepassword)&& txtoldid.getText().equals(fileid))
				   {
					
						//String password=newpassword;
						//String id=newid;
				         
				        
						admin.setAdminid(newid);
				         admin.setAdminpassword(newpassword);
						list.add(admin);
						
						FileReadWrite.writingToAdminDB(list);
						JOptionPane.showMessageDialog(this,"ID & Password Changed successfully !");
						
					}
               
			//}	
				
				}
			
		
		catch(Exception e)
		{
			System.out.println("error" +e);
		}
		
		
		
		
		
		
		
	}
}
