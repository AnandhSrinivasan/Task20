package org.Task20.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Guvi_Signup_Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Step 1 launch the browser and Navigate to Given URL
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.guvi.in/");
		driver.manage().window().maximize();
		Timeouts handletime = driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Step 2 Click the SignUp Button
		WebElement signupbutton= driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary text-white px-4']"));
		signupbutton.click();
		
		//Step 3 and 4 Fill up the SignUp details and Click SignUpbutton
		WebElement firstname = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstname.sendKeys("Muruganandh");
		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastname.sendKeys("Srinivasan");
		WebElement emailid = driver.findElement(By.xpath("//input[@id='emailInput']"));
		emailid.sendKeys("devanandh2902@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='passwordInput']"));
		password.sendKeys("Batman12@#");
		WebElement mobileNum = driver.findElement(By.xpath("//input[@id='mobileNumberInput']"));
		mobileNum.sendKeys("9566259258");
		WebElement signupbutton1= driver.findElement(By.xpath("//button[@id='signup']"));
		signupbutton1.click();
		
		//Step 5 Verify Success Registered
		String displaymessage = driver.findElement(By.xpath("//h2[@id='status_title']")).getText();
		
		if (displaymessage.contains("Successfully")) {
			System.out.println("registration is Success");
		} else {
			System.out.println("registration is UnSuccess");
		}
		
		//Step 6 Login Functions 
		WebElement proceedsignin = driver.findElement(By.xpath("//a[@id='status_proceed']"));
		proceedsignin.click();
		WebElement emailbox =  driver.findElement(By.id("login_email"));
		emailbox .sendKeys("devanandh2902@gmail.com");
		WebElement passwordbox =  driver.findElement(By.id("login_email"));
		passwordbox.sendKeys("Batman12@#");
		WebElement loginbutton =  driver.findElement(By.id("login_button"));
		loginbutton.click();
		
		//Step 7 Verify User Login Successfully
		
		String title = driver.getTitle();
		if(title.contains("courses")) {
			System.out.println("Login Successfull");
		}else {
			System.out.println("Login Unsuccessfull");
		}
		
		
		//Step 8
		driver.close();
	}

}
