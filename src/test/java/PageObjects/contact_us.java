package PageObjects;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contact_us {

	 WebDriver driver;
		public contact_us (WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	 
	 @FindBy(name= "forename")
	 WebElement txtForeName;
	 
	 @FindBy(id= "email")
	 WebElement txtEmail;
	 
	 @FindBy(id= "message")
	 WebElement txtMessage;

     @FindBy(xpath="//a[@class='btn-contact btn btn-primary']")
     WebElement btnSubmit;
     
     @FindBy(xpath="//div[@class='alert alert-success']")
     WebElement msgConfirmation;
     
     @FindBy(xpath ="/html/body/div[1]/div/div/div/ul[1]/li[3]/a")
     WebElement cont;
     
     @FindBy(id= "forename-err")
	public
	 WebElement err_forename;

     @FindBy(id= "email-err")
	 public WebElement err_email;
     
     @FindBy(id= "message-err")
     public WebElement err_message;
     
     public void setForeName(String fname)
		{
    	    txtForeName.sendKeys(fname);
		}
		
		public void setemail(String email)
		{
			txtEmail.sendKeys(email);
		}

		public void setmsg(String msg)
		{
			txtMessage.sendKeys(msg);
		}
		
		public void clksubmit()
		{
			btnSubmit.click();
		}
		
		public void clkcontact()
		{
			cont.click();
		}
		public String getConfirmationMsg()
		{
			try
			{
			return (msgConfirmation.getText());
			}
			catch(Exception e)
			{
				return(e.getMessage());
			}
		}
		
	
}
