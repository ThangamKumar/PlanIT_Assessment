package testCase;

import java.io.IOException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.contact_us;
import testbase.Baseclass;

public class TC_001_Contac_Us extends Baseclass {
	
	
	@Test
	public void test_invaild_contact() throws InterruptedException, IOException
	{
		//try
		//{
			
		logger.info("TC_001_Started excuting the testcase 1");

		driver.get("http://jupiter.cloud.planittesting.com");

        driver.manage().window().maximize();
        
        contact_us ct =new contact_us(driver);
		ct.clkcontact();
		logger.info("TC_002_Openingup the contact us screen");


		ct.clksubmit();
		logger.info("Clicked on submit button");

		Thread.sleep(5000);
	
	   	String exp_fore ="Forename is required";
	       
	    //identify actual error message

	    String act_fore = ct.err_forename.getText();
	      
	    System.out.println("Error message of forename is: "+ act_fore);
	    
	      //verify error message with Assertion
	      Assert.assertEquals(exp_fore, act_fore);
	      
		logger.info("Forename error meesage is validated");
	
		String exp_email ="Email is required";
	       
	    //identify actual error message

	    String act_email = ct.err_email.getText();
	      
	    System.out.println("Error message of email is: "+ act_email);
	      //verify error message with Assertion
	    
	      Assert.assertEquals(exp_email, act_email);
		logger.info("Email error message is validated");
		
		String exp_msg ="Message is required";
	       
	    //identify actual error message

	    String act_msg = ct.err_message.getText();
	      
	    System.out.println("Error message of message is: "+ act_msg);
	     //verify error message with Assertion
	    
	    // Assert.assertEquals(exp_msg, act_msg);
		
	 // logger.info("Message error message is validated");
		
		
		logger.info("Populating the data");
	  // System.out.println("populating "+ act_msg);


		ct.setForeName("xyz");
		logger.info("Provided fore name");

		ct.setemail("xyz@gmail.com");
		logger.info("Provided email");

		ct.setmsg("Cold weather paired with women's knitwear and cardigans from Review are a match made in heaven");
		logger.info("Provided Message");
		
		System.out.println("data givennnnnnnnnnnnnnn validating the error");
		
	//Thread.sleep(5000);
	try{
		if(ct.err_forename.isDisplayed() && ct.err_message.isDisplayed() && ct.err_email.isDisplayed())
	        System.out.println("Element is present and displayed Success");
	  
	}
	catch (Exception e) {
	    System.out.println("Element is not present, hence not displayed as well");
	}
	
		/*ct.validate_errors();
		logger.error("Account Registration Failed ");
		captureScreen(driver, "test_accout_Registration"); //Capturing screenshot
		System.out.println(" validated the error");*/

	
		} 
		/*catch(Exception e)
		{
			logger.fatal("Validating errors got Failed ");
			captureScreen(driver, "test_invaild_contact"); //Capturing screenshot
			Assert.fail();
		}*/
		
		
	}
//}
