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
		try
		{
			
			logger.info("TC_001_Started excuting the testcase 1");

			driver.get("http://jupiter.cloud.planittesting.com");

			driver.manage().window().maximize();
        
			contact_us ct =new contact_us(driver);
			ct.clkcontact();
			logger.info("Openingup the contact us screen");


			ct.clksubmit();
			logger.info("Clicked on submit button");

		//Thread.sleep(5000);
	
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
	    
			Assert.assertEquals(exp_msg, act_msg);
			logger.info("Message error message is validated");
		
		
			logger.info("Populating the data");
	  //System.out.println("populating "+ act_msg);


			ct.setForeName("xyz");
			logger.info("Provided fore name");

			ct.setemail("xyz@gmail.com");
			logger.info("Provided email");

			ct.setmsg("Cold weather paired with women's knitwear and cardigans from Review are a match made in heaven");
			logger.info("Provided Message");
		
			System.out.println("data givennnnnnnnnnnnnnn validating the error");
			logger.info("Data has been populated ");

		
		
			if(ct.err_forename.isDisplayed() && ct.err_message.isDisplayed() && ct.err_email.isDisplayed())
				{
					System.out.println("Error Element is present and displayed Success");
					logger.info("There are error messages found in the page");
				}
	    }
	    catch (Exception e) {
		
	    	System.out.println("Error Element is not present, hence not displayed as well");
	    	captureScreen(driver, "test_invaild_contact"); //Capturing screenshot
		
	    	logger.info("Validated that the error messages are gone");
	    }
	
		
	}
}
//}
