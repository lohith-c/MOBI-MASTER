package main_method;
import java.util.Scanner;
import display.DisplayFile;
import details.Details;


public class Main_method
{
 public static void main(String[] args)
 {
	 Details.message();
	 Scanner take_input= new Scanner(System.in);
	 DisplayFile.availabel_mobiles();
	 DisplayFile mobile=new DisplayFile();
	 
	 while(true)
	 {
		 Details.loop();
		 String str= take_input.nextLine();
		 
		 if(str.equals("0"))
			 break;
		 mobile.display(str);
	 }
	 
	 System.out.println("Visit Again");
 }
}
