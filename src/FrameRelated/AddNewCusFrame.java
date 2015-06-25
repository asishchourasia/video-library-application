package FrameRelated;
import ClassRelated.FileReadWrite;
import ClassRelated.ValidationChecking;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ClassRelated.Customer;
//import DatabaseOperation.FileReadWrite;
import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;

public class AddNewCusFrame extends JFrame implements ActionListener
{   
	private JComboBox combocity,combodobday,combodobmonth,combodobyear,comboregday,comboregmonth,comboregyear;
	private static String[] combocitylist={"Select City","Kolkata","Durgapur","Medinipur","Diamond Harbour","Bangalore","Chennai","Delhi","Mumbai"};
	
	private JRadioButton rbtnmale,rbtnfemale;
	private JLabel lblgender,lblcity,lbldate,lblname,lblid,lblpassword,lbladdress,lblDOB,lblphone;
	private ButtonGroup group;
	private JTextField txtname,txtid,txtpassword,txtaddress,txtphone;
	private JPanel panelcombo,panelradio,panelcity,panelbutton,paneldob; 
	private JButton btnregister,btnreset;
	private ArrayList<Customer> list;
	private int userid;
	public AddNewCusFrame()
	{
		//ValidationChecking ref=new ValidationChecking();
		list=new ArrayList<Customer>();
		//reading from file
		try
		{
		   list=FileReadWrite.readingFromCustomerDB();
		}
		catch(Exception e)
		{
			System.out.println("File Not Found");
		}
		if(list.size()==0)
			userid=1;
		else
			userid=list.get(list.size()-1).getUserid()+1;
		
		lblcity=new JLabel("City");
		lbldate=new JLabel("Date Of Registration");
		lblgender=new JLabel("Gender");
		lblDOB=new JLabel("Enter Date of birth");
		lblname=new JLabel("Enter your name");
		lblid=new JLabel("Enter id");
		lblpassword=new JLabel("Enter Password");
		lbladdress=new JLabel("Enter Address");
		lblphone=new JLabel("Enter Phone");
	
		btnregister=new JButton("REGISTER");
		
		
		
		btnreset=new JButton("RESET");
		
		rbtnmale= new JRadioButton("Male",true);
		rbtnfemale= new JRadioButton("Female",false);
		group = new ButtonGroup();
		group.add(rbtnmale);
		group.add(rbtnfemale);
		
		
		
		combocity=new JComboBox(combocitylist);
		
		
		
		String dobdatevalue[]=new String[32];
		String doregdatevalue[]=new String[32];
        dobdatevalue[0]="";	
        doregdatevalue[0]="";
		for(int i=1;i<=31;i++)
		{
			dobdatevalue[i]=String.valueOf(i);
			doregdatevalue[i]=String.valueOf(i);
		}
		combodobday=new JComboBox(dobdatevalue);
		comboregday=new JComboBox(doregdatevalue);
		String dobmonthvalue[]=new String[13];
		String doregmonthvalue[]=new String[13];
		dobmonthvalue[0]="";
		doregmonthvalue[0]="";
		for(int i=1;i<=12;i++)
		{
			dobmonthvalue[i]=String.valueOf(i);
			doregmonthvalue[i]=String.valueOf(i);
		}
		combodobmonth=new JComboBox(dobmonthvalue);
		comboregmonth=new JComboBox(doregmonthvalue);
		
		String dobyearvalue[]=new String[100];
		String doregyearvalue[]=new String[100];
		dobyearvalue[0]="";
		doregyearvalue[0]="";
		int cnt=1;
		for(int i=1970;i<=2020;i++)
		{
			dobyearvalue[cnt]=String.valueOf(i);
			doregyearvalue[cnt]=String.valueOf(i);
			cnt++;	
		}
		combodobyear=new JComboBox(dobyearvalue);
		comboregyear=new JComboBox(doregyearvalue);	
		
		
		panelcombo=new JPanel();
		panelradio=new JPanel();
		panelcity=new JPanel();
		paneldob=new JPanel();
		
		txtname=new JTextField(10);
		txtaddress=new JTextField(10);
		txtphone=new JTextField(10);
		txtid=new JTextField(10);
		txtpassword= new JTextField(10);
		txtid.setEditable(false);
		txtid.setText(""+userid);
	
		
		panelcombo.add(comboregday);
		panelcombo.add(comboregmonth);
		panelcombo.add(comboregyear);
		paneldob.add(combodobday);
		paneldob.add(combodobmonth);
		paneldob.add(combodobyear);
		
		panelradio.add(rbtnmale);
		panelradio.add(rbtnfemale);
		panelcity.add(combocity);

		setLayout(new GridLayout(10,2,4,4));
		add(lblid);
		add(txtid);
		add(lblname);
	    add(txtname);
	    
		add(lblpassword);
		add(txtpassword);
		add(lblphone);
		add(txtphone);
	    add(lblgender);
		add(panelradio);
		add(lblDOB);
		add(paneldob);
		add(lblcity);
		add(combocity);
		add(lbldate);		
		add(panelcombo);

		add(lbladdress);
	    add(txtaddress);
		add(btnregister);
		add(btnreset);
		setSize(350,600);
		setTitle("CUSTOMER ENTRY");
		setVisible(true);
		setLayout(null);
		setResizable(false);
		
		
		
		
		
		btnregister.addActionListener(this);
		btnreset.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==btnregister)
		{
			checkSpaces();
		}			
		if(event.getSource()==btnreset)
		{
			refreshAll();
		}
	}
	
	private void checkSpaces() 
	{
		//ValidationChecking ref=new ValidationChecking();
		String name=txtname.getText();
        String password=txtpassword.getText();
		String address=txtaddress.getText();
	    String phone=txtphone.getText();
		String city=(String) combocity.getSelectedItem();
		String d=(String)combodobday.getSelectedItem();
		String m=(String)combodobmonth.getSelectedItem();
		String y=(String)combodobyear.getSelectedItem();
		String da=(String)comboregday.getSelectedItem();
		String mo=(String)comboregmonth.getSelectedItem();
		String ye=(String)comboregyear.getSelectedItem();	
	if(name.equals("")||password.equals("")||address.equals("")||phone.equals("")||city.equals("")||d.equals("")||m.equals("")||y.equals("")||da.equals("")||mo.equals("")||ye.equals(""))
	  {
		if(ValidationChecking.isEmpty(name))
	     {
			JOptionPane.showMessageDialog(this,"Please Enter Name");
			txtname.requestFocus();
			
	     }
	     else
	     {
	    	if(ValidationChecking.isEmpty(password))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Password");
				txtpassword.requestFocus();
				
			}
	    	else
	    	{
	    		if(ValidationChecking.isMobileNo(phone)==false)
	    		{
	    			JOptionPane.showMessageDialog(this,"Mobile no must be 10 digit");
					txtphone.requestFocus();
	    		}
	    		else
	    		{
	    			if((d.equals(""))||(m.equals(""))||(y.equals("")))
	    			{
	    			     JOptionPane.showMessageDialog(this,"Enter date of birth");
					}
	    			else
	    			{
	    				
	    				if(city.equals("Select City"))
    					{
    						JOptionPane.showMessageDialog(this,"Please Enter city");
    			        
    					}
	    				else
	    				{
	    					if((da.equals(""))||(mo.equals(""))||(ye.equals("")))
    						{
    			        	JOptionPane.showMessageDialog(this,"Please Enter date registration");
    						}
	    					else
	    					{
	    						
	    						if(ValidationChecking.isEmpty(address))
			    				{
			    				
			    					JOptionPane.showMessageDialog(this,"Please Enter your address");
			    	    			txtaddress.requestFocus();
			    	    			
			    				}
	    					}
	    				}
	    			}
	    		}
	    	}
		}
	  }
		else
		{

				int con=JOptionPane.showConfirmDialog(this, "Are You Sure to Register?");
				addCustomer();
		}
				
		

		
	}
	private void addCustomer() {
		
		
		list.add(getCustomer());
		userid=Integer.parseInt(txtid.getText().trim())+1;
		txtid.setText(""+userid);
		try
		{   
			
		    FileReadWrite.writingToCustomerDB(list);
		   refreshAll();
		  			}
		catch(Exception exp)
		{
			MsgBox.signal(enumMsgBox.CANTWRITETODATA);//enum used
		}
	}
	public Customer getCustomer()
	{
		int userid=Integer.parseInt(txtid.getText());
		String name=txtname.getText();
		String address=txtaddress.getText();
		String phone=txtphone.getText();
		String password=txtpassword.getText();
		String city=(String) combocity.getSelectedItem();
		
		String d=(String)combodobday.getSelectedItem();
		String m=(String)combodobmonth.getSelectedItem();
		String y=(String)combodobyear.getSelectedItem();
		String dobirth=d + "-" + m + "-" + y;
		
		
		String da=(String)comboregday.getSelectedItem();
		String mo=(String)comboregmonth.getSelectedItem();
		String ye=(String)comboregyear.getSelectedItem();
		String doreg=da + "-" + mo + "-" + ye;
		
		String gender="";
		if(rbtnmale.isSelected())
		{
			gender="Male";
		}
		else if(rbtnfemale.isSelected())
		{
			gender="Female";
		}
		
		
	Customer customer=new Customer(userid,name,password,phone,
				 gender,dobirth,city,
				 doreg,address);
		return customer;
	}

	void refreshAll()
	{
		txtname.setText(" ");
	     txtpassword.setText(" ");
	    txtaddress.setText(" ");
	    txtphone.setText(" ");
	    
	}

	
}
