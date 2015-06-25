package FrameRelated;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import ClassRelated.ReceiveMedia;

public class ReceiveMediaFrame extends JFrame implements ActionListener
{
	private JLabel lblcusid,lblmediaid,lbldateofissue,lblfine;
	private JTextField txtcusid,txtmediaid,txtdateofreceive,txtfine;
	private JButton btnok,btnclr,btngenerate;
	private JPanel panelfinegenerate;
	Date date_ob=new Date();
	private ArrayList<IssueMedia>issuelist;
	private int copies,count=0;
	private String expecteddateofreceive;
	private ArrayList<ReceiveMedia>receivelist;
	public int fine,expectedmonth,expectedday,expectedyear,actualmonth,actualday,actualyear,daydiff; 
 	private ArrayList<Media> medialist;
 	private ArrayList<Customer> customerlist;
 	Media regmedia;
 	IssueMedia regissue;
 	
	
	
	public ReceiveMediaFrame(){
		issuelist=new ArrayList<IssueMedia>();
		medialist=new ArrayList<Media>();
		customerlist=new ArrayList<Customer>();
		receivelist=new ArrayList<ReceiveMedia>();
		try{
			receivelist=FileReadWrite.readingFromReceiveDB();
		}
		catch(Exception e)
		{
			
		}
		 lblcusid=new JLabel("Customer ID");
		 lblmediaid=new JLabel("Media Code");
		 lbldateofissue=new JLabel("Date of Receive");
		 lblfine=new JLabel("Fine to be paid");
		 txtcusid=new JTextField(10);
		txtmediaid=new JTextField(10);
		txtdateofreceive=new JTextField(10);
		txtfine=new JTextField(10);
		panelfinegenerate=new JPanel();
		btnok=new JButton("OK");
		btnclr=new JButton("Clear");
		btngenerate=new JButton("Generate");
		DateFormat date=DateFormat.getDateInstance(DateFormat.SHORT);
		String value=date.format(date_ob);
		txtdateofreceive.setText(value);
		
		
		Font f1=new Font("Stensil",Font.BOLD,16);
		lblcusid.setFont(f1);
		lblcusid.setForeground(Color.BLUE); 
		lblmediaid.setFont(f1);
		lblmediaid.setForeground(Color.BLUE);
		lbldateofissue.setFont(f1);
		lbldateofissue.setForeground(Color.BLUE);
		lblfine.setFont(f1);
		lblfine.setForeground(Color.BLUE);
		lbldateofissue.setFont(f1);
		txtdateofreceive.setEditable(false);
		txtfine.setEditable(false);
		panelfinegenerate.add(txtfine);
		panelfinegenerate.add(btngenerate);
		setLayout(new GridLayout(5,2,8,8));
		
		add(lblcusid);
		add(txtcusid);
		add(lblmediaid);
		add(txtmediaid);
		add(lbldateofissue);
		add(txtdateofreceive);
		add(lblfine);
		//add(txtfine);
		
		add(panelfinegenerate);
		add(btnok);
		add(btnclr);
		setSize(350,400);
		setTitle("Receive Media");
		setVisible(true);
		//setResizable(false);
		setLocation(500,100);
		btnok.addActionListener(this);
		btnclr.addActionListener(this);
		btngenerate.addActionListener(this);
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
	if(ae.getSource()==btngenerate)
	{
		if(txtcusid.getText().equals("")||txtmediaid.getText().equals(""))
		{
			JOptionPane.showMessageDialog(this,"Please Enter All The Fields..");
		}
		else
		{
		getfineGeneration();
		}
	}
			
		
}

	private void getfineGeneration() {
		try {
			int customerid=Integer.parseInt(txtcusid.getText().trim());
			int mediaid=Integer.parseInt(txtmediaid.getText().trim());
			String date=txtdateofreceive.getText();
	       
			

			int f=0;

			issuelist=FileReadWrite.readingFromIssueDB();
			
			for(IssueMedia r : issuelist)
			{
				if(r.getMediaid()==mediaid&& r.getCustomerid()==customerid&& r.getStatus().equals("Issued"))
				{	
					
					f=1;
				    expecteddateofreceive=r.getDateofreceive();
				    break;
				}
			}
			if(f==1)
			{
				fineGeneration(expecteddateofreceive);
			  	
			}
		  	
			} 
		catch (Exception e) 
		{
			
		}

		
	}


	private int fineGeneration(String expecteddateofreceive) throws Exception 
	{
		
		String actualdateofreceive=txtdateofreceive.getText();
	    String initialdateofreceive=expecteddateofreceive;   	
	    String t[]=new String[3];
		{
		   t=actualdateofreceive.split("/");
		     actualmonth=Integer.parseInt(t[0]);
		     actualday=Integer.parseInt(t[1]);
		     actualyear=Integer.parseInt(t[2]);
		}
		
		
		String t1[]=new String[3];
		{
		   t1=initialdateofreceive.split("/");
		     expectedmonth=Integer.parseInt(t1[0]);
		     expectedday=Integer.parseInt(t1[1]);
		     expectedyear=Integer.parseInt(t1[2]);
				
		}
		if(actualmonth==expectedmonth)
		{
			daydiff=actualday-expectedday;
		}
		if(actualmonth>expectedmonth)
		{
			if(expectedmonth==4||expectedmonth==6||expectedmonth==9||expectedmonth==11)
			  {
				daydiff=(30-expectedday)+actualday;
			  }
			if(expectedmonth==1||expectedmonth==3||expectedmonth==5||expectedmonth==7||expectedmonth==8||expectedmonth==10||expectedmonth==12)
			{
				daydiff=(31-expectedday)+actualday;
			}
			if(expectedmonth==2)
			{
				daydiff=(28-expectedday)+actualday;
					
			}
	    }
	fine=daydiff*10;
	txtfine.setText(""+fine);
  	
	System.out.print(fine);
    return fine;    
	}
	private void refreshAll() {
		txtcusid.setText(" ");
	     txtmediaid.setText(" ");
	}
	


	private void checkSpaces() throws Exception {
		addReceiveDetails();
		
	}
	
		  
	
	
	private void addReceiveDetails() throws Exception {

		int customerid=Integer.parseInt(txtcusid.getText().trim());
		int mediaid=Integer.parseInt(txtmediaid.getText().trim());
		String date=txtdateofreceive.getText();
		int fine=Integer.parseInt(txtfine.getText().trim());
		int f=0;

		issuelist=FileReadWrite.readingFromIssueDB();
		
		for(IssueMedia r : issuelist)
		{
			if(r.getMediaid()==mediaid&& r.getCustomerid()==customerid&& r.getStatus().equals("Issued"))
			{	
				
				f=1;
			    r.setStatus("Received");
				expecteddateofreceive=r.getDateofreceive();
			    break;
			}
			else
				 count++;
			
		}
		if(count==issuelist.size())
			JOptionPane.showMessageDialog(this,"You have'nt issue it");
		
		if(f==1)
		{   
			
			medialist=FileReadWrite.readingFromMediaDB();
			
			for(Media m : medialist)
			{
				if(m.getMediaid()==mediaid)
				{
					
					if(m.getAvailablecopies()<3)
					{
					
						m.setAvailablecopies(m.getAvailablecopies()+1);
					    f=2;
					    break;
					}
			
					else
						JOptionPane.showMessageDialog(this,"You have'nt issue it");
			
					break;
				
				}			
			}
	   }
			if(f==2)
			{
				fineGeneration(expecteddateofreceive);
				ReceiveMedia R=new ReceiveMedia(customerid,mediaid,date,fine);
				receivelist.add(R);
				
				//issuelist.remove(issuelist.indexOf(regissue));
			    
				FileReadWrite.writingToReceiveDB(receivelist);
				try
				{
					FileReadWrite.writingToMediaDB(medialist);
				    FileReadWrite.writingToIssueDB(issuelist);
					
					JOptionPane.showMessageDialog(this,"DEPOSITED");
					
				}
				catch(Exception e)
				{
					
				}
			}
	
	   }
	public ReceiveMedia getReceive()
	{
		int customerid=Integer.parseInt(txtcusid.getText());
		int mediaid=Integer.parseInt(txtmediaid.getText());
		String dateofreceive=txtdateofreceive.getText();
		int fine=Integer.parseInt(txtfine.getText());
		ReceiveMedia receivemedia = new ReceiveMedia(customerid,mediaid,dateofreceive,fine);
		return receivemedia;
	}	
}

	
	
	
