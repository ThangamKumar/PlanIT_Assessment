package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shop {
	
	static WebDriver driver;
	
	public Shop(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath="//a[normalize-space()='Shop']")
     WebElement Shop_screen;
	
	 @FindBy(xpath ="/html[1]/body[1]/div[2]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[1]")
	 WebElement Buy_frog;
	 
	 @FindBy(xpath ="/html[1]/body[1]/div[2]/div[1]/ul[1]/li[4]/div[1]/p[1]/a[1]")
	 WebElement Buy_Fluffy_bunny;
	 

	 @FindBy(xpath ="/html/body/div[2]/div/ul/li[7]/div/p/a")
	 WebElement Buy_vbear;
	 
	 @FindBy(xpath ="//li[@id='product-2']//span[@class='product-price ng-binding'][normalize-space()='$10.99']")
	public
	 WebElement Shp_frog_price;
	 
	 @FindBy(xpath ="//li[@id='product-4']//span[@class='product-price ng-binding'][normalize-space()='$9.99']")
	 WebElement Shp_bunny_price;
	 
	 @FindBy(xpath ="//li[@id='product-7']//span[@class='product-price ng-binding'][normalize-space()='$14.99']")
	 WebElement shp_vbear;
	 
	 
	 public void clkshop()
	 {
	 	Shop_screen.click();
	 }
	 
	 public void clk_buy_frog()
	 {
		 Buy_frog.click();
	 }
	 
	 public void double_clk_frog()
	 {
		 //action method
	      Actions act= new Actions(driver);
	      System.out.println("coming action class");  
	      try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      act.moveToElement(Buy_frog).doubleClick().build().perform();
		 
	 }
	 
	 public void clk_buy_Fluffy_bunny()
	 {
		 Buy_Fluffy_bunny.click();
	 }
	 
	 public void clk_buy_vbear()
	 {
		 Buy_vbear.click();
	 }
	 
	 public static float getfloat_price_frog()
	 {
		    Shop Sp = new Shop(driver);
		    
		    String Shp_frog_per_price = Sp.Shp_frog_price.getText();
		    
		    String Act_Shp_frog_per_price =Shp_frog_per_price.substring(1); //remove dollar symbol
		    
		    Float Float_frog_per_price = Float.parseFloat(Act_Shp_frog_per_price); //converted string to float
		    
		    return Float_frog_per_price;
	 }
	 
	 public static float getfloat_price_bunny()
	 {
		    Shop Sp = new Shop(driver);
		    
		    String Shp_bunny_per_price = Sp.Shp_bunny_price.getText();
		    
		    String Act_Shp_bunny_per_price = Shp_bunny_per_price.substring(1); //remove dollar symbol
		    
		    Float Float_bunny_per_price = Float.parseFloat(Act_Shp_bunny_per_price); //converted string to float
		    
		    return Float_bunny_per_price;
	 }
	 
	 public static float getfloat_price_bear()
	 {
		    Shop Sp = new Shop(driver);
		    
		    String Shp_bear_per_price = Sp.shp_vbear.getText();
		    
		    String Act_Shp_bear_per_price = Shp_bear_per_price.substring(1); //remove dollar symbol
		    
		    Float Float_bear_per_price = Float.parseFloat(Act_Shp_bear_per_price); //converted string to float
		    
		    return Float_bear_per_price;
	 }
	 
	 

}
