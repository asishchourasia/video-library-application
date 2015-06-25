package ClassRelated;

//import .Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileReadWrite 
{

	  public static void writingToCustomerDB(ArrayList<Customer>list) throws Exception
	  {
		 ObjectOutputStream write;
		 FileOutputStream file=new FileOutputStream("CustomerDB");
		 write= new ObjectOutputStream(file);
		 write.writeObject(list);
		 write.close();
	  }
	  public static ArrayList<Customer> readingFromCustomerDB() throws Exception
	  {
		 ObjectInputStream read;
		 FileInputStream file=new FileInputStream("CustomerDB");
		 read= new ObjectInputStream(file);
		 ArrayList<Customer>list=(ArrayList<Customer>)read.readObject();
		 read.close();
		 return list;
		  
	  }
	  public static void writingToMediaDB(ArrayList<Media>list) throws Exception
	  {
		 ObjectOutputStream write;
		 FileOutputStream file=new FileOutputStream("MediaDB");
		 write= new ObjectOutputStream(file);
		 write.writeObject(list);
		 write.close();
		 
	  }
	  public static ArrayList<Media> readingFromMediaDB() throws Exception
	  {
		 ObjectInputStream read;
		 FileInputStream file=new FileInputStream("MediaDB");
		 read= new ObjectInputStream(file);
		 ArrayList<Media>list=(ArrayList<Media>)read.readObject();
		read.close();
		 return list;
		  
	  }
	  
	  public static void writingToIssueDB(ArrayList<IssueMedia>list) throws Exception
	  {
		 ObjectOutputStream write;
		 FileOutputStream file=new FileOutputStream("IssueDB");
		 write= new ObjectOutputStream(file);
		 write.writeObject(list);
		 write.close();
	  }
	  public static ArrayList<IssueMedia> readingFromIssueDB() throws Exception
	  {
		 ObjectInputStream read;
		 FileInputStream file=new FileInputStream("IssueDB");
		 read= new ObjectInputStream(file);
		 ArrayList<IssueMedia>list=(ArrayList<IssueMedia>)read.readObject();
		 read.close();
		 return list;
		  
	  }
	  public static void writingToRegilogin(ArrayList<Login>list) throws Exception
	  {
		 ObjectOutputStream write;
		 FileOutputStream file=new FileOutputStream("Regilogin");
		 write= new ObjectOutputStream(file);
		 write.writeObject(list);
		 write.close();
	  }
	  public static ArrayList<Login> readingFromRegilogin() throws Exception
	  {
		 ObjectInputStream read;
		 FileInputStream file=new FileInputStream("Regilogin");
		 read= new ObjectInputStream(file);
		 ArrayList<Login>list=(ArrayList<Login>)read.readObject();
		 read.close();
		 return list;
		  
	  }
	  public static void writingToReceiveDB(ArrayList<ReceiveMedia>list) throws Exception
	  {
		 ObjectOutputStream write;
		 FileOutputStream file=new FileOutputStream("ReceiveDB");
		 write= new ObjectOutputStream(file);
		 write.writeObject(list);
		 write.close();
	  }
	  public static ArrayList<ReceiveMedia> readingFromReceiveDB() throws Exception
	  {
		 ObjectInputStream read;
		 FileInputStream file=new FileInputStream("ReceiveDB");
		 read= new ObjectInputStream(file);
		 ArrayList<ReceiveMedia>list=(ArrayList<ReceiveMedia>)read.readObject();
		 read.close();
		 return list;
		  
	  }
	  
	  public static void writingToAdminDB(ArrayList<Admin>list) throws Exception
	  {
		 ObjectOutputStream write;
		 FileOutputStream file=new FileOutputStream("AdminDB");
		 write= new ObjectOutputStream(file);
		 write.writeObject(list);
		 write.close();
	  }
	  public static ArrayList<Admin> readingFromAdminDB() throws Exception
	  {
		 ObjectInputStream read;
		 FileInputStream file=new FileInputStream("AdminDB");
		 read= new ObjectInputStream(file);
		 ArrayList<Admin>list=(ArrayList<Admin>)read.readObject();
		 read.close();
		 return list;
		  
	  }
	  
	
	  
}
