package FrameRelated;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ClassRelated.FileReadWrite;
import ClassRelated.Media;
import ClassRelated.Customer;
import ClassRelated.ValidationChecking;
import EnumRelated.MsgBox;
import EnumRelated.enumMsgBox;

public  class AddMediaFrame extends JFrame implements ActionListener {
	
		private JLabel lblmediaid,lbltitle,lblactor,lblactress,lbldirector,lblrating,lblprice,lblcopies;
		private JTextField txtmediaid,txttitle,txtactor,txtactress,txtdirector,txtprice;
		private JButton btnrefresh,btnok,btngen;
		private JPanel panelbutton,panelinput;  
		private JComboBox combocopies,comborating;
		private static String[] combocopieslist={"Enter no of copies","1","2","3"};
		private static String[] comboratinglist={"","G","PG"};
		 private ArrayList<Media> list;
		 private int mediaid;
		// private int i=0;
		 
		public AddMediaFrame(){
			
			
			list=new ArrayList<Media>();
			//reading from file
			try
			{
			   list=FileReadWrite.readingFromMediaDB();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"File not found");
			}
			
			if(list.size()==0)
			
				mediaid=1000;
			
			else
				mediaid=list.get(list.size()-1).getMediaid()+1;
			
			
			lblmediaid=new JLabel("MEDIA ID");
			lbltitle=new JLabel("TITLE");
			lblactor=new JLabel("ACTOR");
			lblactress=new JLabel("ACTRESS");
			lbldirector=new JLabel("DIRECTOR");
			lblrating=new JLabel("RATING");
			lblprice=new JLabel("PRICE");
			lblcopies=new JLabel("COPIES");
			
			combocopies=new JComboBox(combocopieslist);
			comborating=new JComboBox(comboratinglist);
		
			txtmediaid=new JTextField(10);
			txttitle=new JTextField(10);
			txtactor=new JTextField(10);
			txtactress=new JTextField(10);
			txtdirector=new JTextField(10);
			txtprice=new JTextField(10);
			txtmediaid.setEditable(false);
			txtmediaid.setText(""+mediaid);
			
			btnrefresh=new JButton("Refresh");
			btnok=new JButton("Ok");
			//btngen=new JButton("Gen");
		
			setLayout(new GridLayout(9,2,4,4));
			add(lblmediaid);
			add(txtmediaid);
			add(lbltitle);
			add(txttitle);
			add(lblactor);
			add(txtactor);
			add(lblactress);
			add(txtactress);
			add(lbldirector);
			add(txtdirector);
			add(lblrating);
			add(comborating);
			add(lblprice);
			add(txtprice);
			add(lblcopies);
			add(combocopies);
			
			add(btnok);
			add(btnrefresh);
		    
			setSize(600,300);
			setTitle("Add Media");
			setVisible(true);
			setResizable(false);
			
			btnrefresh.addActionListener(this);
			btnok.addActionListener(this);
		}
		
		
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==btnok)
			{

					checkSpaces();
			}
			if(event.getSource()==btnrefresh)
			{
				refreshAll();
			}
		}
		
		private void checkSpaces() {
			String title=txttitle.getText().toUpperCase();
			
			String actor=txtactor.getText().toUpperCase();
			
			String actress=txtactress.getText().toUpperCase();
			
			String director=txtdirector.getText().toUpperCase();
			
			String price=txtprice.getText();
			String ratings=(String) comborating.getSelectedItem();
			String copies=(String) combocopies.getSelectedItem();
			String copies1=copies;	
			if(title.equals("")||actor.equals("")||actress.equals("")||director.equals("")||price.equals("")||ratings.equals("")||copies1.equals("Enter no of copies"))
			  {
				if(ValidationChecking.isEmpty(title))
			     {
					JOptionPane.showMessageDialog(this,"Please Enter Media Title");
					txttitle.requestFocus();
					
			     }
			     else
			     {
			    	 if(ValidationChecking.isEmpty(actor))
				     {
						JOptionPane.showMessageDialog(this,"Please Enter Actor Name");
						txtactor.requestFocus();
						
				     } 
			    	 else
			    	 {
			    		 if(ValidationChecking.isEmpty(actress))
					     {
							JOptionPane.showMessageDialog(this,"Please Enter Actress Name");
							txtactress.requestFocus();
							
					     }
			    		 else
			    		 {
			    			 if(ValidationChecking.isEmpty(director))
						     {
								JOptionPane.showMessageDialog(this,"Please Enter Director Name");
								txtdirector.requestFocus();
								
						     }
			    			 else
			    			 {
			    				 if(ratings.equals(""))
			    			     {
			    					JOptionPane.showMessageDialog(this,"Please Enter Rating");
			    					
			    			     }
			    				 else
			    				 {
			    					 if(ValidationChecking.isEmpty(price))
			    				     {
			    						JOptionPane.showMessageDialog(this,"Please Enter Media Price");
			    						txtprice.requestFocus();
			    						
			    				     }
			    					 else
			    					 {
			    						 if(copies1.equals("Enter no of copies"))
			    					     {
			    							JOptionPane.showMessageDialog(this,"Please Enter Number Of Copies");
			    							
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
				      
			addMedia();
	        }
		}


		private void addMedia() {
			
			
			list.add(getMedia());
			mediaid=Integer.parseInt(txtmediaid.getText().trim())+1;
		 	txtmediaid.setText(""+mediaid);
			try
			{   
				
			    FileReadWrite.writingToMediaDB(list);
			   refreshAll();
			  			}
			catch(Exception exp)
			{
				MsgBox.signal(enumMsgBox.CANTWRITETODATA);//enum used
			}
			
		}


		public Media getMedia()
		{
			String title=txttitle.getText().toUpperCase();
			String actor=txtactor.getText().toUpperCase();
			String actress=txtactress.getText().toUpperCase();
			String director=txtdirector.getText().toUpperCase();
			String price=txtprice.getText();
			int mediaid=Integer.parseInt(txtmediaid.getText());
			
			int copies=Integer.parseInt((String) combocopies.getSelectedItem());
			String ratings=(String) comborating.getSelectedItem();
			
			Media media=new Media( title,actor,actress, director,
					price,mediaid,ratings,copies);
			
			
			return media;
			
		}
		
		void refreshAll()
		{
						txttitle.setText(" ");
			txtactor.setText(" ");
			txtactress.setText(" ");
			txtdirector.setText(" ");
			txtprice.setText(" ");
		}
		
}

