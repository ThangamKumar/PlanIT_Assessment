package testCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Cart;
import PageObjects.Shop;
import PageObjects.contact_us;
import testbase.Baseclass;

@Test
public class TC_003_Addingproductscart extends Baseclass {

	@SuppressWarnings("deprecation")
	public void test_add_products() throws InterruptedException, IOException
	{
		
		logger.info("TC_003_Adding product to the cart testcase strated excuting");

        driver.get("http://jupiter.cloud.planittesting.com");
		
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


		Shop sp =new Shop(driver);
		sp.clkshop();
		logger.info("Shop link is clicked");
		
		logger.info("Getting the price for each products");

		 float Float_per_frog = sp.getfloat_price_frog();
         System.out.println("Retrived from shop screen individual frog price");
	     float Float_per_bunny =  sp.getfloat_price_bunny();
	     float Float_per_bear = sp.getfloat_price_bear();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		sp.double_clk_frog();
		logger.info("2 frogs has been added to the cart");
		
		int a=0;
	     
	       while(a<5)
	       {
		   
	    	  sp.clk_buy_Fluffy_bunny();
		       a++;
			  logger.info("5 bunny has been added to the cart");

		  
	      }
	       
	       int b=0;
		     
	       while(b<3)
	       {
		   
	    	   sp.clk_buy_vbear();
		       b++;
			   logger.info("3 vbear has been added to the cart");

		  
	      }
	       
			Cart Ct =new Cart(driver);
	        Ct.clkcart();
			logger.info("Cart link is clicked");
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		   float[] Float_SubTotal = Ct.get_subtotal_frog();
	       float[] Float_total_bunny =  Ct.get_subtotal_bunny();
	       float[] Float_total_bear = Ct.get_subtotal_bear();
	       
		   // System.out.println("Float_SubTotal:"+ Float_SubTotal[0] +"Float_total_bunny:"+Float_total_bunny+"Float_total_bear:"+Float_total_bear);
	       System.out.println("Float_SubTotal[0]:"+ Float_SubTotal[0] +"Float_SubTotal[1]:"+Float_SubTotal[1]);
	       
			captureScreen(driver, "test_add_products"); //Capturing screenshot
	        
			//Verify the price for each product
		     //10.9
		    
			float sum_subtotal = Float_SubTotal[1] + Float_total_bunny[1] + Float_total_bear[1];
			
			String total = Ct.cart_total.getText();
			String ActF_Total = total.substring(7);
		    float Float_Total = Float.parseFloat(ActF_Total);
		     
			//System.out.println("Float_Total:"+ Float_Total + "sum_subtotal:"+ sum_subtotal);
			
			int rem1 =Float.compare(sum_subtotal, Float_Total);
	     //   System.out.println("rem:" + rem + "Price:"+Price+"Price_per_frog:"+Price_per_frog);

		    if(rem1 == 0)
		    {
	          Assert.assertTrue(true);
	          System.out.println("success");

		    } 
		    else
		    {
		      Assert.assertTrue(false);
		      System.out.println("Verification of total = sum(sub totals) failed due to price mismatch");	
		    }
		    
		    		    
		     //Verify the price for each product*/
		  //  float prie_per_frog = Float_SubTotal[0]; // Cart products
		  //  float prie_per_bunny = Float_total_bunny[0];
		  //  float prie_per_bear = Float_total_bear[0];
		    
		    int rem_per_frog =Float.compare(Float_SubTotal[0], Float_per_frog);
		    int rem_per_bunny =Float.compare(Float_total_bunny[0], Float_per_bunny);
		    int rem_per_bear =Float.compare(Float_total_bear[0], Float_per_bear);
		    
		    System.out.println("Float_SubTotal[0]:" + Float_SubTotal[0] + "Float_per_frog:"+Float_per_frog);
		    System.out.println("Float_total_bunny[0]:" + Float_total_bunny[0] + "Float_per_bunny:"+Float_per_bunny);
		    System.out.println("Float_total_bear[0]:" + Float_total_bear[0] + "Float_per_bear:"+Float_per_bear);
		    
		        System.out.println("rem_per_frog:" + rem_per_frog + "rem_per_bunny:"+rem_per_bunny+"rem_per_bear:"+rem_per_bear);

			    if(rem_per_frog == 0 && rem_per_bunny == 0 && rem_per_bear == 0)
			    {
		          Assert.assertTrue(true);
		          System.out.println("success");

			    } 
			    else
			    {
			      Assert.assertTrue(false);
			      System.out.println("Verification of price for each product failed due to price mismatch");
			    }
		     
	}
}
