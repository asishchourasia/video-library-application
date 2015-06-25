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
import java.text.DateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ClassRelated.Customer;
import ClassRelated.FileReadWrite;
import ClassRelated.IssueMedia;
import ClassRelated.Media;
import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;

public class IssueMediaFrame extends JFrame implements ActionListener
{

	private JLabel lblcusid,lblmediaid,lbldateofissue,lbldateofreceive,lbltransid,lblpay;
	private JTextField txtcusid,txtmediaid,txtdateofissue,txtdateofreceive,txttransid,txtpay;
	private JButton btnok,btnclr;
	private JPanel panelcombo;
	Date date_ob=new Date();
	private ArrayList<IssueMedia>issuelist;
	private int copies,transid;
	private String status=null;
	private int pay=50;	
	
	 
 	private ArrayList<Media> medialist;
 	private ArrayList<Customer> customerlist;
	
	public IssueMediaFrame(){
		issuelist=new ArrayList<IssueMedia>();
		medialist=new ArrayList<Media>();
		customerlist=new ArrayList<Customer>();
		try
		{
			issuelist=FileReadWrite.readingFromIssueDB();
		}
		catch(Exception e)
		{
		}
		
		try
		{
			medialist=FileReadWrite.readingFromMediaDB();
		}
		catch(Exception e)
		{
		}
		
		try
		{
			customerlist=FileReadWrite.readingFromCustomerDB();
		}
		catch(Exception e)
		{
		}
		if(issuelist.size()==0)
			transid=1;
		else
			transid=issuelist.get(issuelist.size()-1).getTransid()+1;
		    
		 lblcusid=new JLabel("Customer ID");
		 lblmediaid=new JLabel("Media ID");
		 lbldateofissue=new JLabel("Date of Issue");
		 lbldateofreceive= new JLabel("Date of Return");
		 lbltransid=new JLabel("Transaction id");
		 lblpay=new JLabel("Pay");
		 
		 txtcusid=new JTextField(20);
		
		 txtmediaid=new JTextField(20);
		 
		txtdateofissue=new JTextField(20);
		txtdateofreceive=new JTextField(20);
		txttransid=new JTextField(20);
		txtpay=new JTextField(20);
		
		btnok=new JButton("OK");
		btnclr=new JButton("Clear");
	    
		
		DateFormat date=DateFormat.getDateInstance(DateFormat.SHORT);
		String value=date.format(date_ob);
		txtdateofissue.setText(value);

		String s1=value;
		String t[]=new String[3];
		{
		   t=s1.split("/");
		    int month=Integer.parseInt(t[0]);
		   int day=Integer.parseInt(t[1]);
		   int year=Integer.parseInt(t[2]);
		  if(month==4||month==6||month==9||month==11)
		  {
			  if(day>=1&&day<=28)
			  {
				  day=day+2;
			  }
			  if(day==29)
			  {
				  day=1;
				  month=month+1;
			  }
			  if(day==30)
			  {
				  day=2;
				  month=month+1;
			  }
		  }
		  else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
		  {
			  if(day>=1&&day<=29)
			  {
				  day=day+2;
			  }
			  if(day==30)
			  {
				  day=1;
				  month=month+1;
			  }
			  if(day==31)
			  {
				  day=2;
				  month=month+1;
			  }
		  }
		  else if(month==2)
		  {
			  if(day>=1&&day<=26)
			  {
				  day=day+2;
				  
			  }
			  if(day==27)
			  {
				  day=1;
				  month=month+1;
			  }
			  if(day==28)
			  {
				  day=2;
				  month=month+1;
			  }
		  }
		String value1=""+month+"/"+day+"/"+year;
		
		txtdateofreceive.setText(value1);
		}
		txtdateofreceive.setEditable(false);
		txttransid.setEditable(false);
        txttransid.setText(""+transid);
		txtpay.setText(""+pay);
		Font f1=new Font("TIMES NEW ROMAN",Font.PLAIN,16);
		lblcusid.setFont(f1);
		lblcusid.setForeground(Color.BLUE); 
		lblmediaid.setFont(f1);
		lblmediaid.setForeground(Color.BLUE);
		lbldateofissue.setFont(f1);
		lbldateofissue.setForeground(Color.BLUE);
		txtdateofissue.setEditable(false);

		lblpay.setFont(f1);
		lblpay.setForeground(Color.BLUE);
		txtpay.setEditable(false);
		lbldateofreceive.setFont(f1);
		lbldateofreceive.setForeground(Color.BLUE);
		txtdateofreceive.setEditable(false);
		txttransid.setForeground(Color.BLUE);
		lbltransid.setForeground(Color.BLUE);
		lbltransid.setFont(f1);
		setLayout(new GridLayout(7,2,4,4));
		
		add(lblcusid);
		add(txtcusid);
		add(lblmediaid);
		add(txtmediaid);
		add(lbldateofissue);
		add(txtdateofissue);

		add(lblpay);
		add(txtpay);
		add(lbldateofreceive);
		add(txtdateofreceive);
		add(lbltransid);
		add(txttransid);
		add(btnok);
		add(btnclr);
		setSize(350,200);
		setTitle("Issue Media");
		setVisible(true);
		setResizable(false);
		setLocation(500,400);
		
		
		btnok.addActionListener(this);
		btnclr.addActionListener(this);
		 
		 
	}

public void actionPerformed(ActionEvent ae)
	{
		
	if(ae.getSource()==btnok)
	{
		try
		{
		checkSpaces();	
		refreshAll();
		}
		catch(Exception e)
	    {
					
		}
	}	
	if(ae.getSource()==btnclr)
	{
		refreshAll();
	}
			
		
   }

 
private void checkSpaces() throws Exception 
{
	if(txtcusid.getText().equals("")||txtmediaid.getText().equals(""))
	{
		JOptionPane.showMessageDialog(this,"Please Enter All The Fields..");
	}
	else
	{
    addIssueDetails();
	}
	
}

private void addIssueDetails() throws Exception 
{

	int customerid=Integer.parseInt(txtcusid.getText().trim());
	int mediaid=Integer.parseInt(txtmediaid.getText().trim());
	String dateofissue=txtdateofissue.getText();
	String dateofreceive=txtdateofreceive.getText();

	
	int f=0;

	medialist=FileReadWrite.readingFromMediaDB();
	
	for(Media r : medialist)
	{
		if(r.getMediaid()==mediaid)
		{
			//JOptionPane.showMessageDialog(this,"found");
			
			if(r.getAvailablecopies()>0)
			{
			
			r.setAvailablecopies(r.getAvailablecopies()-1);
			
			
			f=1;
			
			break;
			}
			else
				JOptionPane.showMessageDialog(this,"No copies available");
			
		break;
		}
	}
	if(f==1)
   {   
		
    	IssueMedia R=new IssueMedia(customerid,mediaid,dateofissue,dateofreceive,transid,pay,status);
    	R.setStatus("Issued");
    	issuelist.add(R);
		FileReadWrite.writingToIssueDB(issuelist);
		try
		{
			
			FileReadWrite.writingToMediaDB(medialist);
			JOptionPane.showMessageDialog(this,"ISSUED !");
			
		}
		catch(Exception e)
		{
			
		}
		
		}	
	transid=Integer.parseInt(txttransid.getText().trim())+1;
	txttransid.setText(""+transid);
	
	}					
   
public IssueMedia getIssue()
{
		int customerid=Integer.parseInt(txtcusid.getText());
		int mediaid=Integer.parseInt(txtmediaid.getText());
		String dateofissue=txtdateofissue.getText();
		int transid=Integer.parseInt(txtmediaid.getText());
		int pay=Integer.parseInt(txtmediaid.getText());
		String dateofreceive=txtdateofreceive.getText();
		
		IssueMedia issuemedia = new IssueMedia(customerid,mediaid,dateofissue,dateofreceive,transid,pay,status);
		return issuemedia;
}
			




void refreshAll()
  {
	  txtcusid.setText(" ");
	     txtmediaid.setText(" ");
  }
				
			
			
}


	
	
	
	

