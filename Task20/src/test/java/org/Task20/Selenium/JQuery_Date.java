package org.Task20.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQuery_Date {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Step1 Launch Browser, Maximize it, Navigate to URL
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://jqueryui.com/datepicker/");
		//Thread.sleep(2000);
		
		//Step2 Switch to iFrame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.switchTo();
		//Thread.sleep(4000);
		
		//Step3 Select Next Month
		
		//A.Click the date picker
		WebElement dateInput =  driver.findElement(By.xpath("//input[@id='datepicker']"));
		dateInput .click();
		//B.Click the Next to change the Month
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		//Thread.sleep(4000);
		
		//Step4 Select Date 22 from the Next Month
		WebElement date=  driver.findElement(By.xpath("//a[text()='22']"));
		date.click();
		String printthedate = dateInput.getAttribute("value");
		//Thread.sleep(4000);
		
		//Step6 Print the Selected date in Console
		System.out.println("Selected date is : " + printthedate);
		//Thread.sleep(5000);
		
		//Step 5 Close the browser
		driver.close();
		driver.quit();

	}

}
