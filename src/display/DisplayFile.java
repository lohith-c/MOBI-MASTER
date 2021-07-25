package display;
import shop.Shop;
import java.awt.*;  
import javax.swing.JFrame;
import mobiles.*;

class MobileNotPresent extends Exception
{
	MobileNotPresent(String message)
	{
		super(message);
	}
}

class MyCanvas extends Canvas{  
    
	private String imageURL;
	
	MyCanvas(Shop mobile)
	{
		this.imageURL=mobile.getPic();
	}
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage(this.imageURL);  
        g.drawImage(i, 120,100,this);  
          
    }   
  
}   

public class DisplayFile 
{
static String[] mobile= {"OnePlus_Nord_CE_5G","i_phone_11_pro_max"};

public static void availabel_mobiles()
{
	System.out.println("Available Mobiles\n");
	
 for(int i=0;i<mobile.length;i++)
 {
	 System.out.println(mobile[i]);
 }
 System.out.print("\n");
}

public boolean find_it(String className)
{
	for(int i=0;i<mobile.length;i++)
	{
		if(className.equals(mobile[i]))
			return true;
	}
	
	return false;
}

public void print_it(Shop mobile)
{
	Thread t1=new Thread(new Runnable() {
		 public void run()
		 {	
			   MyCanvas m=new MyCanvas(mobile);  
		       JFrame f=new JFrame();  
		       f.add(m);  
		       f.setSize(600,600);  
		       f.setVisible(true);  
		 }
	 },"pic of mobile");
	 
  Thread t2=new Thread(new Runnable() {
		 public void run()
		 {
	System.out.println(mobile.getCompanyName());
	System.out.println(mobile.getInfo());
	System.out.println(mobile.getAudio());
	System.out.println(mobile.getButtons());
	System.out.println(mobile.getCamera());
	System.out.println(mobile.getConnectivity());
	System.out.println(mobile.getDimensions());
	System.out.println(mobile.getDisplay());
	System.out.println(mobile.getMultimedia());
	System.out.println(mobile.getPerformance());
	System.out.println(mobile.getPorts());
	System.out.println(mobile.getSensors());
	System.out.println("****");
  }
	 },"Prints details of mobile");
  	
		 t1.start();
		 t2.start();
		
		 try {
		  t1.join();
		  t2.join();
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
}

public void display(String className)
{
	 Shop mobile;
	 
	 try {
		 if(! find_it(className))
			 throw new MobileNotPresent("Your Desired Mobile Not Present In Showroom");
		 
		 String CLASSNAME="mobiles."+className;
		 mobile=(Shop)Class.forName(CLASSNAME).newInstance();
		 print_it(mobile);
	 }
	 catch(Exception e)
	 {
	System.out.println(e);	
	 System.out.println("Try Again");
	 }
	 finally {
		 System.out.println("***");
	 }
}
}
