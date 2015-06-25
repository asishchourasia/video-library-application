package FrameRelated;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ClassRelated.FileReadWrite;
import ClassRelated.Media;

public class MediaSearchFrame extends JFrame implements ActionListener
{
	private JComboBox combosearch;
	private static String[] combosearchlist={"Title","Actor","Actress","Director"};
	private JLabel lblsearch;
	private JTextField txtsearch;
	private JPanel panel1,panel2,panel3; 
	private JButton btnsearch,btnclear;
	private Box boxsearch;
	
	
	public MediaSearchFrame()
	{
		combosearch=new JComboBox(combosearchlist);
		add(combosearch);
		lblsearch=new JLabel("SEARCH BY ?");
		
		btnsearch=new JButton("SEARCH");
		btnclear=new JButton("CLEAR");
		lblsearch=new JLabel("ENTER YOUR SEARCH HERE");
		boxsearch=Box.createVerticalBox();
		
		panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
		
        txtsearch=new JTextField(10);
		
        panel1.add(lblsearch);
		panel1.add(combosearch);
		panel2.add(txtsearch);
		panel3.add(btnsearch);
		panel3.add(btnclear);
		boxsearch.add(panel1);
		boxsearch.add(panel2);
		
		
		add(boxsearch,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);	
	    setSize(300,200);
		setTitle("Search Window");
		setVisible(true);
		
		btnsearch.addActionListener(this);
		btnclear.addActionListener(this);

	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnsearch)
		{
			searchMedia();
		}
		if(ae.getSource()==btnclear)
		{
		refreshAll();
		}
		
		
	}


	private void refreshAll() 
	{
		txtsearch.setText("");
		combosearch.setSelectedItem(" ");
	}


	private void searchMedia()//for searching media according to category
	{
		String combocategory=(String)combosearch.getSelectedItem();
		String searchtext=txtsearch.getText().toUpperCase();
		
		if(searchtext.equals(""))
		{
			JOptionPane.showMessageDialog(this,"Please Enter  The Required Fields...");
		}
		else
		{
		String mediaheading[]={"Name","Actors","Actress","Director","Price","Media-Id"};
		String data[][]=new String[50][6];
		ArrayList<Media> list=new ArrayList<Media>();
		try
		  {
			list=FileReadWrite.readingFromMediaDB();
			if(combocategory.equalsIgnoreCase("Title"))
			 {
				
				int f=0,r=0;
				for(Media m : list)
				{ 
					if(m.getTitle().startsWith(searchtext))
					{
					
				data[r][0]=m.getTitle();
				data[r][1]=m.getActor();
				data[r][2]=m.getActress();
				data[r][3]=m.getDirector();
				data[r][4]=m.getPrice();
				data[r][5]=""+m.getMediaid();
				r++;
				    
				f=1;	
						
                    }
				} 
				if(f==1)
				{
						
						JTable Datatable=new JTable(data, mediaheading);
						JScrollPane jsp=new JScrollPane(Datatable);
						JFrame dataframe=new JFrame();
						Container c=dataframe.getContentPane();
						c.setLayout(new BorderLayout());
						c.add(new JLabel("Your Search Result......."),BorderLayout.NORTH);
						c.add(jsp,BorderLayout.CENTER);
						
                        dataframe.setSize(1050,600);
						
                        dataframe.setLocation(150,70);
                        dataframe.setVisible(true);
						
		        }
    		      else
				{
					JOptionPane.showMessageDialog(this,"Media Not Available.....");
				}
			
			}
			
		
			else if(combocategory.equalsIgnoreCase("Actor"))
			{
				int p=0,r=0;
				for(Media s : list)
				{  
					if(s.getActor().startsWith(searchtext))
					{
						
					
				data[r][0]=s.getTitle();
				data[r][1]=s.getActor();
				data[r][2]=s.getActress();
				data[r][3]=s.getDirector();
				data[r][4]=s.getPrice();
				data[r][5]=""+s.getMediaid();
				r++;
				    
			
				p=1;
			}
					
		}
		if(p==1)
			{

			JTable Datatable=new JTable(data, mediaheading);
			JScrollPane jsp=new JScrollPane(Datatable);					
			JFrame dataframe=new JFrame();
			Container c1=dataframe.getContentPane();
			c1.setLayout(new BorderLayout());
			c1.add(new JLabel("Your Search Result........"),BorderLayout.NORTH);
					c1.add(jsp,BorderLayout.CENTER);
					
                    dataframe.setSize(1050, 600);
					
                    dataframe.setLocation(200, 100);
                    dataframe.setVisible(true);
					
				}
					
				
				else
				{
					JOptionPane.showMessageDialog(this,"Media Not Available.....");
				}
			}
				
			
			
			else if(combocategory.equalsIgnoreCase("Actress"))
			{
				int q=0,r=0;
				for(Media n : list)
				{ 
					if(n.getActress().startsWith(searchtext))
					{
					
					
				data[r][0]=n.getTitle();
				data[r][1]=n.getActor();
				data[r][2]=n.getActress();
				data[r][3]=n.getDirector();
				data[r][4]=n.getPrice();
				data[r][5]=""+n.getMediaid();
				r++;
				    
					
						q=1;
					}
				}	
				if(q==1)
				{
						
						JTable Datatable=new JTable(data, mediaheading);
						JScrollPane jsp=new JScrollPane(Datatable);
						
						

						JFrame dataframe=new JFrame();
						Container c=dataframe.getContentPane();
						c.setLayout(new BorderLayout());
						c.add(new JLabel("Your Search Result......"),BorderLayout.NORTH);
						c.add(jsp,BorderLayout.CENTER);
						
                        dataframe.setSize(1050, 600);
						
                        dataframe.setLocation(100, 70);
                        dataframe.setVisible(true);
						
				}		
					
				
				else
				{
						JOptionPane.showMessageDialog(this,"Media Not Available.....");
				}
			}
		
			else if(combocategory.equalsIgnoreCase("Director"))
			{
				int q=0,r=0;
				for(Media o : list)
				{ 
					if(o.getDirector().startsWith(searchtext))
					{
					
					
				data[r][0]=o.getTitle();
				data[r][1]=o.getActor();
				data[r][2]=o.getActress();
				data[r][3]=o.getDirector();
				data[r][4]=o.getPrice();
				data[r][5]=""+o.getMediaid();
				r++;
				    
					
						q=1;
					}
				}	
				if(q==1)
				{
						
						JTable Datatable=new JTable(data, mediaheading);
						JScrollPane jsp=new JScrollPane(Datatable);
						
						

						JFrame dataframe=new JFrame();
						Container c=dataframe.getContentPane();
						c.setLayout(new BorderLayout());
						c.add(new JLabel("Your Search Result......"),BorderLayout.NORTH);
						c.add(jsp,BorderLayout.CENTER);
						
                        dataframe.setSize(1050, 600);
						
                        dataframe.setLocation(100, 70);
                        dataframe.setVisible(true);
						
				}		
					
				
				else
				{
						JOptionPane.showMessageDialog(this,"Media Not Available.....");
				}
			}
		  }
		catch(Exception e)
		{}
		}
	}
}