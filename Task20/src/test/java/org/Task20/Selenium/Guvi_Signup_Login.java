package org.Task20.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Guvi_Signup_Login {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Step 1 launch the browser and Navigate to Given URL
		driver = new ChromeDriver();
		driver.navigate().to("https://www.guvi.in/");
		driver.manage().window().maximize();
		Timeouts handletime = driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Step 2 Click the SignUp Button
		WebElement signupbutton= driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary text-white px-4']"));
		signupbutton.click();
		
		//Step 3 and 4 Fill up the SignUp details and Click SignUpbutton
		WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstname.sendKeys("Deva");
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastname.sendKeys("Anandhan");
		WebElement emailid = driver.findElement(By.xpath("//input[@id='emailInput']"));
		emailid.sendKeys("11test@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='passwordInput']"));
		password.sendKeys("Batman111@#");
		WebElement mobileNum = driver.findElement(By.xpath("//input[@id='mobileNumberInput']"));
		mobileNum.sendKeys("8125499998");
		WebElement signupbutton1= driver.findElement(By.xpath("//button[@id='signup']"));
		signupbutton1.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Step 5 Verify Success Registered
		WebElement displaymessage = driver.findElement(By.xpath("//h2[text()='Successfully Registered']"));
		displaymessage.getText();
		if (displaymessage.equals("Successfully Registered")) 
		{
			System.out.println("Registration is Success");
		} else {
			System.out.println("Registration is UnSuccess");
		}
		
		//Step 6 Login Functions 
		WebElement proceedsignin = driver.findElement(By.xpath("//a[@id='status_proceed']"));
		proceedsignin.click();
		WebElement emailbox =  driver.findElement(By.id("login_email"));
		emailbox .sendKeys("11test@gmail.com");
		Thread.sleep(5000);
		WebElement passwordbox =  driver.findElement(By.xpath("//input[@id='login_password']"));
		passwordbox.sendKeys("Batman111@#");
		Thread.sleep(5000);
		WebElement loginbutton =  driver.findElement(By.id("login_button"));
		loginbutton.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Step 7 Verify User Login Successfully
		String title = driver.getTitle();
		if(title.contains("courses")) {
			System.out.println("Login Successfull");
		}else {
			System.out.println("Login UnSuccessfull");
		}
		
		//Step 8
		driver.close();
	}

}
