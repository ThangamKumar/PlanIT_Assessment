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
		try {
			
		
		logger.info("TC_003_Adding product to the cart testcase strated excuting");

        driver.get("http://jupiter.cloud.planittesting.com");
		
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


		Shop sp =new Shop(driver);
		sp.clkshop();
		logger.info("Shop link is clicked");
		
		logger.info("Getting the price for each products");

		 float Float_per_frog_From_shop = sp.getfloat_price_frog();
		 
         System.out.println("Retrived from shop screen individual frog price");
         
	     float Float_per_bunny_From_shop =  sp.getfloat_price_bunny();
	     float Float_per_bear_From_shop = sp.getfloat_price_bear();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		sp.double_clk_frog();
		
		logger.info("2 frogs has been added to the cart");
		
		int a=0;
	     
	       while(a<5)
	       {
		   
	    	  sp.clk_buy_Fluffy_bunny();
		       a++;

		  
	      }
		logger.info("5 bunny has been added to the cart");

	       int b=0;
		     
	       while(b<3)
	       {
		   
	    	   sp.clk_buy_vbear();
		       b++;

		  
	      }
		  logger.info("3 vbear has been added to the cart");

	       
		logger.info("All the products has been added into the cart ");

	       
		Cart Ct =new Cart(driver);
	    Ct.clkcart();
	    logger.info("Cart link is clicked");
			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		float[] Float_total_frog_from_Cart = Ct.get_subtotal_frog();
	    float[] Float_total_bunny_from_Cart =  Ct.get_subtotal_bunny();
	    float[] Float_total_bear_from_Cart = Ct.get_subtotal_bear();
	       
	       
	    logger.info("Verifying the subtotal for all product Vs total amount in cart");

		float sum_subtotal = Float_total_frog_from_Cart[1] + Float_total_bunny_from_Cart[1] + Float_total_bear_from_Cart[1];
			
	    String total = Ct.cart_total.getText();
		String ActF_Total = total.substring(7);
		float Float_Total = Float.parseFloat(ActF_Total);
		     
		logger.info("Getting the total from the cart ");

	     //System.out.println("Float_Total:"+ Float_Total + "sum_subtotal:"+ sum_subtotal);
			
			
		int rem1 =Float.compare(sum_subtotal, Float_Total);
	     //   System.out.println("rem:" + rem + "Price:"+Price+"Price_per_frog:"+Price_per_frog)
			
        if(rem1 == 0)
		{
	         Assert.assertTrue(true);
			 logger.info("Success- Sum of sub total all products from cart is matching total amount");

	         System.out.println("success");

		 } 
		else
		 {
		     Assert.assertTrue(false);
			 logger.info("Failed -Sum of sub total all products from cart is not matching total amount");

			 captureScreen(driver, "test_add_products"); //Capturing screenshot

		   }
		    
		 logger.info("Verify the subtotal for each product is correct ");
		    
		 int rem_subtotal_frog =Float.compare(Float_total_frog_from_Cart[1], Float_total_frog_from_Cart[2]);
		 int rem_subtotal_bunny =Float.compare(Float_total_bunny_from_Cart[1], Float_total_bunny_from_Cart[2]);
		 int rem_subtotal_bear =Float.compare(Float_total_bear_from_Cart[1], Float_total_bear_from_Cart[2]);
		    
		 System.out.println("Float_total_frog_from_Cart[1]:" + Float_total_frog_from_Cart[1] + "Float_total_frog_from_Cart[2]:"+Float_total_frog_from_Cart[2]);
		 System.out.println("Float_total_bunny_from_Cart[1]:" + Float_total_bunny_from_Cart[1] + "Float_total_bunny_from_Cart[2]:"+Float_total_bunny_from_Cart[2]);
		 System.out.println("Float_total_bear_from_Cart[1]:" + Float_total_bear_from_Cart[1] + "Float_total_bear_from_Cart[2]:"+Float_total_bear_from_Cart[2]);

		    
	     if(rem_subtotal_frog == 0 && rem_subtotal_bunny == 0 && rem_subtotal_bear == 0)
	     {
		     Assert.assertTrue(true);
		     System.out.println("success - subtotal for each product is correct");
		     logger.info("success - subtotal for each product is correct");

		} 
	    else
		{
			  Assert.assertTrue(false);
			  System.out.println("subtotal for each product is not correct");
			  logger.info("Fail - subtotal for each product is not correct");

	    }
			    
	    logger.info("Verify the price for each product from Cart Vs Shop");
		    
		int rem_per_frog =Float.compare(Float_total_frog_from_Cart[0], Float_per_frog_From_shop);
		int rem_per_bunny =Float.compare(Float_total_bunny_from_Cart[0], Float_per_bunny_From_shop);
		int rem_per_bear =Float.compare(Float_total_bear_from_Cart[0], Float_per_bear_From_shop);
		    
		System.out.println("Float_total_frog_from_Cart[0]:" + Float_total_frog_from_Cart[0] + "Float_per_frog:"+Float_per_frog_From_shop);
	    System.out.println("Float_total_bunny[0]:" + Float_total_bunny_from_Cart[0] + "Float_per_bunny:"+Float_per_bunny_From_shop);
		System.out.println("Float_total_bear[0]:" + Float_total_bear_from_Cart[0] + "Float_per_bear:"+Float_per_bear_From_shop);
		    
		System.out.println("rem_per_frog:" + rem_per_frog + "rem_per_bunny:"+rem_per_bunny+"rem_per_bear:"+rem_per_bear);

	    if(rem_per_frog == 0 && rem_per_bunny == 0 && rem_per_bear == 0)
		{
		     Assert.assertTrue(true);
		     logger.info("success -Per price of the products from the cart is matching with the price from shop");
		     System.out.println("success -Per price of the products from the cart is matching with the price from shop");

	    } 
		else
	    {
			 Assert.assertTrue(false);
			 logger.info("Failed -Per price of the products from the cart is not matching with the price from shop");
			 System.out.println("Failed -Per price of the products from the cart is not matching with the price from shop");
	    }
			    
		}
		catch (Exception e)
		{
			logger.fatal("Failed ");
			captureScreen(driver, "test_add_products"); //Capturing screenshot
			Assert.fail();
		}
		
		
		     
	}
}
