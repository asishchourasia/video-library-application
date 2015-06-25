package ClassRelated;


import java.util.Scanner;

public class ValidationChecking {
		
	
	public static boolean isEmail(String str)
	{
		Scanner scan=new Scanner(str);
		String pattern="^[a-z]{1}[a-z0-9]{0,}@[a-z]{1,10}.[a-z]{2,8}$";
		if(scan.findInLine(pattern)==null)
			return false;
		else
			return true;
	}
	public static boolean isMobileNo(String str)
	{
		Scanner scan=new Scanner(str);
		String pattern="^\\d{10}";
		{
		if(scan.findInLine(pattern)==null)
			return false;
		else 
			return true;
		}
	}
	public static boolean isEmpty(String str) {
		if(str.equals(""))
			return true;
		else
		
		return false;
	}
	
}

