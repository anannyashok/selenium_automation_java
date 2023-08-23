package co.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Launchbrowser 
{
public static  WebDriver  driver = null;

	public static void main(String[] args) throws InterruptedException
	{
    System.setProperty("webdriver.edge.driver", ".\\edgedriver\\msedgedriver.exe");
    driver = new EdgeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    //Open the Web Application
    driver.navigate().to("https://amazon.in");
    driver.manage().window().maximize();
    String title = driver.getTitle();
    if(title.equalsIgnoreCase("Amazon.in"))
    	System.out.println("Title matches");
    else
    	System.out.println(title);
    
    //Typing the Text
    WebElement myElement = driver.findElement(By.id("twotabsearchtextbox"));
    myElement.sendKeys("Harry Potter Philosophers stone book");
    driver.findElement(By.cssSelector("#nav-search-submit-button")).click();
    Thread.sleep(2000);
    
    // Scroll to the book
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("scrollBy(0, 500)");
    //Select the Book
    driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
    Thread.sleep(2000);
    
    //Shift the Tab control
    java.util.Set<String> handles = driver.getWindowHandles();
    String winHandle1 = driver.getWindowHandle();
    handles.remove(winHandle1);
    Thread.sleep(2000);
    
    String winHandle=handles.iterator().next();
    String winHandle2 =  " ";
    if (winHandle!=winHandle1)
    {
    	winHandle2 = winHandle;
    	driver.switchTo().window(winHandle2);
    	System.out.println(winHandle2);
    }
   Thread.sleep(2000);
   
   // Add to Cart
   
  js.executeScript("scrollBy(0, 500)");
   
   driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
   Thread.sleep(5000);
   
    
	
	
	}

}
