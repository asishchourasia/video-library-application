package ClassRelated;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;

public class UpdateCustomerDetails extends JFrame implements ActionListener
{
	
	private JLabel lblname,lblpassword,lblphone,lbladdress,lblgender,lbldob,lbldatereg,lblcity;
	private JTextField txtname,txtpassword,txtphone,txtaddress,txtgender,txtdob,txtdatereg,txtcity;
	private JButton btnedit;
	private ArrayList<Customer> list;
	private int id;
	Customer reg;
	
	public UpdateCustomerDetails(int id)
	{
		lblname=new JLabel("Customer Name");
		lblphone=new JLabel("Customer Phone No");
		lblpassword=new JLabel("Customer Password");
		lbladdress=new JLabel("Customer Address");
		lblgender=new JLabel("Customer Gender");
		lbldob=new JLabel("Customer DOB");
		lbldatereg=new JLabel("Customer date of reg.");
		lblcity=new JLabel("Customer City");
		
		txtname=new JTextField(10);
		txtphone=new JTextField(10);
		txtpassword=new JTextField(10);
		txtaddress=new JTextField(10);
		txtgender=new JTextField(10);
		txtdob=new JTextField(10);
		txtdatereg=new JTextField(10);
		txtcity=new JTextField(10);
		btnedit=new JButton("Edit");
		setLayout(new GridLayout(9,2,4,4));
		int f=0;
		try
		{
			
			list=FileReadWrite.readingFromCustomerDB();
			for(Customer r : list)
			{
				if(r.getUserid()==id)
				{
					reg=r;
					f=1;
					this.id=id;
					break;
				}
				
				
			}
			
		}
		catch(Exception e)
		{
		}
		
		if(f==1)
		{
			txtname.setText(reg.getName());
			txtpassword.setText(reg.getPassword());
			txtphone.setText(reg.getPhone());
			
			txtgender.setText(reg.getGender());
			txtdob.setText(reg.getDobirth());
			txtcity.setText(reg.getCity());
			txtdatereg.setText(reg.getDoreg());
			txtaddress.setText(reg.getAddress());
			
		add(lblname);
	    add(txtname);
	    add(lblpassword);
		add(txtpassword);
		add(lblphone);
		add(txtphone);

		add(lblgender);
		add(txtgender);
		add(lbldob);
		add(txtdob);
		add(lblcity);
		add(txtcity);
		add(lbldatereg);
		add(txtdatereg);
	    add(lbladdress);
		add(txtaddress);
	
		add(btnedit);
	//	txtid.setEditable(false);
		txtpassword.setEditable(false);
		txtgender.setEditable(false);
		txtdob.setEditable(false);
		txtdatereg.setEditable(false);
		txtcity.setEditable(false);
		
		setSize(600,300);
		setTitle("CustomerDetails");
		setVisible(true);
		setResizable(false);
		}
		else
			JOptionPane.showMessageDialog(this,"ID not found");
		btnedit.addActionListener(this);
		
	}	
	
	
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
	  if(ae.getSource()==btnedit)
	  {
		 changeFields();
	  }
	}
	private void changeFields() {
			String newname=txtname.getText();
			String newaddress=txtaddress.getText();
			String newphone=txtphone.getText();
			
			if(newname.equals("")||newaddress.equals("")||newphone.equals(""))
			  {
				if(ValidationChecking.isEmpty(newname))
			     {
					JOptionPane.showMessageDialog(this,"Please Enter Name");
					txtname.requestFocus();
					
			     }
			     else
			     {
			    	 if(ValidationChecking.isMobileNo(newphone)==false)
			    		{
			    			JOptionPane.showMessageDialog(this,"Mobile no must be 10 digit");
							txtphone.requestFocus();
			    		}
			    	else
			    	{
			    		
			    		if(ValidationChecking.isEmpty(newaddress))
						{
							JOptionPane.showMessageDialog(this,"Please Enter address");
							txtaddress.requestFocus();
							
						}
			    	}
			     }
			  }
			else
			{
			 try
			 {
				int size=list.size();
				for(int i=0;i<size;i++)
				{
					Customer customer=(Customer) list.get(i);
					
					if(customer.getUserid()==this.id)
					   {
							customer.setName(newname);
							
							customer.setAddress(newaddress);
							
							customer.setPhone(newphone);
							FileReadWrite.writingToCustomerDB(list);
							JOptionPane.showMessageDialog(this,"Changes made successfully !");
							break;
					   }
			}
			}
			
			catch(Exception e)
			{
			}
		}
	} 
}