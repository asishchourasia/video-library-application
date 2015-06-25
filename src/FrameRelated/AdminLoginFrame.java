package FrameRelated;

//import gui.UIBoxStudentEntry;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import ClassRelated.DeleteCustomer;
import ClassRelated.DeleteCustomerDetails;
import ClassRelated.DeleteMedia;
import ClassRelated.UpdateCustomer;
import ClassRelated.ViewIssueMediaDetails;
import ClassRelated.ViewReceiveMediaDetails;

public class AdminLoginFrame extends JFrame implements ActionListener
{
    private JMenuBar menubar;
	private JMenu menucustomer,menumanagemedia,menuissue,menurecieve,menuadminpass;
	private JMenuItem addcus,remcus,viewcus,updatecus,changeid,issuemediadetails,recievemedia,recievemediadetails,addmedia,remmedia,issuemedia,viewmedia;
    public AdminLoginFrame()
	{
		
        setLayout(new FlowLayout());
		menubar= new JMenuBar();
		
		menucustomer= new JMenu("Customer");
		menumanagemedia= new JMenu("Manage Media");
		menuissue= new JMenu("Issue Media");
		menurecieve= new JMenu("Recieve Media");
		menuadminpass=new JMenu("Change Admin Details");
		addcus= new JMenuItem("Add New Customer");
		remcus= new JMenuItem("Remove Customer");
		viewcus= new JMenuItem("View All Customer");
		changeid= new JMenuItem("Change Admin ID & PASSWORD");
		
		
		
		
		updatecus= new JMenuItem("Update Customer Information");
		addmedia= new JMenuItem("Add Media");
		remmedia= new JMenuItem("Remove Media");
		viewmedia= new JMenuItem("View Available Media");
		issuemedia= new JMenuItem("Issue Media");
		issuemediadetails= new JMenuItem("Issue Media Details");
		recievemedia= new JMenuItem("Recieve Media");
		recievemediadetails= new JMenuItem("Recieve Media Details");
		
		menucustomer.add(addcus);
		menucustomer.add(remcus);
		menucustomer.add(viewcus);
		menucustomer.add(updatecus);
		
		
		menumanagemedia.add(addmedia);
		menumanagemedia.add(remmedia);
		menumanagemedia.add(viewmedia);
		menuadminpass.add(changeid);
		menuissue.add(issuemedia);
		menuissue.add(issuemediadetails);
		menurecieve.add(recievemedia);
		menurecieve.add(recievemediadetails);
		
		menubar.add(menucustomer);
		menubar.add(menumanagemedia);
		
		menubar.add(menuissue);
		menubar.add(menurecieve);
		menubar.add(menuadminpass);
		
		
		add(menubar);
		ImageIcon ic=new ImageIcon("videolibrary.jpg");
		JLabel imglbl=new JLabel(ic);
		add(imglbl,BorderLayout.CENTER);
			
				
		add(menubar,BorderLayout.NORTH);
		setSize(1360, 720);
		setTitle("ADMINISTRATOR PAGE");
		setJMenuBar(menubar);
		setVisible(true);
		
		addcus.addActionListener(this);
		viewcus.addActionListener(this);
		remcus.addActionListener(this);
		addmedia.addActionListener(this);
		viewmedia.addActionListener(this);
		remmedia.addActionListener(this);
		issuemedia.addActionListener(this);
		recievemedia.addActionListener(this);
		issuemediadetails.addActionListener(this);
		recievemediadetails.addActionListener(this);
		updatecus.addActionListener(this);
		changeid.addActionListener(this);
		
	}
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==viewcus)
		new DisplayAllCustomer();
		
    	if(ae.getSource()==addcus)
			new AddNewCusFrame();
    	if(ae.getSource()==remcus)
			new DeleteCustomer();
    	if(ae.getSource()==addmedia)
			new AddMediaFrame();
    	if(ae.getSource()==viewmedia)
			new DisplayAllMedia();
    	if(ae.getSource()==remmedia)
			new DeleteMedia();
    	if(ae.getSource()==issuemedia)
			new IssueMediaFrame();
    	if(ae.getSource()==recievemedia)
			new ReceiveMediaFrame();
    	if(ae.getSource()==issuemediadetails)
			new ViewIssueMediaDetails();
    	if(ae.getSource()==recievemediadetails)
			new ViewReceiveMediaDetails();
    	if(ae.getSource()==updatecus)
			new UpdateCustomer();
    	if(ae.getSource()==changeid)
			new ChangeAdminPasswordFrame();
    
    
    
    }


  
}
