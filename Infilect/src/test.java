import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class test 
{
	   public static void main(String[] args) throws InterruptedException 
	   {
		// test using chrome driver 
		System.setProperty("webdriver.chrome.driver", "C://selenium//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://google.com");
		driver.get("https://huew.co");// website for executing automation
		Thread.sleep(15000);

		//driver.findElement(By.id("icon-user-desktop")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/a[6]/div[1]")).click();//clicking event of YOU
		driver.findElement(By.xpath("//div[contains(@class,'login-buttons-container')]//img[1]")).click(); // login using facebook
		String parent_window = driver.getWindowHandle();// switching window fun		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		while (i1.hasNext()) 
		{
			
			String child_window = i1.next(); 
			if (!parent_window.equalsIgnoreCase(child_window))
			{
			driver.switchTo().window(child_window);// switching to child window 
			Thread.sleep(10000);
			System.out.println(driver.getTitle());
			driver.findElement(By.name("email")).sendKeys(new String[] {"enterusername"});// entering username 
			driver.findElement(By.name("pass")).sendKeys(new String[] {"enterpassword"});//entering password
			driver.findElement(By.id("loginbutton")).click();
			Thread.sleep(15000);

			//driver.close();
			}
		}
		driver.switchTo().window(parent_window);// switching back to parent window 
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div[contains(@class,'ng-scope')]//a[2]//div[1]//div[1]")).click();// click discover
		driver.findElement(By.xpath("//input[contains(@name,'file')]")).sendKeys("D:\\My Doc\\Programs\\Java_Programs\\Infilect\\white-crew-neck-t-shirt-light-blue-ripped-skinny-jeans-white-slip-on-sneakers-large-26527.jpg");   //uploading file 
		// In above line we have to set the path fo the image 
		driver.findElement(By.xpath("//button[@class='desktop-photo-submit desktop-photo-submit-highlight ng-scope']")).click();// clicking submit
		driver.findElement(By.xpath("//button[@class='desktop-photo-submit desktop-photo-submit-highlight ng-scope']")).click();// clicking save
		System.out.println("Test complete");

		
		
		
	}
}