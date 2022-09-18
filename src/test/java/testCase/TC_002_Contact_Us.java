package testCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.contact_us;
import testbase.Baseclass;

public class TC_002_Contact_Us extends Baseclass {
	
	
	@Test
	public void test_contact_us() throws InterruptedException, IOException
	{
		
		try
		{

		logger.info("TC_002_Openingup the contact us screen");
		driver.get("http://jupiter.cloud.planittesting.com");
		
		driver.manage().window().maximize();

		contact_us ct =new contact_us(driver);
		ct.clkcontact();

		ct.setForeName("xyz");
		logger.info("Provided fore name");

		ct.setemail("xyz@gmail.com");
		logger.info("Provided email");

		ct.setmsg("Cold weather paired with women's knitwear and cardigans from Review are a match made in heaven");
		logger.info("Provided Message");
		
		ct.clksubmit();
		logger.info("Clicked on submit button");

		
	//	Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		
        String confmsg=ct.getConfirmationMsg();
		
		if(confmsg.equals("Thanks xyz, we appreciate your feedback."))
		{
			logger.info("Feedback sent");

			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			
			logger.info("Feedback process got failed");
		}
		}
		catch(Exception e)
		{
			logger.fatal("Failed ");
			captureScreen(driver, "test_contact_us"); //Capturing screenshot
			Assert.fail();
		}
		
	}
	
		
		
	}


