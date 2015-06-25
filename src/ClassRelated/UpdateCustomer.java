package ClassRelated;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;


public class UpdateCustomer extends JFrame implements ActionListener {
	 private JButton ok,clr;
	 private JLabel lblmsg,lblid;
	 private JTextField txtuserid;
	 
	
	
	public UpdateCustomer()
	{
		super("CustomerUpdate");
		
		
		ok=new JButton("ok");
		ok.addActionListener(this);
		clr=new JButton("Clear");
		clr.addActionListener(this);
		
		
		
		Font f1=new Font("TIMES NEW ROMAN",Font.PLAIN,18);
		lblmsg=new JLabel("Update Customer");
		lblmsg.setFont(f1);
		lblmsg.setForeground(Color.blue);
		lblid =new JLabel("Enter ID");
		lblid.setFont(f1);
		lblid.setForeground(Color.BLACK);
		
		
		txtuserid=new JTextField(20);
		
		
		
		
		setLayout(new GridLayout(3,2));
		
		add(lblmsg);
		add(new JLabel(""));
		add(lblid);
		add(txtuserid);
		
		add(ok);
		add(clr);
	
		setVisible(true);
		setSize(400,130);
		setLocation(200,300);
		setResizable(false);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	  if(ae.getSource()==ok)
	  {
		  
		       
		        
				if(txtuserid.getText().equals("") )
				{
					//JOptionPane.showMessageDialog(this,"Please Enter ID...");
					MsgBox.signal(enumMsgBox.PLEASEENTERID);//enum used
				}
				
				
				else
					{
					 int id=Integer.parseInt(txtuserid.getText().trim());
					new UpdateCustomerDetails(id);
					}
				setVisible(true);
				}
		  
	  else if(ae.getSource()==clr)
	  {
		  txtuserid.setText("");
		  txtuserid.setText("");
		  
	  }
	 
	} 
	public static void main(String[]args){
		new UpdateCustomer();
	}
}