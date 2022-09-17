package PageObjects;

//import static org.junit.Assert.assertTrue;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Cart {
	
	public static float Float_SubTotal;

	static float Float_SubTotal1;

	static float Float_SubTotal2;
	
	 static WebDriver driver;
		public Cart (WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		 @FindBy(xpath="/html/body/div[1]/div/div/div/ul[2]/li[4]/a")
	     WebElement Cart_screen;
		 
		 @FindBy(xpath ="//table[@class =\"table table-striped cart-items\"]/tbody/tr[1]/td[2]")
		public
		 WebElement frog_per_price;
		 
		 @FindBy(xpath ="//input[@value='2']")
		 WebElement frog_quantity;
		 
		 @FindBy(xpath="//table[@class =\"table table-striped cart-items\"]/tbody/tr[1]/td[4]")
		 WebElement frog_subtotal;
		 
		 @FindBy(xpath ="//table[@class =\"table table-striped cart-items\"]/tbody/tr[2]/td[2]")
		public
		 WebElement bunny_per_price;
		 
		// @FindBy(xpath ="//table[@class =\"table table-striped cart-items\"]/tbody/tr[2]/td[3]")
		 @FindBy(xpath ="//input[@value='5']")
		 WebElement bunny_quantity;
		 
		 @FindBy(xpath ="//table[@class =\"table table-striped cart-items\"]/tbody/tr[2]/td[4]")
		 WebElement bunny_subtotal;
	     
	     @FindBy(xpath="//table[@class =\"table table-striped cart-items\"]/tbody/tr[3]/td[2]")
		public
		 WebElement bear_per_price;

	     @FindBy(xpath="//input[@value='3']")
		 WebElement bear_quantity;
	     
	  	 @FindBy(xpath="//table[@class =\"table table-striped cart-items\"]/tbody/tr[3]/td[4]")   
         WebElement bear_subtotal;
	  	 
	  	 @FindBy(xpath ="//strong[@class='total ng-binding']")
		public
         WebElement cart_total;
	  	 
	  	public void clkcart()
		{
	  		Cart_screen.click();
		}
 
	  	public static float[] get_subtotal_frog()
	  	{
	  		Cart frg = new Cart(driver);
	  				
	  		 String Price =frg.frog_per_price.getText();              //$10.99
	  		 String ActualPrice = Price.substring(1);
		     float Float_Price = Float.parseFloat(ActualPrice);   //10.99

	         String Quantity =frg.frog_quantity.getAttribute("value");  //2
		     
		     String frog_subTotal = frg.frog_subtotal.getText();       //$21.98
		     String ActF_subTotal = frog_subTotal.substring(1);
		     float Float_SubTotal = Float.parseFloat(ActF_subTotal);
		     
		     float a11 = Float_Price * Float.parseFloat(Quantity);
		     
		     if(a11==Float_SubTotal)
		     {
		    	 
		    	 Assert.assertTrue(true);
		    	 System.out.println("Validated the subtotal of frog");
		     }
		     else
		     {
		    	 Assert.assertTrue(false);
		    	 System.out.println("Not Validated the subtotal of frog");

		     }
		     
		     float[] Price_SubTotal = new float[2];
		     Price_SubTotal[0] = Float_Price;
		     Price_SubTotal[1] = Float_SubTotal;
		     
		     return Price_SubTotal;
	  	}
	  	
	  	public void get_sub_totals()
	  	{
	  		Cart Total = new Cart(driver);
	  		
	  	}
	  	
	  	public static float[] get_subtotal_bunny()
	  	{
	  		Cart bun = new Cart(driver);
	  		
	  		 String Price1 = bun.bunny_per_price.getText();              //$10.99
	  		
		     String ActualPrice1 = Price1.substring(1);
		     float Float_Price1 = Float.parseFloat(ActualPrice1);   //10.99

	         String Quantity1 = bun.bunny_quantity.getAttribute("value");  //2

		  		
		     String bunny_subTotal = bun.bunny_subtotal.getText();  

		     String ActB_subTotal = bunny_subTotal.substring(1);

		     
		     float Float_SubTotal1 = Float.parseFloat(ActB_subTotal);
		  		
		     float a12 = Float_Price1 * Float.parseFloat(Quantity1);
		     float a122 = (float) (Math.round(a12 * 100.0) / 100.0);
		     
		     if(a122==Float_SubTotal1)
		     {
		    	 
		    	 Assert.assertTrue(true);
		    	 System.out.println("Validated the subtotal of Bunny");
		     }
		     else
		     {
		    	 Assert.assertTrue(false);
		    	 System.out.println("Not Validated the subtotal of Bunny");

		     }
		     
		     float[] Price_SubTotal_bunny = new float[2];
		     Price_SubTotal_bunny[0] = Float_Price1;
		     Price_SubTotal_bunny[1] = Float_SubTotal1;
		     
		     return Price_SubTotal_bunny;
	  	}

	  	private Float round(float a12, int i) {
			// TODO Auto-generated method stub
			return null;
		}

		public static float[] get_subtotal_bear()
	  	{
			Cart bear = new Cart(driver);
			
	  		 String Price2 = bear.bear_per_price.getText();              
		     String ActualPrice2 = Price2.substring(1);
		     Float Float_Price2 = Float.parseFloat(ActualPrice2);   

	         String Quantity2 = bear.bear_quantity.getAttribute("value");  
		     
		     String bear_subTotal = bear.bear_subtotal.getText();       
		     String ActBR_subTotal = bear_subTotal.substring(1);
		     Float Float_SubTotal2 = Float.parseFloat(ActBR_subTotal);
		     
		     float a13 = Float_Price2 * Float.parseFloat(Quantity2);
		     float a133 = (float) (Math.round(a13 * 100.0) / 100.0);
		     
		     if(a133==Float_SubTotal2)
		     {
		    	 
		    	 Assert.assertTrue(true);
		    	 System.out.println("Validated the subtotal of Vbear");
		     }
		     else
		     {
		    	 Assert.assertTrue(false);
		    	 System.out.println("Not Validated the subtotal of Vbear");

		     }
		     
		     float[] Price_SubTotal_bear = new float[2];
		     Price_SubTotal_bear[0] = Float_Price2;
		     Price_SubTotal_bear[1] = Float_SubTotal2;
		     
		     return Price_SubTotal_bear;
	  	}
		
		/*public static float[] cl_subtotal(float a[])
	  	{
			float[] myarray = 
	  	} */


}
	  	
		
	

       

