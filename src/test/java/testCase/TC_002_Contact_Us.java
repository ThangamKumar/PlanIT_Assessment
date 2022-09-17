package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.contact_us;
import testbase.Baseclass;

public class TC_002_Contact_Us extends Baseclass {
	
	
	@Test
	public void test_contact_us() throws InterruptedException
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

		
		Thread.sleep(5000);
		
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
			Assert.fail();
		}
		
	}
	
		
		
	}


