package seleniumJava;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Snippet
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
		

		 System.setProperty("webdriver.chrome.driver","C:\\Selenium server\\chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     
	     driver.navigate().to("http://182.74.238.209/clarion_promise_qa/promise/log_promise.php");
	     driver.findElement(By.name("txtUsername")).sendKeys("sanjeetk@clariontechnologies.co.in");
	     driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("clarion");
	     driver.findElement(By.xpath("//input[@name='submit1']")).click();
	     
	     // Add Promise
	     driver.findElement(By.partialLinkText("Promise")).click(); //4FD8CA8F7257FFE0BF0D13098D160895
	     Select sel = new Select(driver.findElement(By.name("cboEmp")));
		 sel.selectByValue("4FD8CA8F7257FFE0BF0D13098D160895");
		 driver.findElement(By.xpath("//textarea[@id='txtPromise']")).sendKeys("This is Selenium Test");
	     Thread.sleep(2500);
	     driver.findElement(By.id("btnSubmit")).click();
	     
	     // Verify Promice.
	     String exp ="This is Selenium Test for QA";
	     
	     driver.findElement(By.xpath("//select[@id='cboEmp']")).click();
	     Select sel1 = new Select(driver.findElement(By.xpath("//select[@id='cboEmp']")));
		 sel1.selectByVisibleText("Sonali test");
		 
		 driver.findElement(By.name("txtStartDate")).sendKeys("01-09-2020");
		 driver.findElement(By.id("txtEndDate")).sendKeys("02-09-2020");
		 Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='cboStatus']")));
		 sel2.selectByVisibleText("Waiting For Reply");
		 driver.findElement(By.name("btnSearch")).click();
		 String act  = driver.findElement(By.xpath("//td[contains(text(),'This is Selenium Test for QA')]")).getText();
		 if (exp.equals(act)) 
		 {
				System.out.println("Strings are equal");
			} else {
				System.out.println("Strings are NOT equal");
			}
	    
		 driver.findElement(By.linkText("http://182.74.238.209/clarion_promise_qa/logout.php")).click();
		 
	     driver.close();
	}
}

